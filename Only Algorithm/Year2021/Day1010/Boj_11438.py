import sys
from collections import deque

# 11437과 풀이가 동일하다

def maketree(root):  # bfs로 부모를 찾고 깊이를 저장하는 함수
    q = deque([(root, -1)])  # 루트와 부모노드를 함께 저장
    while q:
        node, p = q.popleft()
        for nextnode in link[node]:
            if nextnode == p:
                continue
            table[nextnode].append(node)
            depth[nextnode] = depth[node] + 1
            q.append((nextnode, node))


input = sys.stdin.readline
n = int(input())
link = [set() for _ in range(n)]
table = [[] for _ in range(n)]
depth = [0] * n
for i in range(n - 1):  # input
    a, b = map(lambda x: int(x) - 1, input().split())
    link[a].add(b)
    link[b].add(a)
maketree(0)
for d in range(1, 20):  # log(깊이)만큼 반복, log(100000) = 16.6xxx 이므로 넉넉히 20.
    for i in range(1, n):  # 각 수의 2^d 번째 부모를 구하는 것으로 table을 채운다
        if len(table[i]) < d or len(table[table[i][d - 1]]) < d:
            continue
        table[i].append(table[table[i][d - 1]][d - 1])
m = int(input())
for i in range(m):
    a, b = map(lambda x: int(x) - 1, input().split())
    if depth[a] != depth[b]:  # 두 노드의 깊이를 같게 만든다
        a, b = max(a, b, key=lambda x: depth[x]), min(a, b, key=lambda x: depth[x])  # 깊이가 깊은 쪽을 a로 통일
        while depth[a] != depth[b]:
            for v in range(len(table[a]) - 1, -1, -1):
                if depth[table[a][v]] >= depth[b]:
                    a = table[a][v]
                    break
    while a != b and table[a][0] != table[b][0]:  # 두 수가 같거나 바로 다음 부모가 같을 때까지 반복
        for v in range(len(table[a]) - 1, -1, -1):
            if table[a][v] != table[b][v]:
                a, b = table[a][v], table[b][v]
                break
    print(a + 1 if a == b else table[a][0] + 1)
