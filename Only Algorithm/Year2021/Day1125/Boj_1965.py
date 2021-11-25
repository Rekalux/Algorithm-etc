n = int(input())
li = list(map(int, input().split()))
nli = [1]
for i in range(1, n):
    m = 0
    for j in range(0, i):
        if li[j] < li[i]:
            m = max(m, nli[j])
    nli.append(m + 1)
print(max(nli))
