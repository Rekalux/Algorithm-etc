T = int(input())
lines = []
for _ in range(T):
    lines.append(list(map(int,input().split())))
lines.sort(key=lambda x: x[0])
result = 0
swit = False
start = 0
end = 0
for line in lines:
    if not swit:
        start = line[0]
        end = line[1]
        swit = True
        continue
    if line[0] <= end:
        end = max(end, line[1])
    else:
        result += (end - start)
        start = line[0]
        end = line[1]
result += (end - start)
print(result)