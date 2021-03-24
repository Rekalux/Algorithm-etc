import sys

input = sys.stdin.readline
N = int(input())
max_num = 9999999999
dp = [[[max_num] * 3 for _ in range(3)] for i in range(N)]
for n in range(N):
    cost = list(map(int, input().split()))
    if not n:
        for c in range(3):
            dp[n][c][c] = cost[c]
        continue
    for i in range(3):
        for j in range(3):
            min_dp = max_num
            for k in range(3):
                if k == i:
                    continue
                min_dp = min(dp[n - 1][k][j], min_dp)
            dp[n][i][j] = min_dp + cost[i]
result = max_num
for i in range(3):
    for j in range(3):
        if i == j:
            continue
        result = min(result, dp[N - 1][i][j])
print(result)
