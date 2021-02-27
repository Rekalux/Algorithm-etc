from collections import deque
num = int(input())
q = deque()
q.append([num])
c = [True]*(num+1)
while q:
    n = q.popleft()
    t = n[-1]
    if t == 1:
        print(len(n)-1)
        print(*n)
        break
    if not t % 3 and c[t//3]:
        q.append(n+[t//3])
        c[t//3]=False
    if not t % 2 and c[t//2]:
        q.append(n+[t//2])
        c[t//2]=False
    if c[t-1]:
        q.append(n+[t-1])
        c[t-1]=False