from collections import deque
import sys

input = sys.stdin.readline
n, m = map(int, input().split())
max_int = 9999999999
line = [[max_int for _ in range(n)] for _ in range(n)]
link = dict()
for i in range(n):
    link[i] = set()
for i in range(m):
    a, b, d = map(int, input().split())
    if line[a - 1][b - 1] > d:
        line[a - 1][b - 1] = d
        line[b - 1][a - 1] = d
        link[a - 1].add(b - 1)
        link[b - 1].add(a - 1)
g1, g2 = map(int, input().split())


def dijkstra(start, end):
    q = deque()
    distance = [max_int for _ in range(n)]
    distance[start] = 0
    q.append((start, 0))
    while q:
        node, dis = q.popleft()
        if dis != distance[node]:
            continue
        for obj in link[node]:
            if distance[obj] > line[node][obj] + dis:
                distance[obj] = line[node][obj] + dis
                q.append((obj, distance[obj]))
    return distance[end]


result = dijkstra(0, g1 - 1) + dijkstra(g1 - 1, g2 - 1) + dijkstra(g2 - 1, n - 1)
result = min(dijkstra(0, g2 - 1) + dijkstra(g2 - 1, g1 - 1) + dijkstra(g1 - 1, n - 1), result)
print(result if result < max_int else -1)
