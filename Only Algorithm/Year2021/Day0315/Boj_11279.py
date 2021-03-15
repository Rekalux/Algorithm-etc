import heapq
import sys

input = sys.stdin.readline
n = int(input())
q = []
for _ in range(n):
    m = int(input())
    if not m:  # 받아온 값이 0이면
        if not len(q):  # q가 비어 있다면
            print(0)
        else:  # q가 차 있다면
            print(-heapq.heappop(q))
    else:  # 받아온 값이 0이 아니면
        heapq.heappush(q, -m)
