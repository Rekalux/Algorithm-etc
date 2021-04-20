n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    k = min(a, b)
    v = max(a, b)
    while not (a % k == 0 and b % k == 0):
        k, v = v % k, k
    print(a * b // k)
