def combination(n, m):
    m = min(m, n - m)
    if dp[n][m] != 0:
        return dp[n][m]
    if not m or n == m:
        return 1
    dap = combination(n - 1, m - 1) + combination(n - 1, m)
    dp[n][m] = dap
    return dap


dp = [[0 for _ in range(j + 1)] for j in range(101)]
print(combination(*map(int, input().split())))
