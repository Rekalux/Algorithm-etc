n = int(input())
for i in range(n):
    a, b = map(int, input().split())
    result = 1
    a = b - a if b - a < a else a
    flag = False
    for j in range(b, b - a,-1):
        result *= j
        flag = True
    for j in range(1,a+1):
        result //= j
        flag = True
    print(result if flag or a == 0 else 0)
