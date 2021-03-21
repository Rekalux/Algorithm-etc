import sys
input = sys.stdin.readline
n = int(input())
dp = [[0] * (n) for _ in range(n)]
nums = list(map(int, input().split()))
for i in range(n):
    ii = i
    jj = i
    while 0 <= ii and jj < n and nums[ii] == nums[jj]:
        dp[ii][jj] = 1
        ii -= 1
        jj += 1
    ii = i
    jj = i+1
    while 0 <= ii and jj < n and nums[ii] == nums[jj]:
        dp[ii][jj] = 1
        ii -= 1
        jj += 1
m = int(input())
for i in range(m):
    a,b = map(int,input().split())
    print(dp[a-1][b-1])
