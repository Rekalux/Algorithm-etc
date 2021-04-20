import sys
input = sys.stdin.readline


def com(a, b, c):
    if a <= 0 or b <= 0 or c <= 0:
        return 1
    elif a > 20 or b > 20 or c > 20:
        if dp[20][20][20] == -1:
            dp[20][20][20] = com(20, 20, 20)
            a, b, c = 20, 20, 20
    elif a < b < c:
        if dp[a][b][c] == -1:
            dp[a][b][c] = com(a, b, c - 1) + com(a, b - 1, c - 1) - com(a, b - 1, c)
    else:
        if dp[a][b][c] == -1:
            dp[a][b][c] = com(a - 1, b, c) + com(a - 1, b - 1, c) + com(a - 1, b, c - 1) - com(a - 1, b - 1, c - 1)
    return dp[a][b][c]


while True:
    li = list(map(int, input().split()))
    if li[0] == li[1] == li[2] == -1:
        break
    dp = [[[-1] * 21 for _ in range(21)] for _ in range(21)]
    print('w({}, {}, {}) = {}'.format(*li, com(*li)))
