from collections import deque

y, x, limit = map(int, input().split())
visit = [[False] * x for _ in range(y)]

princess = []
for i in range(y):
    maker = list(map(int, input().split()))
    princess.append(maker)

# print(y,x,limit)
# print(princess)

# bfs -> 1. 검을 찾는다. / 2. 공주를 찾는다.

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

q = deque()
q.append((0, 0, 0))
dis = 99999999999999
visit[0][0] = True
while q:
    yy, xx, ddis = q.popleft()
    if yy == y - 1 and xx == x - 1:
        dis = min(ddis, dis)
    if princess[yy][xx] == 2:
        dis = min(dis, ddis + (abs(yy - (y - 1)) + abs(xx - (x - 1))))
    ndis = ddis + 1
    for dirr in range(4):
        ny = dy[dirr] + yy
        nx = dx[dirr] + xx
        if (not (0 <= ny < y and 0 <= nx < x)) or visit[ny][nx] or princess[ny][nx] == 1:
            continue
        q.append((ny, nx, ndis))
        visit[ny][nx] = True
print(dis if dis <= limit else "Fail")
