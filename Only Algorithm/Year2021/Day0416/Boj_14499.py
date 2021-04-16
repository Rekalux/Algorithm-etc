y, x, gy, gx, n = map(int, input().split())
M = []
for i in range(y):
    M.append(list(map(int, input().split())))
li = list(map(lambda X:int(X)-1, input().split()))
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]
dice = [0, 0, 0, 0, 0, 0]
def right():
    dice[0], dice[2], dice[3], dice[5] = dice[3], dice[0], dice[5], dice[2]
def left():
    dice[0], dice[2], dice[3], dice[5] = dice[2], dice[5], dice[0], dice[3]
def up():
    dice[0], dice[1], dice[4], dice[5] = dice[1], dice[5], dice[0], dice[4]
def down():
    dice[0], dice[1], dice[4], dice[5] = dice[4], dice[0], dice[5], dice[1]
move = [right,left,up,down]
for i in li:
    ny = gy + dy[i]
    nx = gx + dx[i]
    if not (0<=ny<y and 0<=nx<x):
        continue
    gy = ny
    gx = nx
    move[i]()
    if M[ny][nx] == 0:
        M[ny][nx] = dice[5]
    else:
        dice[5] = M[ny][nx]
        M[ny][nx] = 0
    print(dice[0])