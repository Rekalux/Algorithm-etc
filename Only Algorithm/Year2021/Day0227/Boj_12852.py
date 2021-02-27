from collections import deque
num = int(input())
q = deque()
q.append([num])
while q:
    n = q.popleft()
    t = n[-1]
    if t == 1:
        print(len(n)-1)
        print(*n)
        break
    if not t % 3:
        q.append(n+[t//3])
    if not t % 2:
        q.append(n+[t//2])
    q.append(n+[t-1])