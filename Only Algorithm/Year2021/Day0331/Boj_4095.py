import sys

input = sys.stdin.readline
while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    dp2 = []
    for i in range(n):
        dp2.append(list(map(int, input().split())))
    max_num = 0
    dp = [[0 for _ in range(m+2)] for _ in range(n+2)]
    for i in range(1, n+1):
        for j in range(1, m+1):
            x = dp2[i - 1][j - 1]
            dp[i][j] = (min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1) * x
            max_num = max(max_num, dp[i][j])
    print(max_num)
