def dfs(stack, visit):
    max_node, max_dis = 1, 0
    while stack:
        thisnode, dis = stack.pop()
        for next, next_dis in link[thisnode]:
            if next in visit:
                continue
            new_dis = next_dis + dis
            if max_dis < new_dis:
                max_node = next
                max_dis = new_dis
            visit.add(next)
            stack.append((next, new_dis))
    return (max_node, max_dis)


n = int(input())
link = {}
for _ in range(n):
    line = list(map(int, input().split()))
    node = line[0]
    link[node] = set()
    for i in range(1, len(line) - 1, 2):
        link[node].add((line[i], line[i + 1]))
s = [(1, 0)]  # 처음에는 1번 노드에서 시작 [0]은 노드 번호 [1]은 현재까지 거리
v = {1}  # 방문 집합, 1은 현재위치이므로 초기화
s = [(dfs(s, v)[0], 0)] # 1번 노드에서 가장 먼 노드를 찾음
v = {s[0][0]}
print(dfs(s, v)[1]) # 찾은 노드에서 다시 가장 먼 노드를 찾음
