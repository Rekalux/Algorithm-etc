from copy import deepcopy
from collections import deque

n = int(input())
li = []
max_num = 1
dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
for i in range(n):
    line = list(map(int, input().split()))
    max_num = max(max_num, max(line))
    li.append(line)
result = 1
for h in range(max_num):
    n_li = deepcopy(li)
    for i in range(n):
        for j in range(n):
            if li[i][j] <= h:
                n_li[i][j] = 0
    count = 0
    for i in range(n):
        for j in range(n):
            if not n_li[i][j]:
                continue
            count += 1
            q = deque()
            n_li[i][j] = 0
            q.append((i, j))
            while q:
                y, x = q.popleft()
                for dir_i in range(4):
                    nx = x + dx[dir_i]
                    ny = y + dy[dir_i]
                    if 0 <= nx < n and 0 <= ny < n and n_li[ny][nx] > 0:
                        q.append((ny, nx))
                        n_li[ny][nx] = 0
    result = max(result, count)
print(result)