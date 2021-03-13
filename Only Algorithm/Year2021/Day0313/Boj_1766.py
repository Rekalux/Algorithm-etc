import heapq

n, m = map(int, input().split())
link = [set() for _ in range(n + 1)]
link_num = [0] * (n + 1)
for i in range(m):
    start, end = map(int, input().split())
    link[start].add(end)
    link_num[end] += 1
q = []
for i in range(1, n + 1):
    if not link_num[i]:
        heapq.heappush(q, i)
while q:
    num = heapq.heappop(q)
    print(num, end=' ')
    for i in link[num]:
        link_num[i] -= 1
        if not link_num[i]:
            heapq.heappush(q, i)
