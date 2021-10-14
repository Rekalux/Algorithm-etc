import sys
from collections import deque

input = sys.stdin.readline

ddx = [0, 0, -1, 1]
ddy = [1, -1, 0, 0]

T = int(input())
for t in range(T):
    y, x = map(lambda x: int(x) + 2, input().split())
    board = []
    board.append(['.'] * x)
    for i in range(y - 2):
        temp = list(input().strip())
        board.append(['.'] + temp + ['.'])
    board.append(['.'] * x)
    keylist = input().strip()
    key = sum(map(lambda x: 1 << ord(x) - ord('a'), keylist)) if keylist != '0' else 0
    visit = {}
    q = deque()
    q.append((0, 0, key))
    count = 0
    while q:
        dy, dx, gkey = q.popleft()
        now = ord(board[dy][dx])
        if ord('A') <= now <= ord('Z') and (1 << (now - ord('A'))) & gkey == 0:
            continue
        if ord('a') <= now <= ord('z') and (1 << (now - ord('a'))) & gkey == 0:
            gkey = gkey + (1 << (now - ord('a')))
            q = deque()
        if now == ord('$'):
            count += 1
            board[dy][dx] = '.'
        for di in range(4):
            nx, ny = dx + ddx[di], dy + ddy[di]
            if nx < 0 or x <= nx or ny < 0 or y <= ny:
                continue
            if board[ny][nx] == '*':
                continue
            if (ny, nx) in visit and gkey in visit[(ny, nx)]:
                continue
            q.append((ny, nx, gkey))
            if (ny, nx) not in visit:
                visit[(ny, nx)] = set()
            visit[(ny, nx)].add(gkey)
    print(count)

# 숏코딩 버전
# import sys
# from collections import deque
# input,o=sys.stdin.readline,ord
# X,Y=[0,0,-1,1],[1,-1,0,0]
# T=int(input())
# for t in range(T):
#     y,x=map(lambda x:int(x)+2,input().split());b=[['.']*x]
#     for i in range(y-2):
#         g=list(input().strip());b.append(['.']+g+['.'])
#     b.append(['.']*x);K=input().strip();k=sum(map(lambda x:1<<o(x)-o('a'),K))if K!='0'else 0;v={};q=deque([(0, 0, k)]);c=0
#     while q:
#         w,e,k=q.popleft();n=o(b[w][e])
#         if o('A')<=n<=o('Z')and(1<<(n-o('A')))&k==0:
#             continue
#         if o('a')<=n<=o('z')and(1<<(n-o('a')))&k==0:
#             k=k+(1<<(n-o('a')));q=deque()
#         if n==o('$'):
#             c+=1;b[w][e]='.'
#         for d in range(4):
#             E,W=e+X[d],w+Y[d]
#             if (E<0 or x<=E or W<0 or y<=W) or b[W][E]=='*' or (W,E)in v and k in v[(W,E)]:
#                 continue
#             q.append((W,E,k))
#             if (W,E)not in v:
#                 v[(W,E)]=set()
#             v[(W,E)].add(k)
#     print(c)
