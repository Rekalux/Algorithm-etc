from sys import stdin
from collections import deque

input2 = stdin.readline
y, x = map(int, input2().split())
Map = [[-1] * x for _ in range(y)]
start = []
for i in range(y):
    get_list = list(map(int, input2().split()))
    for j in range(x):
        if get_list[j] == 2:
            start = [i, j, 0]
            Map[i][j] = 0
        elif get_list[j] == 0:
            Map[i][j] = 0

dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]

q = deque()
q.append(tuple(start))
while q:
    yy, xx, dis = q.popleft()
    new_dis = dis + 1
    for direction in range(4):
        ny = dy[direction] + yy
        nx = dx[direction] + xx
        if not (0 <= ny < y and 0 <= nx < x):
            continue
        if Map[ny][nx] != -1:
            continue
        Map[ny][nx] = new_dis
        q.append((ny, nx, new_dis))

for m in Map:
    print(*m)
