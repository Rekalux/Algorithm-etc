N,r,c = map(int,input().split())
n = (2 ** N)
r = r+1
c = c+1
sr, sc, er, ec, sn, en = 0,0,n,n,0,n**2
while sr + 1 != er or sc + 1 != ec:
    mr, mc = (sr+er)/2, (sc+ec)/2
    if sr<r<=mr and sc<c<=mc:
        er, ec = mr, mc
        en = sn + (en-sn)/4
    elif sr<r<=mr and mc<c<=ec:
        er, sc = mr, mc
        sn, en = sn + (en-sn)/4, sn + (en-sn)/2
    elif mr<r<=er and sc<c<=mc:
        sr, ec = mr, mc
        sn, en = sn + (en-sn)/2, sn + (en-sn)*3/4
    else:
        sr, sc = mr, mc
        sn = sn+(en-sn)*3/4
print(int(sn))