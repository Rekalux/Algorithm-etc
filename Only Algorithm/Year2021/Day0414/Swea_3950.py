# 1. 올바른 괄호는 뒤집어도 올바르다
# 2. 괄호가 홀수개면 무조건 불가능하다
# 3. 괄호배열에서 올바른 괄호는 무시한다
# 4. 그 이후 올바르지 않은 괄호는
# )))(((((와 같이 왼쪽은 닫는 괄호
# 오른쪽은 여는 괄호이다
T = int(input())
for tc in range(1, T + 1):
    n = int(input())
    li = list(input())
    if n % 2:
        print('#{} {}'.format(tc, -1))
        continue
    stack = []
    fail = []
    for i in range(n):
        if li[i] == '(':
            stack.append(i)
        else:
            if stack:
                stack.pop()
            else:
                fail.append(i)
    result = 0
    if stack and fail:
        result = 2
    elif stack or fail:
        result = 1
    print('#{} {}'.format(tc, result))

    if fail:
        if stack:
            print(fail[0], fail[-1])
        else:
            print(fail[0], fail[len(fail)//2]-1)
        hap = fail[0] + fail[-1]
        for i in range(len(fail)):
            fail[i] = hap - fail[i]
        fail.sort()
    if stack:
        for i in stack:
            fail.append(i)
        print(fail[len(fail)//2],fail[-1])