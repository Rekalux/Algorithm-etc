n, m = map(int, input().split())
road = []
for _ in range(m):
    a, b, c = map(int, input().split())
    a, b = min(a, b) - 1, max(a, b) - 1
    road.append([a, b, c])
road.sort(key=lambda x: x[2])

link = {i: i for i in range(n)}  # 연결점
obj = {i: 0 for i in range(n)}  # 길이
result = 0
last = 0
for i in range(m):
    start, end, dis = road[i]
    start_temp = start
    end_temp = end
    while link[start_temp] != start_temp:
        start_temp = link[start_temp]
    while link[end_temp] != end_temp:
        end_temp = link[end_temp]
    if start_temp == end_temp:
        continue
    if obj[end_temp] < obj[start_temp]:  # 길이가 짧은 쪽을 선택해
        link[end_temp] = link[start_temp]  # 집어 넣는다.
    else:
        link[start_temp] = link[end_temp]
        if obj[end_temp] == obj[start_temp]:  # 길이가 같다면
            obj[end_temp] += 1  # 늘어난 쪽의 길이를 올려준다.
    last = dis
    result += dis
result -= last
print(result)

# 참고해볼만한 python 코드 (크루스칼)
# import sys
# input = sys.stdin.readline
#
# V, E = map(int, input().split())
# graph = sorted([list(map(int, input().split())) for _ in range(E)]\
# 	, key=lambda x:x[2])
# parent = [i for i in range(V + 1)]
# answer = 0
#
# def union(a, b):
# 	a, b = find(a), find(b)
# 	if a > b:
# 		a, b = b, a
#
# 	parent[b] = find(a)
#
# def find(n):
# 	if parent[n] == n:
# 		return n
#
# 	parent[n] = find(parent[n])
# 	return parent[n]
#
# cnt = V - 2 # 생각해보니 연결개수는 정점 개수 -2 만큼 연결하면 2그룹만 남는다.
# for edge in graph:
# 	v1, v2, length = edge
# 	if find(v1) == find(v2):
# 		continue
#
# 	cnt -= 1
# 	union(v1, v2)
# 	answer += length
#
# 	if cnt == 0:
# 		break
#
# print(answer)
