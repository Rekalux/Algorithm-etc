n = int(input())
li = sorted(map(int, input().split()))
min_v = 9999999999
result = [0, 0]
for i in range(n):
    find = -li[i]
    start, end = 0, n - 1
    while start < end:
        mid = (start + end) // 2
        if li[mid] == find:
            result[0] = li[i]
            result[1] = li[mid]
            break
        elif li[mid] < find:
            start = mid + 1
        else:
            end = mid
    if start != 0 and start - 1 != i:  # 왼쪽값을 더해서 확인
        hap = abs(li[start - 1] + li[i])
        if min_v > hap:
            min_v = hap
            result[0] = li[i]
            result[1] = li[start - 1]
    # 오른쪽 값을 더해서 확인
    if start != i:
        hap = abs(li[start] + li[i])
        if min_v > hap:
            min_v = hap
            result[0] = li[i]
            result[1] = li[start]
result = [min(result), max(result)]
print(*result)
