n = int(input())
li = list(map(int, input().split()))
dp = [0] * (n + 1)
for i in range(1, n + 1):
    for j in range(i, n + 1):
        dp[j] = max(dp[j - i] + li[i - 1], dp[j])
print(dp[n])
