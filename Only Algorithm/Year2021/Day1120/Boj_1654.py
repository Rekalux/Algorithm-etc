import sys

input = sys.stdin.readline
n, k = map(int, input().split())
li = []
for i in range(n):
    li.append(int(input()))
s, e = 1, 10000000000
while s < e:
    mid = (s + e) // 2
    kk = sum(map(lambda x: x // mid, li))
    if k <= kk:
        s = mid + 1
    else:
        e = mid
print(s-1)
