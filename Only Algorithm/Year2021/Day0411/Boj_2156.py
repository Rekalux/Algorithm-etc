n = int(input())
li = []
for i in range(n):
    li.append(int(input()))
dp = [[0]*2 for i in range(n)]
for i in range(n):
    if i == 0:
        dp[0] = [li[0],0]
    elif i == 1:
        dp[1] = [li[1],dp[0][0]+li[1]]
    elif i == 2:
        dp[2] = [max(dp[i-2][0],dp[i-2][1])+li[i],dp[i-1][0]+li[i]]
    else:
        dp[i] = [max(max(dp[i-3]),max(dp[i-2]))+li[i],dp[i-1][0]+li[i]]
print(max([max(dp[i]) for i in range(n)]))