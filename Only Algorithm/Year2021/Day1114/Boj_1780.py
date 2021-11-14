import sys

input = sys.stdin.readline
n = int(input())
li = []
for i in range(n):
    li.append(list(map(int, input().split())))

dic = {-1: 0, 0: 0, 1: 0}


def div(k, i, j):
    val, sig = li[i][j], True
    if k == 1:
        dic[val] += 1
        return
    for ii in range(i, i + k):
        for jj in range(j, j + k):
            if not sig:
                break
            sig = val == li[ii][jj] and sig
    if sig:
        dic[val] += 1
        return
    else:
        for p in range(3):
            for q in range(3):
                div(k // 3, i + k // 3 * p, j + k // 3 * q)


div(n, 0, 0)
print(*[dic[i] for i in sorted(dic.keys())])
