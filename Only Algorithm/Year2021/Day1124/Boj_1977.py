n, m = int(input()), int(input())
li = []
for i in range(n, m + 1):
    for j in range(1, int(pow(i, 0.5)) + 1):
        if i == j ** 2:
            li.append(i)
print(sum(li), li[0], end='\n') if li else print(-1)
