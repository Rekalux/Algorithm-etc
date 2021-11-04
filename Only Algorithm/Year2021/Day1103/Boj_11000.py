import heapq
n = int(input())
li = []
for _ in range(n):
    li.append(tuple(map(int, input().split())))
li.sort()
q = []
m = 0
for i in range(n):
    while q and q[0] <= li[i][0]:
        heapq.heappop(q)
    heapq.heappush(q, li[i][1])
    m = max(m, len(q))
print(m)