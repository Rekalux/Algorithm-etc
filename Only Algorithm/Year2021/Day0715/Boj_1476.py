e, s, m = 1, 1, 1
E, S, M = map(int, input().split())
count = 1
while e != E or s != S or m != M:
    count += 1
    e = e + 1 if e + 1 < 16 else 1
    s = s + 1 if s + 1 < 29 else 1
    m = m + 1 if m + 1 < 20 else 1
print(count)
