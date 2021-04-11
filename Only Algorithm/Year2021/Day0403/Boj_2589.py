from collections import deque

y, x = map(int, input().split())
m = []
for i in range(y):
    m.append(list(input()))
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
max_dis = 0
for i in range(y):
    for j in range(x):
        if m[i][j] == 'L':
            q = deque()
            q.append((i, j, 0))
            visit = set()
            visit.add((i,j))
            while q:
                nodey, nodex, dis = q.popleft()
                if dis > max_dis:
                    max_dis = dis
                for ii in range(4):
                    ny = dy[ii] + nodey
                    nx = dx[ii] + nodex
                    if 0 <= ny < y and 0 <= nx < x:
                        if (ny, nx) in visit or m[ny][nx] == 'W':
                            continue
                        visit.add((ny, nx))
                        q.append((ny, nx, dis + 1))
print(max_dis)
