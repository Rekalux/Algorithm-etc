n = int(input())
dp = [0] * (n + 1)
hdp = [0] * (n + 1)
dp[0] = 1
hdp[0] = 1
for i in range(1, n + 1):
    a, b, c = i - 1, i - 2, i - 3
    if 0 <= b:
        dp[i] = dp[b]
    dp[i] += (hdp[i-1] * 2)
    dp[i] %= 1000000007
    hdp[i] = hdp[i-1] + dp[i]
    hdp[i] %= 1000000007
print(dp[n])
