n, m = map(int, input().split())
li = []


def com(k):
    if k == m:
        print(*li)
        return
    for i in range(1, n + 1):
        li.append(i)
        com(k + 1)
        li.pop()


com(0)
