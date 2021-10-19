def gcd(a, b):  # 최대공약수 구하는 함수
    a, b = min(a, b), max(a, b)
    if b % a == 0:
        return a
    return gcd(b % a, a)  # 나머지와 제수로 재귀로 구함


n = int(input())
li = []
for i in range(n):
    li.append(int(input()))
nli = []
for i in range(1, n):
    nli.append(abs(li[i - 1] - li[i]))
gcd_n = nli[0]
for i in range(1, len(nli)):
    gcd_n = gcd(gcd_n, nli[i])
li = set()
for i in range(1, int(pow(gcd_n, 0.5)) + 1):
    if gcd_n % i == 0:
        li.add(i)
        li.add(gcd_n // i)
li.remove(1)
print(*sorted(li))
