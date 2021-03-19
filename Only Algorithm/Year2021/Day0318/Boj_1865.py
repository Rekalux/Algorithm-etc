import sys
input = sys.stdin.readline


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
    max_dis = [0]*n
    for i in range(n):
        for j in range(n):
            print(max_dis)
            for next_node in link[j]:
                if max_dis[next_node] > dis[j][next_node] + max_dis[j]:
                    max_dis[next_node] = dis[j][next_node] + max_dis[j]
                    if i == n-1:
                        found = True

    print('YES' if found else 'NO')