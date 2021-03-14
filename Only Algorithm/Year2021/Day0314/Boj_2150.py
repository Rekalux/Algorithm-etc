import sys

input = sys.stdin.readline
sys.setrecursionlimit(10005)
n, m = map(int, input().split())
alink = [set() for _ in range(n + 1)]
blink = [set() for _ in range(n + 1)]
astart = [[0, 0] for _ in range(n + 1)]
bstart = [[0, 0] for _ in range(n + 1)]
for i in range(m):
    s, e = map(int, input().split())
    alink[s].add(e)
    blink[e].add(s)
count = 0


def dfs(num, check, link, getset=None):
    global count
    count += 1
    check[num][0] = count
    for i in link[num]:
        if check[i][0]:
            continue
        if getset:
            getset.append(i)
        dfs(i, check, link, getset)
    count += 1
    check[num][1] = count


for i in range(1, n + 1):
    if astart[i][0] == 0:
        dfs(i, astart, alink)
order_list = sorted(range(1, n + 1), key=lambda X: -astart[X][1])
count = 0
total_cycle = []
for i in order_list:
    if bstart[i][0]:
        continue
    cycle = [i]
    dfs(i, bstart, blink, cycle)
    cycle.sort()
    cycle.append(-1)
    total_cycle.append(cycle)
total_cycle.sort()
print(len(total_cycle))
for i in total_cycle:
    print(*i)
