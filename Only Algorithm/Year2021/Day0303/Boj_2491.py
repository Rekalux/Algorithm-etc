n = int(input())
nums = list(map(int, input().split()))
dp = [[0, 0, 0] for _ in range(n)]  # [0]는 증가 수열 / [1]은 감소 수열 / [2]는 같음 수열
dp[0] = [1, 1, 1]
result = 1
for i in range(1, n):
    a = b = c = 0
    if nums[i - 1] < nums[i]:
        a = max(dp[i - 1][0], dp[i - 1][2])
    elif nums[i - 1] > nums[i]:
        b = max(dp[i - 1][1], dp[i - 1][2])
    else:
        a, b, c = dp[i - 1]
    dp[i] = [a + 1, b + 1, c + 1]
    result = max(result, a + 1, b + 1, c + 1)
print(result)
