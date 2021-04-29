import sys

input = sys.stdin.readline
a, b = map(int, input().split())
li = list(map(int, input().split()))
start, end = 0, max(li)
while start < end:
    mid = (start + end) // 2
    summ = 0
    for i in range(a):
        if li[i] - mid > 0:
            summ += li[i] - mid
    if summ < b:
        end = mid
    else:
        start = mid + 1
print(start - 1)
