import sys

inp = sys.stdin.readline
inp()
a = sorted(enumerate(map(int, inp().split())), key=lambda X: X[1])
a[0] = list(a[0]) + [0]
for i in range(1, len(a)):
    if a[i - 1][1] == a[i][1]:
        a[i] = list(a[i]) + [a[i - 1][2]]
    else:
        a[i] = list(a[i]) + [a[i - 1][2] + 1]
print(*map(lambda X: X[2], sorted(a, key=lambda X: X[0])))