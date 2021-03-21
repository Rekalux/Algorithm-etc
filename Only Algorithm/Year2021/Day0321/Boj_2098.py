import sys
input = sys.stdin.readline
def dfs(now, visit):
    if visit == 0:
        k = dis[0][now]
        if k == 0:
            k = max_int
        return k
    if dp[visit][now] != 0:
        return dp[visit][now]
    min_dis = max_int
    for i in range(n):
        if i == now:
            continue
        if dis[i][now] == 0 or not visit & (1 << i):
            continue
        ndis = dis[i][now] + dfs(i, visit - (1 << i))
        if ndis < min_dis:
            min_dis = ndis
    dp[visit][now] = min_dis
    return dp[visit][now]


n = int(input())
dis = []
max_int = 9999999999
dp = [[0] * n for _ in range(1 << n)]
for i in range(n):
    dis.append(list(map(int, input().split())))
dfs(0, (1 << n) - 2)
print(dp[(1 << n) - 2][0])
