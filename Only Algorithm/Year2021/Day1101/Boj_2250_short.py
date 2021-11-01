import sys
i=sys.stdin.readline
def m(n,d):
    global c
    if l[n][0]>0:m(l[n][0],d+1)
    if d in D:D[d]=min(D[d][0],c),max(D[d][1],c)
    else:D[d]=c,c
    c+=1
    if l[n][1]>0:m(l[n][1],d+1)
def v(x):
    if x in r:r.remove(x)
N,l,D,c,w,R=int(i()),{},{},1,lambda x:D[x][1]-D[x][0],range;r=set(R(1,N+1))
for _ in R(N):n,B,C=map(int,i().split());l[n]=B,C;v(B);v(C)
m(r.pop(),1);k=max(D,key=lambda x:(w(x),-x));print(k,w(k)+1)