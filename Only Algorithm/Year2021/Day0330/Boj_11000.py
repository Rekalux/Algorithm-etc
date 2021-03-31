import heapq
import sys

input = sys.stdin.readline
n = int(input())
li = []
for i in range(n):
    a, b = map(int, input().split())
    li.append((b, a))
li.sort(key=lambda X: X[1])
cn = 0
c = []
for s in li:
    if c:
        l = heapq.heappop(c)
        while l[0] <= s[1] and c:
            l = heapq.heappop(c)
        if l[0] > s[1]:
            heapq.heappush(c, l)
    heapq.heappush(c, s)
    if len(c) > cn:
        cn = len(c)
print(cn)
