n, k = map(int, input().split())
mo, ja = [], []
for i in range(n, n - k, -1):
    mo.append(i)
for i in range(k, 0, -1):
    ja.append(i)
for i in range(len(ja)):
    for j in range(len(mo)):
        if mo[j] % ja[i] == 0:
            mo[j] //= ja[i]
            break
result = 1
for i in range(len(mo)):
    result *= mo[i]
    result %= 10007
print(result)
