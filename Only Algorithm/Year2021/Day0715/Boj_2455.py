n, x = 0, 0
for i in range(4):
    li = list(map(int, input().split()))
    n -= (li[0] - li[1])
    x = max(n, x)
print(x)
