n, k = map(int, input().split())
table = [0]
table.extend([k+1] * k)
for i in range(n):
    money = int(input())
    if money > 10000:
        continue
    for j in range(money, k + 1):
        table[j] = min(table[j], table[j - money] + 1)
print(table[k] if table[k] != k+1 else -1)
