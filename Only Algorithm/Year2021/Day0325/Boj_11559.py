# 1. 세로로 보면서 각각의 색 위치에서 DFS를 부른다.
# 1-1 DFS는 색의 개수를 세고 4개 이상이면 체크를 해둔다.
# 1-2 모든 점에 대해서 실행이 다 끝나면 체크된 색을 모두 .으로 바꾼다.
# 2. 세로로 한줄을 가지고 와서 색을 차례대로 적는다.
# 3. 다 점으로 바꾼 뒤 색을 차례대로 적어준다.
# 1-3까지 반복하다 체크가 존재하지 않으면 break를 하고 출력한다.


def dfs(y, x):
    visit.add((y, x))
    for di in range(4):
        nx = x + dx[di]
        ny = y + dy[di]
        if not (0 <= nx < 6 and 0 <= ny < 12):
            continue
        if (ny, nx) in visit:
            continue
        if puyo[y][x] != puyo[ny][nx]:
            continue
        dfs(ny, nx)


dx = [0, 0, -1, 1]
dy = [1, -1, 0, 0]
puyo = []
for i in range(12):
    puyo.append(list(input()))
chain = 0
while True:
    checklist = set()
    for i in range(6):
        for j in range(12):
            if puyo[j][i] == '.':
                continue
            if (j, i) in checklist:
                continue
            visit = set()
            dfs(j, i)  # 좌표로 부름
            if len(visit) >= 4:
                checklist = checklist.union(visit)
    if not checklist:
        break
    chain += 1
    for y,x in checklist:
        puyo[y][x] = '.'
    for i in range(6):
        colors = []
        for j in range(12):
            if puyo[j][i] == '.':
                continue
            colors.append(puyo[j][i])
            puyo[j][i] = '.'
        for j in range(12)[::-1]:
            if colors:
                puyo[j][i] = colors.pop()
            else:
                break
print(chain)