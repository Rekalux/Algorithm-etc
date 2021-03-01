from collections import defaultdict, deque

n = int(input())
rel = defaultdict(set)
for _ in range(n - 1):
    a, b = map(int, input().split())
    rel[a].add(b)
    rel[b].add(a)
q = deque()
q.append(1)
visited = set()
values = [[0, 1] for _ in range(n + 1)]
while q:
    num = q.pop()
    if num not in visited:
        visited.add(num)
        q.append(num)
        for next_node in rel[num]:
            if next_node not in visited:
                q.append(next_node)
        continue
    for next_node in rel[num]:
        values[next_node][0] += values[num][1]
        values[next_node][1] += min(values[num][0], values[num][1])

print(min(values[1][0], values[1][1]))
