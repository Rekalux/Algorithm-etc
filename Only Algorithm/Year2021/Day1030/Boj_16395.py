n, k = map(lambda x: int(x) - 1, input().split())
result = 1
k = n - k if n - k < k else k
for i in range(1, k + 1):
    result *= n
    result //= i
    n -= 1
print(result)
