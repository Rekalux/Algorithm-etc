def digit(start, end):  # 시작 수, 끝 수, 수의 길이
    global dig
    print(start,end,dig)
    if dp.get((start,end),0):
        dig = [dig[i]+dp[(start,end)][i] for i in range(10)]
        return
    if len(end) == 1:
        for i in range(int(start), int(end) + 1):
            dig[i] += 1
        return
    if start[0] == end[0]:
        dig[int(start[0])] += (int(end) - int(start) + 1)
        digit(start[1:], end[1:])
        return
    for d in range(int(start[0]),int(end[0])):
        s = str(d)+('0'*(len(start)-1))
        e = str(d)+('9'*(len(start)-1))
        digit(s,e)
    digit(end[0]+('0'*(len(start)-1)), end)


n = int(input())
dig = [0] * 10
# dig2 = [0] * 10
# for i in range(1,n+1):
#     s = str(i)
#     for j in range(len(s)):
#         dig2[int(s[j])] += 1
dp = {}
dp[('000000','100000')] = [150005, 50001, 50000, 50000, 50000, 50000, 50000, 50000, 50000, 50000]
digit('0'*len(str(n)), str(n))
dig[0] -= int(('1'*len(str(n))))
print(dig)
# print(dig2)
