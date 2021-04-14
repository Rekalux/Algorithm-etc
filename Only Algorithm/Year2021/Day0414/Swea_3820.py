T = int(input())
for tc in range(1, T + 1):
    n = int(input())
    li = []
    for i in range(n):
        li.append(tuple(map(int, input().split())))
    li.sort(key=lambda X: -(X[0] - 1) / X[1])
    result = 1
    for i in range(n):
        result = (result * li[i][0] + li[i][1]) % 1000000007
    print('#{} {}'.format(tc, result))
