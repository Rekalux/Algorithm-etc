from collections import deque

n = int(input())
mom = list(map(int, input().split()))
delete = int(input())  # 삭제할 노드 번호
root, son, leaf, mom[delete] = mom.index(-1), [0] * n, [0] * n, -2
# son : 자식 노드 수 / leaf : 갖고 있는 리프노드 (본인 포함)
q = deque()
for i in range(n):
    if 0 <= mom[i]:  # 자식 노드로 자식 수 세기
        son[mom[i]] += 1
for i in range(n):  # 리프 노드 찾기
    if son[i] == 0:
        q.append(i)
        leaf[i] = 1
while q:
    node = q.popleft()
    if mom[node] < 0:  # 엄마가 루트거나 잘린 노드라면 무시
        continue
    else:
        leaf[mom[node]] += leaf[node]
        son[mom[node]] -= 1
        if son[mom[node]] == 0:  # 모든 자식의 리프노드를 받았으면
            q.append(mom[node])  # 부모에게 리프노드를 물려준다
print(leaf[root] if root != delete else 0)
