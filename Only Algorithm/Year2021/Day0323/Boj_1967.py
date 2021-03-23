import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 5 + 1)


def dfs(x, v):
    global max_node, R
    for nx, xv in link[x]:
        if nx in visit:
            continue
        if v + xv > R:
            max_node = nx
            R = v + xv
        visit.add(nx)
        dfs(nx, v + xv)


n = int(input())
link = [set() for _ in range(n)]
for i in range(n - 1):
    a, b, c = map(int, input().split())
    a, b = a - 1, b - 1
    link[a].add((b, c))
    link[b].add((a, c))
max_node = 0
R = 0
visit = {0, }
dfs(0, 0)  # 현재노드, 밸류
visit = {max_node, }
dfs(max_node, 0)
print(R)
