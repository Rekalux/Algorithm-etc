import sys

sys.setrecursionlimit(10 ** 6)


def find(x):
    if link[x] == -1:
        return []
    f_li = find(link[x])
    f_li.append(link[x])
    return f_li


T = int(input())
for tc in range(T):
    n = int(input())
    link = [-1] * n
    for i in range(n - 1):
        a, b = map(lambda x: int(x) - 1, input().split())
        link[b] = a
    a, b = map(lambda x: int(x) - 1, input().split())
    ali, bli = find(a), find(b)
    ali.append(a)
    bli.append(b)
    top = 0
    result = 1
    l = min(len(ali), len(bli))
    while top < l and ali[top] == bli[top]:
        result = ali[top] + 1
        top += 1
    print(result)
