import heapq
n, k = map(int, input().split())
li = []
for i in range(n):
    m, v = map(int, input().split())
    li.append((m, v))
bag = []
for i in range(k):
    bag.append(int(input()))
li.sort(key=lambda X: X[0])
bag.sort()
li_idx = 0
q = []
result = 0
for i in range(k):
    while li_idx < len(li) and li[li_idx][0] <= bag[i]:
        heapq.heappush(q,-li[li_idx][1])
        li_idx += 1
    if q:
        result += (-heapq.heappop(q))
print(result)
