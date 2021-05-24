import sys
n = int(input())
sys.setrecursionlimit(1000000000)
dp = {}


def pibo(n):
    if dp.get(n,0):
        return dp.get(n)
    if n == 0:
        return 0
    if n == 1:
        return 1
    if n == 2:
        return 1
    if n % 2 == 1:
        dp[n] = (pibo(n // 2) ** 2 + (pibo(n // 2 + 1)) ** 2) % 1000000007
        return dp[n]
    else:
        dp[n] = (pibo(n // 2) * (pibo(n // 2 + 1) - pibo(n // 2)) + pibo(n // 2 + 1) * pibo(n // 2)) % 1000000007
        return dp[n]


print(pibo(n))
