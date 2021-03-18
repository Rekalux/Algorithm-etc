from collections import deque
import sys
rf = open('testcase.txt','r')
f = open('test1.txt','w')
print = lambda x : f.write(x)
input = rf.readline
T = int(input())
for tc in range(T):
    n, m, w = map(int, input().split())
    link = {i: set() for i in range(n)}
    dis = [[20000] * n for i in range(n)]
    found = False
    for i in range(m):
        a, b, t = map(int, input().split())
        a, b = a - 1, b - 1
        link[a].add(b)
        link[b].add(a)
        if t < dis[a][b]:
            dis[a][b] = t
        if t < dis[b][a]:
            dis[b][a] = t
    for i in range(w):
        a, b, t = map(int, input().split())
        a, b = a - 1, b - 1
        link[a].add(b)
        if -t < dis[a][b]:
            dis[a][b] = -t
    for i in range(n):
        q = deque()
        q.append((i, 0))
        visit = [False] * n
        while q:
            node, cost = q.pop()
            visit[node] = True
            for next_node in link[node]:
                if next_node == i and cost + dis[node][next_node] < 0:
                    found = True
                    break
                if visit[next_node]:
                    continue
                q.append((next_node, cost + dis[node][next_node]))
            if found:
                break
        if found:
            break
    print('YES\n' if found else 'NO\n')

rf.close()
f.close()