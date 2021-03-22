import sys

input = sys.stdin.readline
n, m = map(int, input().split())
pan = []
for i in range(n):
    pan.append(list(map(int, input().split())))
sum_pan = [[0] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        left = 0
        up = 0
        left_up = 0
        if i - 1 >= 0:  # 맨 위가 아니면
            up = sum_pan[i - 1][j]
        if j - 1 >= 0:  # 맨 왼쪽이 아니면
            left = sum_pan[i][j - 1]
        if i - 1 >= 0 and j - 1 >= 0:  # 맨 왼쪽이고 맨 위쪽이 아니면
            left_up = sum_pan[i - 1][j - 1]
        sum_pan[i][j] = pan[i][j] + left + up - left_up
for i in range(m):
    a, b, c, d = map(lambda x: int(x) - 1, input().split())
    up = left = left_up = 0
    if a - 1 >= 0:
        up = sum_pan[a - 1][d]
    if b - 1 >= 0:
        left = sum_pan[c][b - 1]
    if a - 1 >= 0 and b - 1 >= 0:
        left_up = sum_pan[a - 1][b - 1]
    now = sum_pan[c][d]
    print(now - up - left + left_up)
