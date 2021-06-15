n = int(input())
li = list(map(int,input().split()))
cost = list(map(int,input().split()))
oil = cost[0]
result = 0
for i in range(len(li)):
    result += (oil * li[i])
    oil = min(oil, cost[i+1])
print(result)