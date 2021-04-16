n, m = map(int, input().split())
li = []
for i in range(n):
    li.append(int(input()))
li.sort(reverse=True)
result = 0
for i in range(n):
    if m >= li[i]:
        result += (m//li[i])
        m = m%li[i]
print(result)