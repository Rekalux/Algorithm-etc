n = int(input())
li = []
for i in range(n):
    li.append(list(map(int, input().split())))
li.sort()
nli = [x[1] for x in li]
dp = [0] * n
rmax = 0
for i in range(n):
    maxx = 0
    for j in range(i):
        if nli[j] < nli[i] and maxx < dp[j]:
            maxx = dp[j]
    dp[i] = maxx + 1
    if rmax < dp[i]:
        rmax = dp[i]
print(n - rmax)
