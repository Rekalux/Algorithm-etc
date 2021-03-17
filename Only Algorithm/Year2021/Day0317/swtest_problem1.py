def coloring(nx, ny, pan, dir):
    if nx < 0 or ny < 0 or nx >= N or ny >= N:
        return True
    if pan[ny][nx] != 0:
        return False
    nx = nx + dx[dir]
    ny = ny + dy[dir]
    if coloring(nx, ny, pan, dir):
        if not (nx < 0 or ny < 0 or nx >= N or ny >= N):
            pan[ny][nx] = 2
        return True
    else:
        return False


def dfs(x, pan, suc):  # 현재번호 x, 그 상황에 맞는 맵, 성공한 개수
    global N, point, max_point, min_value
    if x == len(point):
        if suc < max_point:
            return
        count = 0
        for i in range(N):
            for j in range(N):
                if pan[i][j] == 2:
                    count += 1
        if suc == max_point and count < min_value:
            min_value = count
        elif suc > max_point:
            max_point = suc
            min_value = count
        return
    for i in range(4):
        nx = point[x][1] + dx[i]
        ny = point[x][0] + dy[i]
        if coloring(nx, ny, pan, i):
            if 0 <= ny < N and 0 <= nx < N:
                gpan[ny][nx] = 2
            dfs(x + 1, pan, suc + 1)
            if 0 <= ny < N and 0 <= nx < N:
                gpan[ny][nx] = 0
                while not (nx < 0 or ny < 0 or nx >= N or ny >= N):
                    gpan[ny][nx] = 0
                    nx = nx + dx[i]
                    ny = ny + dy[i]

    dfs(x + 1, pan, suc)


T = int(input())
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
for tc in range(1, T + 1):
    N = int(input())
    gpan = []
    for i in range(N):
        gpan.append(list(map(int, input().split())))
    point = []
    for i in range(N):
        for j in range(N):
            if gpan[i][j]:
                if i == 0 or i == N - 1 or j == 0 or j == N - 1:
                    continue
                point.append((i, j))
    max_point = 0
    min_value = 99999999
    dfs(0, gpan, 0)
    print('#{} {}'.format(tc, min_value))
