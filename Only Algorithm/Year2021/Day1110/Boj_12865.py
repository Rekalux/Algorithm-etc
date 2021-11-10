import sys

input = sys.stdin.readline
n, k = map(int, input().split())
dp = [0] * (k + 1)
for _ in range(n):
    a, b = map(int, input().split())
    for i in range(k, a - 1, -1):
        dp[i] = max(dp[i], dp[i - a] + b)
print(dp[k])
