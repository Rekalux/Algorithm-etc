n = int(input())
for i in range(n * 2 - 1):
    print(' ' * abs((n - 1) - i) + '*' * (-abs((n - 1) - i) + n))
