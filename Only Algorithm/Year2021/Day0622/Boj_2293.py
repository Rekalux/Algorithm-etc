n, k = map(int, input().split())
li = []
for i in range(n):
    li.append(int(input()))
dp = [0] * (k + 1)
dp[0] = 1
for i in li:
    for j in range(k + 1):
        if j - i < 0:
            continue
        dp[j] = dp[j] + dp[j-i]
print(dp[k])
