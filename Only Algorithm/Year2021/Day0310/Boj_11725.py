from collections import deque

n = int(input())
link = {}
root = [0] * (n + 1)
for i in range(n - 1):
    a, b = map(int, input().split())
    link[a] = link.get(a, set())
    link[a].add(b)
    link[b] = link.get(b, set())
    link[b].add(a)
q = deque()
q.append(1)
root[1] = -1
while q:
    core = q.popleft()
    for next_point in link[core]:
        if root[next_point]:
            continue
        root[next_point] = core
        q.append(next_point)
print('\n'.join(map(str, root[2:])))

#ㄴㅇㄱ
