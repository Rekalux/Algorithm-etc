T = int(input())
for tc in range(1, 1 + T):
    s1, s2 = input().split()
    di = {}
    di2 = {}
    count = 0
    if len(s2) < len(s1):
        continue
    for i in s1:
        di[i] = di.get(i, 0) + 1
    for i in range(len(s1)):
        di2[s2[i]] = di2.get(s2[i], 0) + 1
    for i in range(len(s1), len(s2) + 1):
        for j in di:
            if di[j] != di2.get(j, -1):
                break
        else:
            count += 1
        if i == len(s2):
            break
        if di2[s2[i - len(s1)]] == 1:
            di2.pop(s2[i - len(s1)])
        else:
            di2[s2[i - len(s1)]] -= 1
        di2[s2[i]] = di2.get(s2[i], 0) + 1
    print('#{} {}'.format(tc, count))
