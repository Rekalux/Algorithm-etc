n = int(input())
li = list(input())
q = []
count = 0
result = 0
visit = [False] * n
for i in range(n):
    if li[i] == '(':
        q.append(i)
    elif q:
        visit[q.pop()] = True
        visit[i] = True
for i in range(n):
    if visit[i]:
        count += 1
        if result < count:
            result = count
    else:
        count = 0
print(result)
