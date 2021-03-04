n = int(input())
g = [[0] * 105 for _ in range(105)]
for i in range(1, n + 1):
    x1, y1, dx, dy = map(int, input().split())
    for a in range(y1,y1+dy):
        for b in range(x1,x1+dx):
            g[a][b] = i
c = [0]*(n+1)
for i in range(105):
    for j in range(105):
        c[g[i][j]] += 1
for i in range(1,n+1):
    print(c[i])