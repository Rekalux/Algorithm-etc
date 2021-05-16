li = input()
stack = []
result = 0
for i in range(len(li)):
    if li[i] == '(':
        if li[i+1] == ')':
            continue
        stack.append(1)
    else:
        if li[i-1] == '(':
            result += len(stack)
            continue
        stack.pop()
        result += 1
print(result)