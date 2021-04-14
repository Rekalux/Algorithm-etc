T = int(input())
for tc in range(1, T + 1):
    n, k = map(int, input().split())
    li = list(map(int, input().split()))
    start, end = 0, 1000000000
    while start < end:
        mid = (start + end) // 2
        d = [0] * n
        min_num = li[0]
        d[0] = li[0]
        for i in range(1, n):
            d[i] = min(li[i], d[i-1] + mid)
        for i in range(n - 2, -1, -1):
            d[i] = min(d[i], d[i+1] + mid)
            if min_num > d[i]:
                min_num = d[i]
        result = 0
        for i in range(n):
            result += (li[i] - d[i])
        if result <= k:
            end = mid
        else:
            start = mid + 1
    print('#{} {}'.format(tc, start))