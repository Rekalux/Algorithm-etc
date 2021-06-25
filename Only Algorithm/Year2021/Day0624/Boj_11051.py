def soinsu(num):
    li = []
    for i in range(2,int(pow(num,0.5)+1)):
        if num % i == 0:
            li.append(i)
            li = li + soinsu(num//i)
            break
    if not li:
        li = [num]
    return li

n, k = map(int, input().split())
mo, ja = [], []
for i in range(n, n - k, -1):
    mo.append(i)
for i in range(k, 0, -1):
    ja.append(i)
for i in range(len(ja)):
    for k in soinsu(ja[i]):
        for j in range(len(mo)):
            if mo[j] == 1:
                continue
            if mo[j] % k == 0:
                mo[j] //= k
                break
result = 1
for i in range(len(mo)):
    result *= mo[i]
    result %= 10007
print(result)