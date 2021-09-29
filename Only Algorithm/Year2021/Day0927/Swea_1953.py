from collections import deque

dir_yx = [[-1, 0], [0, 1], [1, 0], [0, -1]]
# 12시 방향부터 시계방향으로 차례대로
tunnel = {1: {0, 1, 2, 3}, 2: {0, 2}, 3: {1, 3}, 4: {0, 1}, 5: {1, 2}, 6: {2, 3}, 7: {0, 3}}
# 각 터널에 따른 열린 길

def check(dy, dx, dt): # 현재 y좌표, x좌표, 시각
    # 현재 위치를 탈주범이 이동한 위치로 규정하고
    # 다음에 이동할 위치를 저장하는 함수
    next_dir = abs(tmap[dy][dx])
    tmap[dy][dx] = -10 # 이미 탈주범이 온 곳은 -10으로 규정한다.
    for d in tunnel[next_dir]:
        ny = dy + dir_yx[d][0]
        nx = dx + dir_yx[d][1]
        nt = dt + 1
        if ny < 0 or nx < 0 or ny >= y or nx >= x:
            # 범위 밖인 경우
            continue
        if tmap[ny][nx] < 1 or ((d + 2) % 4 not in tunnel[tmap[ny][nx]]):
            # 터널이 아니거나 이미 방문했거나(할 예정이거나) 연결된 터널이 아닌 경우
            # 방향에서 2를 더하고 4로 나눈 나머지는 반대 방향을 의미한다.
            continue
        tmap[ny][nx] = tmap[ny][nx] * (-1) # 같은 시각에 다른 방향에서 온 경우를 방지한다
        q.append([ny, nx, nt])


T = int(input())
for t in range(1, T + 1):
    y, x, sy, sx, turn = map(int, input().split()) # 전체 y, x 맨홀 y, x, 제한시각
    tmap = []
    for i in range(y):
        tmap.append(list(map(int, input().split())))
    q = deque() # bfs룰 위한 queue
    q.append([sy, sx, 1])  # 0번째는 초기 y, 1번째는 초기 x, 2번째는 시작하고 몇 시간인지
    while q:
        next_t = q.popleft()
        if next_t[2] > turn:
            break
        check(*next_t)
    result = sum([1 for m in range(x) for n in range(y) if tmap[n][m] == -10])
    print(f'#{t} {result}')