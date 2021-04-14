n = int(input())
li = list(map(int, input().split()))
li.sort()
result = 0
for i in range(n):
    nli = li[:i] + li[i + 1:]
    start, end = 0, len(nli)-1
    while start < end:
        if nli[start] + nli[end] < li[i]:
            start += 1
        elif nli[start] + nli[end] > li[i]:
            end -= 1
        else:
            result += 1
            break
print(result)
