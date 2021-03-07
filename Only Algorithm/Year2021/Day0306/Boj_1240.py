from collections import deque

n, m = map(int, input().split())
link = {}
for i in range(n-1):
    start, end, dis = map(int, input().split())
    line = link.get(start, set())
    line.add((end, dis))
    link[start] = line
    line = link.get(end, set())
    line.add((start, dis))
    link[end] = line
for j in range(m):
    q = deque()
    start, end = map(lambda X: int(X), input().split())
    q.append((start, 0))
    visited = set()
    visited.add(start)
    while q:
        s, d = q.popleft()
        if s == end:
            print(d)
            break
        for next_s, cost in link[s]:
            if next_s in visited:
                continue
            visited.add(next_s)
            q.append((next_s, d + cost))
