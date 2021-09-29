n = int(input())
li = list(map(int, input().split()))
for i in range(1, n):
    k = li[0]
    for j in range(2, k + 1):
        while li[i] % j == 0 and k % j == 0:
            li[i] //= j
            k //= j
    print(f'{k}/{li[i]}')
