import sys

input = sys.stdin.readline

n, w = map(int, input().split())
link = [set() for _ in range(n)]
c = 0
for i in range(n - 1):
    a, b = map(lambda x: int(x) - 1, input().split())
    link[a].add(b)
    link[b].add(a)
for i in range(1, n):
    if len(link[i]) == 1:
        c += 1
print(w / c)
