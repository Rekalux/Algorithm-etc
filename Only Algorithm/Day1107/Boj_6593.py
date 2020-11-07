from collections import deque
import sys

sys.stdin = open('input.txt')

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

while True:
    a, b, c = map(int, input().split())
    if a == b == c == 0:
        break
    building = []
    q = deque()
    endpoint = []
    for floor in range(a):
        lines = []
        for y in range(b):
            line = []
            s = input()
            for x in range(c):
                if s[x] == 'S':
                    q.append([x, y, floor, 0])
                    line.append('#')
                elif s[x] == 'E':
                    endpoint = [x, y, floor]
                    line.append('.')
                else:
                    line.append(s[x])
            lines.append(line)
        input()
        building.append(lines)

    visit = [[[False] * c for _ in range(b)] for _ in range(a)]
    result = -1
    while q:
        p = q.popleft()
        for direction in range(6):
            nx = dx[direction] + p[0]
            ny = dy[direction] + p[1]
            nz = dz[direction] + p[2]
            if nx < 0 or nx >= c or ny < 0 or ny >= b or nz < 0 or nz >= a:
                continue
            if building[nz][ny][nx] == '#':
                continue
            if visit[nz][ny][nx]:
                continue
            if endpoint[0] == nx and endpoint[1] == ny and endpoint[2] == nz:
                result = p[3] + 1
                break
            visit[nz][ny][nx] = True
            q.append([nx, ny, nz, p[3] + 1])
        if result != -1:
            break
    print(f'Escaped in {result} minute(s).') if result != -1 else print('Trapped!')
