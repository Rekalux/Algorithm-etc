n, m = map(int, input().split())
li = list(map(int, input().split()))
start, end = 0, 9999
while start < end:
    mid = (start + end) // 2
    mi = [99999] * n
    ma = [0] * n
    g = [1] * n
    for i in range(n):
        if not i:
            mi[i] = li[i]
            ma[i] = li[i]
            continue
        mi[i] = min(mi[i-1], li[i])
        ma[i] = max(ma[i-1], li[i])
        if ma[i] - mi[i] <= mid:
            g[i] = g[i - 1]
        else:
            g[i] = g[i - 1] + 1
            mi[i] = li[i]
            ma[i] = li[i]
    if m >= g[-1]:
        end = mid
    else:
        start = mid + 1
print(start)
