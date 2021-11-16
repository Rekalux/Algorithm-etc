n, l = map(int, input().split())
r = -1
for i in range(l, 101):
    if i % 2:
        if n % i == 0 and 0 <= (n // i) - (i // 2):
            r = i
            break
    else:
        if (n - (i // 2)) % i == 0 and 0 <= (n // i) - (i // 2) + 1:
            r = i
            break
if r == -1:
    print(-1)
elif r % 2:
    print(*[i for i in range((n // r) - (r // 2), (n // r) + (r // 2) + 1)])
else:
    print(*[i for i in range((n // r) - (r // 2) + 1, (n // r) + (r // 2) + 1)])
