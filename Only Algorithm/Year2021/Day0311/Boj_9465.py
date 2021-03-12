T = int(input())
for _ in range(T):
    n = int(input())
    up = list(map(int, input().split()))
    down = list(map(int, input().split()))
    sticker = [up, down]
    dp = [[0] * n for _ in range(2)]
    for i in range(n):
        if i == 0:
            dp[0][0] = sticker[0][0]
            dp[1][0] = sticker[1][0]
        elif i == 1:
            dp[0][1] = sticker[0][1] + dp[1][0]
            dp[1][1] = sticker[1][1] + dp[0][0]
        else:
            dp[0][i] = sticker[0][i] + max(dp[1][i - 1], dp[1][i - 2])
            dp[1][i] = sticker[1][i] + max(dp[0][i - 1], dp[0][i - 2])
    print(max(dp[0][n - 1], dp[1][n - 1]))
