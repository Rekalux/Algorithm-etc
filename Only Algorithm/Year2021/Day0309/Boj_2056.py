# 본인은 어렵게 구현했지만, 사실 선행되어야 하는 과제가
# 앞에 나온 과제들로 구성되어 있기 때문에
# 받아와서 바로 길이를 구성하면 된다.
# 그러면 연결도 안 해도 되고 해싱도 할 필요가 없다.

from collections import deque
import sys

input = sys.stdin.readline
n = int(input())
link = [set() for _ in range(n)]
link_reverse = {}
link_count = [0] * n
time = [0] * n
dp = [0] * n
q = deque()
for i in range(n):
    num_and_list = list(map(int, input().split()))
    time[i] = num_and_list[0]
    link_count[i] = num_and_list[1]
    if link_count[i] == 0:
        q.append(i)
    for j in range(link_count[i]):
        obj_link = num_and_list[2 + j] - 1
        link[obj_link].add(i)
    link_reverse[i] = set(map(lambda X: X - 1, num_and_list[2:]))
result = 0

while q:
    core = q.popleft()
    pre_max = 0
    for pre in link_reverse[core]:
        pre_max = max(pre_max, dp[pre])
    dp[core] = pre_max + time[core]
    if dp[core] > result:
        result = dp[core]
    for next_link in link[core]:
        link_count[next_link] -= 1
        if not link_count[next_link]:
            q.append(next_link)
print(result)