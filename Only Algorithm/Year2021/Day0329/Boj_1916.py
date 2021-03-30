from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
m = int(input())
link = [set() for _ in range(n)]
for i in range(m):
    a, b, c = map(int, input().split())
    link[a - 1].add((b - 1, c))
start, end = map(int, input().split())
start, end = start - 1, end - 1
dis = [9999999999]*n
dis[start] = 0
q = deque()
q.append((start,0))
while q:
    node,distance = q.pop()
    for i,d in link[node]:
        if dis[i] > distance + d:
            dis[i] = distance + d
            q.append((i,dis[i]))
print(dis[end])