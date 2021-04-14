n, m = map(int, input().split())
li = list(map(int, input().split()))
start, end = max(li), sum(li)
while start < end:
    mid = (start + end) // 2
    hap = [0] * n
    g = [1] * n
    for i in range(n):
        if not i:
            hap[i] = li[i]
            continue
        hap[i] = hap[i - 1] + li[i]
        if hap[i] <= mid:
            g[i] = g[i - 1]
        else:
            g[i] = g[i - 1] + 1
            hap[i] = li[i]
    if g[-1] > m:
        start = mid + 1
    else:
        end = mid
print(start)
ans = [1] * m
result = 0
idx = 0
adn = n - m
for i in range(n):
    if adn == 0:
        break
    if i == 0:
        result += li[0]
        continue
    result += li[i]
    if result <= start:
        ans[idx] += 1
        adn -= 1
    else:
        result = li[i]

        idx += 1
print(*ans)
