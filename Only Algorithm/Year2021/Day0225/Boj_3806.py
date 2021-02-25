num = int(input())
for case in range(1, num + 1):
    S = list(input())
    T = list(input())
    N = len(S)
    if N != len(T):  # 길이가 다르면 실패
        print('Case %d: -1' % case)
        continue
    result = 0
    for i in range(N):  # 1. ? 에서 0의 위치이면 0으로 모두 바꿈
        if S[i] == '?' and T[i] == '0':
            S[i] = '0'
            result += 1
    S_count_0 = S.count('0')
    T_count_0 = T.count('0')
    limit = T_count_0 - S_count_0
    for i in range(N):  # 2. ? 에서 0의 개수를 맞춘다. 0의 개수가 충분하다면 1로 바꾼다.
        if S[i] == '?':
            if limit > 0:
                limit -= 1
                S[i] = '0'
            else:
                S[i] = '1'
            result += 1
    if limit > 0:  # 3. 0의 개수가 부족하면 답은 -1
        print('Case %d: -1' % case)
        continue
    S_count_1 = S.count('1')
    T_count_1 = T.count('1')
    limit = T_count_1 - S_count_1
    for i in range(N): # 4. 1의 개수가 맞도록 1이 들어갈 곳의 0을 1로 바꾼다.
        if limit <= 0:
            break
        if T[i] == '1' and S[i] == '0':
            S[i] = '1'
            limit -= 1
            result += 1
    difference = 0
    for i in range(N): # 5. 위치가 안 맞는 것 개수 / 2 를 마지막으로 더해줌
        if S[i] != T[i]:
            difference += 1
    result += (difference // 2)
    print('Case %d: %d' % (case, result))
