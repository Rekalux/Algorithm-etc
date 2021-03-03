import heapq
import sys

# heapq 대신 priorityQueue를 써보았다. 내부적으로 어떻게 동작하는 지는 모르지만 확실한 건 heapq보다 더 느리다.
# 백준 기준 heapq에서는 돌아가는 코드가 priorityQueue로는 시간초과가 나는 모습을 보여준다.

imput = sys.stdin.readline
n = int(input())
li = []
for i in range(n):
    a, b = map(int, input().split())
    li.append([min(a, b), max(a, b)])
x = int(input())
nli = []
for i in li:
    if i[1] - i[0] <= x:
        nli.append(i)
nli.sort(key=lambda X: X[1])
pq = []
result = 0
for i in nli:
    heapq.heappush(pq, i[0])
    while pq:
        get_num = heapq.heappop(pq)
        start = i[1] - x
        if start <= get_num:
            heapq.heappush(pq, get_num)
            break
    result = max(result, len(pq))
print(result)
