def binarysearch(arr, f, key):
    start, end = 0, len(arr) - 1
    while start <= end:
        mid = (start + end) // 2
        if key(arr[mid]) <= f:
            start = mid + 1
        else:
            end = mid - 1
    return start


n = int(input())
li = []
for i in range(n):
    a, b = map(int, input().split())
    li.append([min(a, b), max(a, b)])
x = int(input())
nli = []
for i in li:
    if i[1] - i[0] <= x:
        nli.append(i)
nli.sort(key=lambda X: [X[1], X[0]])
result = 0
count = 0
for i in nli:
    temp = binarysearch(nli, i[0] + x, key=lambda X: X[1])
    num = 0
    for j in range(temp):
        if i[0] <= nli[j][0]:
            num += 1
    result = max(result, num)
    count += 1
print(result)
