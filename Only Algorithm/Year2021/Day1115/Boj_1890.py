import sys

input = sys.stdin.readline
n = int(input())
li = []
dp = [[0] * n for _ in range(n)]
for i in range(n):
    li.append(list(map(int, input().split())))
dp[0][0] = 1
for i in range(n):
    for j in range(n):
        k = li[i][j]
        if k == 0:
            continue
        if 0 <= i + k < n:
            dp[i + k][j] += dp[i][j]
        if 0 <= j + k < n:
            dp[i][j + k] += dp[i][j]
print(dp[n - 1][n - 1])
