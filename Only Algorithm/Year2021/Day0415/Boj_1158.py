from collections import deque
n, k = map(int, input().split())
q = deque()
for i in range(1,n+1):
    q.append(i)
start = k
li = []
while q:
    if start == 1:
        li.append(q.popleft())
        start = k
        continue
    q.append(q.popleft())
    start -= 1
print('<',end='')
for i in range(n):
    print('{}'.format(li[i]),end='')
    if i != n-1:
        print(', ',end='')
print('>')
