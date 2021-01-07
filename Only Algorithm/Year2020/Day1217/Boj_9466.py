def dfs(v):
    stack = []
    stack.append(v)
    while stack:
        v = stack[-1]
        if v in cycledict:
            for j in range(cycledict[v]):
                result[stack[j]] = 2
            for j in range(cycledict[v],len(stack)):
                result[stack[j]] = 1
            return
        if not result[case[v]] == 0:
            for se in stack:
                result[se] = 2
            return
        cycledict[v] = len(stack)
        stack.append(case[v])

T = int(input())
for _ in range(T):
    n = int(input())
    case = list(map(lambda x : int(x)-1,input().split()))
    result = [0] * n
    for i in range(n):
        if not result[i] == 0:
            continue
        cycledict = dict()
        temp = i
        dfs(i)
    print(result.count(2))