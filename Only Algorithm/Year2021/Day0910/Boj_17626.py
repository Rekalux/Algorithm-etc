n = int(input())
li = [4] * 50002
li[0] = 0
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i - (j ** 2) < 0:
            break
        li[i] = min(li[i - (j ** 2)] + 1, li[i])
print(li[n])
