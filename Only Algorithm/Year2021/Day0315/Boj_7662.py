import sys
import heapq

input = sys.stdin.readline
T = int(input())
for _ in range(T):
    n = int(input())
    nq, mq = [], []
    visit = [False] * (n + 1)
    for i in range(n):
        command, num = input().split()
        if command == 'I':
            heapq.heappush(nq, (int(num), i))
            heapq.heappush(mq, (-int(num), i))
            continue
        elif num == '1':
            if not len(mq):
                continue
            else:
                _, j = heapq.heappop(mq)
                visit[j] = True
        else:
            if not len(nq):
                continue
            else:
                _, j = heapq.heappop(nq)
                visit[j] = True
        while nq:
            # nq에서 제거할 수 있을만큼 제거하겠다.
            print(nq)
            num, j = heapq.heappop(nq)
            if not visit[j]:
                heapq.heappush(nq, (num, j))
                break
        while mq:
            # mq에서 제거할 수 있을만큼 제거하겠다.
            num, j = heapq.heappop(mq)
            if not visit[j]:
                heapq.heappush(mq, (num, j))
                break
    if not len(nq):
        print('EMPTY')
    else:
        print(-heapq.heappop(mq)[0], heapq.heappop(nq)[0])
