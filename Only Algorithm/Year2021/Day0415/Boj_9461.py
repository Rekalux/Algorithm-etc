n = int(input())
li = []
for i in range(n):
    li.append(int(input()))
dp = [1, 1, 1, 2, 2, 3]
for i in range(5, max(li)):
    dp.append(dp[-1] + dp[-5])
for i in li:
    print(dp[i - 1])
