import sys
input = sys.stdin.readline
n = int(input())
li = list(map(int, input().split()))
pre = [-1] * n
dis = [1000000001] * n
dis_i = [-1] * n
q = 0
for i in range(n):
    start, end = 0, q
    flag = False
    while start < end:
        mid = (start + end) // 2
        if dis[mid] < li[i]:
            start = mid + 1
        elif dis[mid] > li[i]:
            end = mid
        else:
            flag = True
            break
    if flag:
        continue
    if start == q:
        q += 1
    dis_i[start] = i
    dis[start] = li[i]
    if start != 0:
        pre[i] = dis_i[start-1]
result = []
idx = dis_i[q-1]
while idx >= 0:
    result.append(li[idx])
    idx = pre[idx]
print(q)
print(*reversed(result))