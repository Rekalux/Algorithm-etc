import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
link = [set() for _ in range(n)]
for i in range(n - 1):
    a, b, dis = map(int, input().split())
    a, b = a - 1, b - 1
    link[a].add((b, dis))
    link[b].add((a, dis))
m = int(input())
table = [[] for _ in range(n)]
depth = [-1] * n
depth[0] = 0
q = deque([0])
while q:
    a = q.popleft()
    for nextnode in link[a]:
        node, ndis = nextnode
        if depth[node] != -1:
            continue
        depth[node] = depth[a] + 1
        table[node].append((a, ndis))
        q.append(node)
for d in range(1, 17):
    for i in range(1, n):
        if len(table[i]) <= d - 1:
            continue
        pnode, dis = table[i][d - 1]
        if len(table[pnode]) <= d - 1:
            continue
        premother = table[pnode][d - 1]
        table[i].append((premother[0], premother[1] + dis))
for i in range(m):
    a, b = map(lambda x: int(x) - 1, input().split())
    total_dis = 0
    if depth[a] < depth[b]:
        a, b = b, a
    if depth[a] != depth[b]:
        for i in range(17, -1, -1):
            temp = depth[a] - depth[b]
            if temp >= (1 << i):
                temp_a = table[a][i]
                a = temp_a[0]
                total_dis += temp_a[1]
    if a == b:
        print(total_dis)
    else:
        while table[a][0][0] != table[b][0][0]:
            for i in range(len(table[a]) - 1, -1, -1):
                if table[a][i][0] != table[b][i][0]:
                    a_temp, b_temp = table[a][i], table[b][i]
                    total_dis = total_dis + a_temp[1] + b_temp[1]
                    a, b = a_temp[0], b_temp[0]
                    break
        print(total_dis + table[a][0][1] +table[b][0][1])
