n = int(input())
for i in range(n):
    print('{}{}'.format(' ' * (n - i - 1), '*' * (i * 2 + 1)))
