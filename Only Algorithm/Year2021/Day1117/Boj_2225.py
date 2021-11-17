a, b = map(int, input().split())
dp = [[1] + [0] * a for _ in 'x' * (b + 1)]
for i in range(1, b + 1):
    for j in range(1, a + 1):
        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000
print(dp[b][a])
