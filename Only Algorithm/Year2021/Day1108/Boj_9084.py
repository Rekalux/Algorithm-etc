T = int(input())
for _ in range(T):
    n = int(input())
    li = list(map(int, input().split()))
    money = int(input())
    dp = [0] * (money + 1)
    dp[0] = 1
    for gap in li:
        # for i in range(1, money + 1):
        #     if gap > i:
        #         continue
        for i in range(gap, money + 1):
            dp[i] += dp[i - gap]
    print(dp[money])
