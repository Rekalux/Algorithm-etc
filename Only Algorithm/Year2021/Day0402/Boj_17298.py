n = int(input())
li = list(map(int, input().split()))
li.reverse()
q = []
r = []
for i in range(n):
    k = -1
    while q:
        if q[-1] > li[i]:
            k = q[-1]
            break
        q.pop()
    q.append(li[i])
    r.append(k)
print(*reversed(r))