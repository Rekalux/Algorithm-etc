li = []
for i in range(7):
    a = int(input())
    if a % 2:
        li.append(a)
if not li:
    print(-1)
else:
    print(sum(li), min(li), sep='\n')
