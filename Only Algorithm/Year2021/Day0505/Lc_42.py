li = list(map(int,input().split()))
stack = []
result = 0
for i in li: # 오른쪽으로 가면서 같거나 더 큰 기둥을 찾음
    if stack and stack[0] <= i:
        for j in stack:
            result += (stack[0]-j)
        stack = [i]
    else:
        stack.append(i)

stack = []
for i in range(len(li)-1,-1,-1): # 왼쪽으로 가면서 더 큰 기둥을 찾음
    if stack and stack[0] <= li[i]:
        for j in stack:
            result += (stack[0]-j)
        stack = [li[i]]
    else:
        stack.append(li[i])
print(result)