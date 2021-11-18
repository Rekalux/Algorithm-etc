a, b, c = map(int, input().split())
c += int(input())
while c >= 60:
    c -= 60
    b += 1
while b >= 60:
    b -= 60
    a += 1
while a >= 24:
    a -= 24
print(a, b, c)
