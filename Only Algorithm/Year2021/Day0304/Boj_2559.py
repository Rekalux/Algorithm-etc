n,k = map(int,input().split())
li = list(map(int,input().split()))
start = li[:k]
result = change = sum(start)
for i in range(n - k):
    change -= li[i]
    change += li[i+k]
    result = max(result, change)
print(result)