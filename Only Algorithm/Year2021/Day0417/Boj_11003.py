from collections import deque
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
li = list(map(int, input().split()))
result = []
q = deque()
for i in range(n):
    if m <= i:
        k = q.popleft()
        if li[i - m] != k:
            q.appendleft(k)
    while q:
        k = q.pop()
        if k <= li[i]:
            q.append(k)
            q.append(li[i])
            break
    if q:
        k = q.popleft()
        q.appendleft(k)
    else:
        q.append(li[i])
        k = li[i]
    result.append(k)
print(*result)
