def combi(n, m):
    result = 1
    for i in range(n, n - m, -1):
        result *= i
    for i in range(2, m + 1):
        result //= i
    return result


print(combi(*map(int, input().split())))