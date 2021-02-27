n = int(input())
d = [[] for _ in range(n + 1)]
d[1] = [0, 0]
for i in range(2, n + 1):
    a = [i - 1, d[i - 1][1]]
    j, k = i // 3, i // 2
    if not i % 3 and a[1] > d[j][1]:
        a = [j, d[j][1]]
    if not i % 2 and a[1] > d[k][1]:
        a = [k, d[k][1]]
    a[1] += 1
    d[i] = [j for j in a]
print(d[n][1])
while n:
    print(n, end=' ')
    n = d[n][0]
