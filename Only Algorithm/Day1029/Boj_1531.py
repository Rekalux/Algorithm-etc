n,m = map(int,input().split())
a = [[0]*101 for _ in range(101)]
for _ in range(n):
    x,y,ox,oy = map(int,input().split())
    for i in range(y,oy+1):
        for j in range(x,ox+1):
            a[i][j] += 1
cnt = 0
for i in range(101):
    for j in range(101):
        if a[i][j]>m:
            cnt += 1
print(cnt)