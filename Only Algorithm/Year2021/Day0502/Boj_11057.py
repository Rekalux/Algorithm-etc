n = int(input())
pre = [1]*10
result = 10
for i in range(n-1):
    num = [0] * 10
    for j in range(10):
        for k in range(10):
            if j < k:
                continue
            num[j] += pre[k]
    result = 0
    for j in range(10):
        result += num[j]
        result %= 10007
        pre[j] = num[j]
print(result)
