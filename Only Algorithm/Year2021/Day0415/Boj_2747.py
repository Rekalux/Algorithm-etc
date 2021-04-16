n = int(input())
dp = [0]
for i in range(n):
    if i == 0:
        dp.append(1)
        continue
    dp.append(dp[-1] + dp[-2])
print(dp[-1])
