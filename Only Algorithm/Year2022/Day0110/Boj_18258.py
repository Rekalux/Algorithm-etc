from collections import deque
import sys

input = sys.stdin.readline
n = int(input())
q = deque()
for i in range(n):
    cli = input().split()
    c = cli[0][-1]
    if c == 'h':
        q.append(cli[1])
    elif c == 'e':
        print(len(q))
    else:
        if not q:
            print(-1 if c != 'y' else 1)
        elif c == 't':
            print(q[0])
        elif c == 'k':
            print(q[-1])
        elif c == 'p':
            print(q.popleft() if q else -1)
        else:
            print(0)
