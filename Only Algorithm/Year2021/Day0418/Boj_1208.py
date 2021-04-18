import sys

sys.setrecursionlimit(2 ** 22)

n, s = map(int, input().split())
li = list(map(int, input().split()))
a = li[:n // 2]
b = li[n // 2:]
A = {}
result = 0


def combA(p, hap):
    if len(a) == p:
        A[hap] = A.get(hap, 0) + 1
        return
    combA(p + 1, hap)
    combA(p + 1, hap + a[p])


def combB(p, hap):
    global result
    if len(b) == p:
        result += A.get(s - hap, 0)
        return
    combB(p + 1, hap)
    combB(p + 1, hap + b[p])


combA(0, 0)
combB(0, 0)
if s == 0:
    result -= 1
print(result)
