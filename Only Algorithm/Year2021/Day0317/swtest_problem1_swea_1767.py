def coloring(nx, ny, dir): # 전선이 연결 가능한 지 확인하고 전선을 연결하는 함수입니다. 인수는 좌표와 방향을 받습니다.
    if nx < 0 or ny < 0 or nx >= N or ny >= N: # 범위 끝까지 확인을 했다면 전선을 놓을 수 있는 경우 이므로
        return True
        # True를 반환합니다.
    if cells[ny][nx] != 0: # 전선을 연결하려는 공간에 코어나 전선이 있으면. 즉, 전선을 놓으려는 위치가 빈 공간이 아니면
        return False # False를 반환합니다.
    nx = nx + dx[dir] # 해당 방향으로 한칸 더 나아합니다.
    ny = ny + dy[dir]
    if coloring(nx, ny, dir): # 그리고 이 선이 연결 가능 한 지 재귀적으로 확인합니다.
        if 0 <= nx < N and 0 < ny < N: # 전선을 연결할 수 있고, 범위 안의 점이라면
            cells[ny][nx] = 2 # 전선을 설치합니다.
        return True # 그리고 이전 위치도 전선을 설치할 수 있음을 알려 줍니다.
    else:
        return False # 반대의 경우는 전선을 설치할 수 없습니다.


def dfs(x, suc):  # 현재번호 x, 그 상황에 맞는 셀 상태, 전력 공급에 성공한 코어 개수
    global max_point, min_value # 전역변수로 선언
    if suc + (len(core) - x) < max_point: # 남은 번호의 개수가 모두 성공하더라도 최대 포인트에 미치지 못하면
        return # 가지치기
    if x == len(core): # 모든 코어에 대해 상태를 확인했을 때
        count = 0
        for i in range(N): # 각 점을 돌며
            for j in range(N):
                if cells[i][j] == 2: # 전선의 개수를 셉니다.
                    count += 1
        if suc == max_point and count < min_value: # 코어의 개수가 같으면 전선 수가 적게 사용 되는 것을 저장하고
            min_value = count
        elif suc > max_point: # 코어의 개수가 더 많으면
            max_point = suc # 최대 코어의 개수를 갱신합니다.
            min_value = count # 전선의 개수도 갱신합니다.
        return
    for i in range(4): # 4방향에 대해서
        nx = core[x][1] + dx[i] # 새로 변화한 x좌표와
        ny = core[x][0] + dy[i] # 새로 변화한 y좌표를 구합니다.
        if coloring(nx, ny, i): # 그리고 한쪽 방향으로 전선이나 코어가 있는 지 확인하고 없다면 전선을 표시합니다.
            cells[ny][nx] = 2 # 전선이 연결되므로 해당 방향에 전선을 색칠해 줍니다.
            dfs(x + 1, suc + 1) # 그리고 다음 코어에 대해서 상태를 정합니다.
            if 0 <= ny < N and 0 <= nx < N: # dfs 함수 이후에는 해당 방향의 전선을 다시 지워줘야 하므로
                cells[ny][nx] = 0 # 해당 방향의 전선과
                while not (nx < 0 or ny < 0 or nx >= N or ny >= N): # 범위 끝까지의 전선을 회수합니다.
                    cells[ny][nx] = 0
                    nx = nx + dx[i]
                    ny = ny + dy[i]
    dfs(x + 1, suc) # 만약 현재 코어가 활성화 되지 않아야 더 많은 코어가 활성화 될 수도 있으므로
    # 현재 코어는 전선을 연결하지 않은 채로 다음 코어의 상태를 정합니다.


T = int(input()) # 테스트케이스를 입력 먼저 받음
dx = [1, -1, 0, 0] # x 방향 배열
dy = [0, 0, -1, 1] # y 방향 배열
for tc in range(1, T + 1):
    N = int(input())
    cells = []
    for i in range(N):
        cells.append(list(map(int, input().split())))
    core = [] # 코어의 위치를 저장하기 위한 배열
    for i in range(N):
        for j in range(N):
            if cells[i][j]: # 이때, 겉에 있는 코어의 위치는 제외합니다.
                if i == 0 or i == N - 1 or j == 0 or j == N - 1:
                    continue
                core.append((i, j)) # 코어의 위치를 저장
    max_point = 0 # 최대 사용 코어를 저장할 변수
    min_value = 99999999 # 최소 사용 전선을 저장할 변수
    dfs(0, 0) # dfs 함수를 활용
    print('#{} {}'.format(tc, min_value)) # 출력 형식에 맞게 출력합니다.
