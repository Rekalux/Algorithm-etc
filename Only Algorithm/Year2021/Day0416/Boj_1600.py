from collections import deque

k = int(input())
xx, yy = map(int, input().split())
M = []
for i in range(yy):
    M.append([-k if k == 1 else 50 for k in (map(int, input().split()))])
dx = [0, 1, -1, 0, 1, 1, -1, -1, 2, 2, -2, -2]
dy = [1, 0, 0, -1, 2, -2, 2, -2, 1, -1, 1, -1]
q = deque()
q.append((0, 0, 0, 0))
flag = False
while q:
    y, x, dis, jump = q.popleft()
    if y == yy - 1 and x == xx - 1:
        print(dis)
        flag = True
        break
    for i in range(12):
        ny = y + dy[i]
        nx = x + dx[i]
        if not (0 <= ny < yy and 0 <= nx < xx):
            continue
        if i >= 4:
            if jump == k:
                continue
            njump = jump + 1
        else:
            njump = jump
        if M[ny][nx] <= njump:
            continue
        M[ny][nx] = njump
        q.append((ny, nx, dis + 1, njump))
if not flag:
    print(-1)
