n, f = int(input()), 0
for i in range(5, n + 1,5):
    j = i
    while not j % 5:
        f += 1
        j //= 5
print(f)
