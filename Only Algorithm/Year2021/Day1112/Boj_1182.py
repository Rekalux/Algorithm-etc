n, s = map(int, input().split())
li = list(map(int, input().split()))
result = 0
for i in range(1, 1 << n):
    su = 0
    for j in range(n):
        if i & (1 << j):
            su += li[j]
    if su == s:
        result += 1
print(result)

