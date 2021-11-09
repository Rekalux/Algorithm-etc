import sys

input = sys.stdin.readline
n = int(input())
li = []
for _ in range(n):
    li.append(list(map(int, input().split())))
li.sort()
li2 = [[0] * 2 for _ in range(len(li))]
for i in range(1, n):
    li2[i][0] = li2[i - 1][0] + li[i - 1][1]
for i in range(n - 2, -1, -1):
    li2[i][1] = li2[i + 1][1] + li[i + 1][1]
k = n - 1
for i in range(n - 1):
    if li2[i][1] <= li2[i + 1][0]:
        k = i
        break
print(li[k][0])
