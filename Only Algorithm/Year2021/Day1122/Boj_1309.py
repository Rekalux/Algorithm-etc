n = int(input())
dp = [[0] * 2 for _ in range(n)]
dp[0][0] = 2
dp[0][1] = 1
for i in range(1, n):
    dp[i][0], dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] * 2) % 9901, sum(dp[i - 1]) % 9901
print(sum(dp[-1]) % 9901)
