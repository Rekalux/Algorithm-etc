def D(n):
    return (2*n) % 10000
def S(n):
    return 9999 if n == 0 else n-1
def L(n):
    return (n-n%1000)//1000 + (n%1000)*10
def R(n):
    return (n%10)*1000 + n//10

import sys
from collections import deque

input = sys.stdin.readline

T = int(input().strip())
for _ in range(T):
    start, goal = map(int,input().strip().split())
    root = ""
    q = deque()
    q.append([start,root])
    result = ""
    visit = [False]*10000
    while q:
        num, r = q.popleft()
        if(num == goal):
            result = r
            break

        d = D(num)
        if not visit[d]:
            visit[d] = True
            q.append([d,r+"D"])
        s = S(num)
        if not visit[s]:
            visit[s] = True
            q.append([s, r + "S"])
        ll = L(num)
        if not visit[ll]:
            visit[ll] = True
            q.append([ll, r+"L"])
        rr = R(num)
        if not visit[rr]:
            visit[rr] = True
            q.append([rr,r+"R"])

    print(result)