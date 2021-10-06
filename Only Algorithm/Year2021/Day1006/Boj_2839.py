n = int(input())
dp = [-1] * (n + 1)
dp[0] = 0
for i in range(n + 1):
    if i >= 3:
        dp[i] = dp[i - 3] + 1 if dp[i - 3] >= 0 else -1
    if i >= 5 and dp[i - 5] >= 0:
        dp[i] = min(dp[i] if dp[i] >= 0 else dp[i - 5] + 1, dp[i - 5] + 1)
print(dp[n])
