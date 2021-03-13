from collections import deque
import sys
input = sys.stdin.readline
n, m = map(int, input().split())
link = dict()
for i in range(m):
    start, end = input().split()
    link[start] = link.get(start, set())
    link[start].add(end)
Q = int(input())
for quiz in range(Q):
    a, b = input().split()
    q = deque()
    q.append(a)
    signal = False
    while q:
        name = q.popleft()
        if not link.get(name, 0):
            continue
        for i in link[name]:
            q.append(i)
            if i == b:
                print(a, end=' ')
                signal = True
            if signal:
                break
        if signal:
            break
    if signal:
        continue
    q = deque()
    q.append(b)
    signal = False
    while q:
        name = q.popleft()
        if not link.get(name, 0):
            continue
        for i in link[name]:
            q.append(i)
            if i == a:
                print(b, end=' ')
                signal = True
            if signal:
                break
        if signal:
            break
    if signal:
        continue
    print('gg', end=' ')
