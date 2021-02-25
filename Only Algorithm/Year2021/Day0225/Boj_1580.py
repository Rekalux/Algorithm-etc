from collections import deque

y, x = map(int, input().split())
Map = [[False] * x for _ in range(y)]
A, B = [0, 0], [0, 0]
for i in range(y):
    get_list = list(input())
    for j in range(x):
        if get_list[j] == 'X':
            Map[i][j] = True  # 갈 수 없는 길이면 True
        elif get_list[j] == 'A':
            A = [i, j]
        elif get_list[j] == 'B':
            B = [i, j]
visit = [[[[False] * x for _ in range(y)] for _ in range(x)] for _ in range(y)]
visit[A[0]][A[1]][B[0]][B[1]] = True  # 이미 사용한 경우 True

dx = [0, 0, 1, -1, 1, 1, -1, -1, 0]
dy = [1, -1, 0, 0, 1, -1, 1, -1, 0]
q = deque()
q.append((A, B, 0))
result = 0
while q:
    a, b, dis = q.popleft()
    if A[0] == b[0] and A[1] == b[1] and B[0] == a[0] and B[1] == a[1]:
        result = dis
        break
    new_dis = dis + 1
    for direction in range(9):
        ax = dx[direction] + a[1]
        ay = dy[direction] + a[0]
        if not (0 <= ax < x and 0 <= ay < y):
            continue
        if Map[ay][ax]:
            continue
        for direction2 in range(9):
            bx = dx[direction2] + b[1]
            by = dy[direction2] + b[0]
            if not (0 <= bx < x and 0 <= by < y):
                continue
            if Map[by][bx]:
                continue
            if visit[ay][ax][by][bx]:
                continue
            if ax == bx and ay == by:
                continue
            if ax == b[1] and ay == b[0] and bx == a[1] and by == a[0]:
                continue
            visit[ay][ax][by][bx] = True
            q.append(([ay, ax], [by, bx], new_dis))
print(result if result else -1)
