from collections import deque
from pprint import pprint

y,x = map(int,input().split())
ice = []
for i in range(y):
    newice = list(map(int,input().split()))
    ice.append(newice)
year = 0
dx = [0,0,-1,1]
dy = [1,-1,0,0]
while True:
    count = 0
    visit = [[False] * x for _ in range(y)]
    for i in range(y):
        for j in range(x):
            if ice[i][j] and not visit[i][j]:
                count += 1
                visit[i][j] = True
                q = deque()
                q.append((i,j))
                while q:
                    yy,xx = q.popleft()
                    for k in range(4):
                        ny = yy+dy[k]
                        nx = xx+dx[k]
                        if ny < 0 or ny >= y or nx < 0 or nx >= x:
                            continue
                        if visit[ny][nx]:
                            continue
                        if not ice[ny][nx]:
                            continue
                        q.append((ny,nx))
                        visit[ny][nx] = True
    if count != 1:
        if count == 0:
            year = 0
        break
    ice2 = [[0] * x for _ in range(y)]
    for i in range(y):
        for j in range(x):
            for k in range(4):
                if not ice[i][j]:
                    break
                ny = i-dy[k]
                nx = j-dx[k]
                if ny < 0 or ny >= y or nx < 0 or nx >= x:
                    continue
                if ice[ny][nx]:
                    continue
                ice2[i][j] += 1
    for i in range(y):
        for j in range(x):
            ice[i][j] -= ice2[i][j]
            if ice[i][j]<0:
                ice[i][j] = 0
    year+=1
print(year)
