n = int(input())
dp = [0]
for i in range(n + 1):
    if i == 0:
        dp.append(1)
        continue
    dp.append((dp[-1] + dp[-2] * 2) % 10007)
print(dp[-1])
