n = int(input())
alpha = {}
for _ in range(n):
    g = input()
    for i in range(len(g)):
        alpha[g[i]] = alpha.get(g[i], 0) + (10 ** (len(g) - i - 1))
a = list(alpha)
a.sort(key=lambda x: -alpha[x])
result = 0
c = 9
for i in range(len(a)):
    result += (alpha[a[i]] * c)
    c -= 1
print(result)
