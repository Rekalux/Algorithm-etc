from collections import deque

n, m = map(int, input().split())
link = [set() for _ in range(n + 1)]
link_num = [0] * (n + 1)
for i in range(m):
    num_list = list(map(int, input().split()))[1:]
    for j in range(1, len(num_list)):
        if num_list[j] in link[num_list[j-1]]:
            continue
        link[num_list[j - 1]].add(num_list[j])
        link_num[num_list[j]] += 1
q = deque()
for i in range(1, n + 1):
    if not link_num[i]:
        q.append(i)
answer = []
while q:
    num = q.popleft()
    answer.append(num)
    for i in link[num]:
        link_num[i] -= 1
        if not link_num[i]:
            q.append(i)
if not len(answer) - n:
    print('\n'.join(map(str, answer)))
else:
    print(0)
