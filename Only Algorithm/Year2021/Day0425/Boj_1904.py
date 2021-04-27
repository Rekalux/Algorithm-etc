n = int(input())
dp = []
for i in range(n + 1):
    if i == 0:
        dp.append(1)
    elif i == 1:
        dp.append(1)
    else:
        dp.append((dp[i - 2] + dp[i - 1]) % 15746)
print(dp[n])
