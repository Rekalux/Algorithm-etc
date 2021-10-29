import sys

input = sys.stdin.readline
n, r = map(int, input().split())
link = {}
for i in range(n - 1):
    a, b, d = map(int, input().split())
    if a not in link:
        link[a] = set()
    if b not in link:
        link[b] = set()
    link[a].add((b, d))
    link[b].add((a, d))
stack = []
col, bran, swit = 0, 0, True
stack.append((r, 0))
visit = {r}
while stack:
    node, dis = stack.pop()
    if swit:
        col = dis
        if node in link and (len(link[node]) > 2 or (r == node and len(link[node]) > 1)):
            swit = False
    else:
        bran = max(bran, dis)
    if node not in link:
        continue
    for ne, nedis in link[node]:
        if ne in visit:
            continue
        visit.add(ne)
        stack.append((ne, dis + nedis))
print(col, bran - col if bran - col > 0 else 0)
