t = int(input())
for i in range(t):
    n, k = map(int,input().split())
    li = list(map(int,input().split()))
    li.sort()
    crack = 200000000
    count = 0
    for i in range(n):
        target = k - li[i]
        start, end = 0, len(li) - 1
        while start < end:
            mid = (start + end) // 2
            if target < li[mid]:
                end = mid
            else:
                start = mid + 1
        if i != start-1 and start > 0 and crack > abs(target - li[start-1]):
            count = 1
            crack = abs(target - li[start-1])
        elif i != start-1 and start > 0 and crack == abs(target - li[start-1]):
            count += 1
        if i != start and crack > abs(target - li[start]):
            count = 1
            crack = abs(target - li[start])
        elif i != start and crack == abs(target - li[start]):
            count += 1
        if i != start-2 and start-2 >= 0 and crack > abs(target - li[start-2]):
            count = 1
            crack = abs(target - li[start-2])
        elif i != start-2 and start-2 >= 0 and crack == abs(target - li[start-2]):
            count += 1
    print(count//2)