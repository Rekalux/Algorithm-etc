import sys

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    n = int(input())
    li = []
    for _ in range(n):
        li.append(tuple(map(int, input().split())))
    li.sort()
    c, m = 1, li[0][1]
    for one in li:
        if m > one[1]:
            c += 1
            m = one[1]
    print(c)
