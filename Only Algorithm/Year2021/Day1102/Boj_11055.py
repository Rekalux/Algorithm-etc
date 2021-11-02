n = int(input())
li = list(map(int, input().split()))
dp = [0] * n
for i in range(n):
    m = 0
    for j in range(i):
        if li[j] < li[i] and m < dp[j]:
            m = dp[j]
    dp[i] = m + li[i]
print(max(dp))