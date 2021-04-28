from collections import deque
n = int(input())
for tc in range(n):
    a, b = map(int, input().split())
    li = list(map(int, input().split()))
    q = deque()
    most = [0,0,0,0,0,0,0,0,0,0]
    for i in range(a):
        q.append((li[i],i))
        most[li[i]] += 1
    count = 0
    for i in range(9,0,-1):
        flag = False
        while most[i] != 0:
            most[i] -= 1
            gi = 0
            count += 1
            while q:
                k, ki = q.popleft()
                if k == i:
                    gi = ki
                    break
                q.append((k,ki))
            if gi == b:
                print(count)
                flag = True
                break
        if flag:
            break
