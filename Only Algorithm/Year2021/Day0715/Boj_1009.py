n = int(input())
for _ in range(n):
    a,b = map(int,input().split())
    c = 1
    for _ in range(b):
        c *= a
        c %= 10
    print(c if c != 0 else 10)