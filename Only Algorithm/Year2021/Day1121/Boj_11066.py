import sys

input = sys.stdin.readline
T = int(input())
for tc in range(T):
    n = int(input())
    li = list(map(int, input().split()))
    dp = [[[0] * 2 for _ in range(n)] for _ in range(n)]
    for i in range(n):
        dp[i][i][0] = li[i]
    for mi in range(1, n):
        for i in range(n - mi):
            sv, ac = 0, -1
            for j in range(i, i + mi):
                temp_ac = dp[i][j][1] + dp[j + 1][mi + i][1]
                if ac < 0:
                    ac = temp_ac
                    sv = dp[i][j][0] + dp[j + 1][mi + i][0]
                else:
                    ac = min(ac, temp_ac)
            dp[i][mi + i][0], dp[i][mi + i][1] = sv, sv + ac
    print(dp[0][n - 1][1])
