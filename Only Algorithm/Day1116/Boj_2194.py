'''
5 5 2 2 3
2 2
3 2
3 3
4 1
1 4
'''
'''
6 7 2 3 3
1 4
5 4
4 7
1 1
5 5
'''
from collections import deque
import sys
input = sys.stdin.readline
n, m, a, b, k = map(int, input().strip().split()) # 행 / 열 / 유닛행 / 유닛열 / 장애물개수
mapp = [[0] * (m + 2) for _ in range(n + 2)] # 맵을 0으로 초기화

# 가장자리 벽만들기
for i in range(n + 2): # 행 벽
    mapp[i][0] = 1
    mapp[i][m+1] = 1
for i in range(m + 2): # 열 벽
    mapp[0][i] = 1
    mapp[n+1][i] = 1

# 장애물 좌표 지정
for i in range(k):
    temp1, temp2 = map(int, input().strip().split())
    mapp[temp1][temp2] = 1

# 시작 / 목표 값 저장
sy, sx = map(int, input().strip().split())
ey, ex = map(int, input().strip().split())

q = deque()
# 시작 위치 지정
mapp[sy][sx] = 2
q.append((sy, sx, 0))

# 종료 위치 지정
mapp[ey][ex] = 3

dy = [0, 0, -1, 1]
dx = [-1, 1, 0, 0]

cnt = 0


def bfs(y, x, count):
    global cnt

    k_cnt = [0] * 4

    # 열 고정 행만 -> y 돌면서 x-1 확인 (y+a)까지 돌면서 > 왼
    for i in range(y,y+a):
        ny = i
        nx = x-1
        if mapp[ny][nx] == 1:
            k_cnt[0] = 1
            break
    # 열 고정 행만 -> y 돌면서 x+b 확인 (y+a)까지 돌면서 > 오
    for i in range(y,y+a):
        ny = i
        nx = x+b
        if mapp[ny][nx] == 1:
            k_cnt[1] = 1
            break
    # 행 고정 열만 -> x 돌면서 y-1 확인 (x+b)까지 돌면서 > 위
    for i in range(x,x+b):
        ny = y-1
        nx = i
        if mapp[ny][nx] == 1:
            k_cnt[2] = 1
            break
    # 행 고정 열만 -> x 돌면서 y+a 확인 (x+b)까지 돌면서 > 아래
    for i in range(x,x+b):
        ny = y+a
        nx = i
        if mapp[ny][nx] == 1:
            k_cnt[3] = 1
            break

    flag = False
    for i in range(4):
        if k_cnt[i] == 0:
            if mapp[y + dy[i]][x + dx[i]] == 2:
                continue
            flag = True
            mapp[y + dy[i]][x + dx[i]] = 2
            q.append((y + dy[i], x + dx[i], count + 1))
    if not flag:
        cnt = -1


while q:
    v = q.popleft()
    if v[0] == ey and v[1] == ex:
        cnt = v[2]
        break
    bfs(v[0], v[1], v[2])

print(cnt)