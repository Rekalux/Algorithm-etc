a, b = map(int, input().split())
li = []
for i in range(a):
    li.append(list(map(int, input().split())))

cam = []
for i in range(a):
    for j in range(b):
        if li[i][j] != 0 and li[i][j] != 6:
            cam.append((li[i][j], i, j))
cdir = [0] * len(cam)
mincount = 65
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]


def coloring(y, x, camdir, mapli):
    if not (0 <= y < a and 0 <= x < b) or mapli[y][x] == 6:
        return
    if mapli[y][x] == 0:
        mapli[y][x] = -1
    coloring(y + dy[camdir], x + dx[camdir], camdir, mapli)


def color(camera, camdir, mapli):
    value, y, x = camera
    if value == 1:
        coloring(y, x, camdir, mapli)
    if value == 2:
        coloring(y, x, camdir, mapli)
        coloring(y, x, (camdir + 2) % 4, mapli)
    if value == 3:
        coloring(y, x, camdir, mapli)
        coloring(y, x, (camdir + 1) % 4, mapli)
    if value == 4:
        coloring(y, x, camdir, mapli)
        coloring(y, x, (camdir + 1) % 4, mapli)
        coloring(y, x, (camdir + 2) % 4, mapli)
    if value == 5:
        coloring(y, x, camdir, mapli)
        coloring(y, x, (camdir + 1) % 4, mapli)
        coloring(y, x, (camdir + 2) % 4, mapli)
        coloring(y, x, (camdir + 3) % 4, mapli)


def back(camnum):
    global mincount
    if camnum == len(cam):
        count = 0
        mapli = [[li[i][j] for j in range(b)]for i in range(a)]
        for i in range(len(cam)):
            color(cam[i], cdir[i], mapli)
        for i in range(a):
            for j in range(b):
                if mapli[i][j] == 0:
                    count += 1
        if count < mincount:
            mincount = count
        return
    for i in range(4):
        cdir[camnum] = i
        back(camnum + 1)


back(0)
print(mincount)
