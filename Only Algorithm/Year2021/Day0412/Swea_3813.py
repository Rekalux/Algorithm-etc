T = int(input())
for tc in range(1, 1 + T):
    n, k = map(int, input().split())
    li = list(map(int, input().split()))
    bl = list(map(int, input().split()))
    start, end = 0, 200000
    while start < end:
        li2 = [-1] * n
        mid = (start + end) // 2
        count = 0
        j = 0
        flag = False
        for i in range(n):
            if li[i] <= mid:
                count += 1
                li2[i] = count
                if count >= bl[j]:
                    count = 0
                    j += 1
                    if j == k:
                        flag = True
                        break
            else:
                count = 0
        if flag:
            end = mid
        else:
            start = mid + 1
    print('#{} {}'.format(tc, start))
