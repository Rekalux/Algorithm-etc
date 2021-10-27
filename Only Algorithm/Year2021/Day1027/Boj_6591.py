import sys

sys.setrecursionlimit(10 ** 6)


# def combi(n, k):
#     if (n, k) in c:
#         return c[(n, k)]
#     if n == 0 or k == 0 or n == k:
#         c[(n, k)] = 1
#         return c[(n, k)]
#     c[(n, k)] = combi(n - 1, k - 1) + combi(n - 1, k)
#     return c[(n, k)]

# def fact(a, b):
#     if a == b:
#         return 1
#     return a * fact(a - 1, b)


def combi(n, k):
    result = 1
    v = 1
    if n - k < k:
        k = n - k
    while k > 0:
        result *= n
        result //= v # 연속된 n개의 곱은 n의 배수이므로 약분한다 => k가 분모로 존재하는 값들이 차례로 나눠지는 결과
        n, v, k = n - 1, v + 1, k - 1
    return result


f = open(0)
li = f.readlines()
c = {}
for line in li:
    n, k = map(int, line.split())
    if n == 0 and k == 0:
        break
    print(combi(n, k))
