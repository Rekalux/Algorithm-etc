n = int(input())
dp = [[] for _ in range(n + 1)]
dp[1] = [1]
for i in range(2, n + 1):
    a = [j for j in dp[i-1]]
    if not i % 3 and len(a) > len(dp[i//3]):
        a = [j for j in dp[i//3]]
    if (not i % 2) and len(a) > len(dp[i//2]):
        a = [j for j in dp[i//2]]
    a.append(i)
    dp[i] = [j for j in a]
print(len(dp[n]) - 1)
dp[n].reverse()
print(*dp[n])
