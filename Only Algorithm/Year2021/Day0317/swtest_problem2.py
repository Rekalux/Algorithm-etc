T = int(input())
for tc in range(1, T + 1):
    n, m = map(int, input().split()) # 종양개수, n-m : 최소 치료해야 할 종양개수
    s = [] # 종양
    for i in range(n):
        one = list(map(int, input().split()))
        one = [min(one[0], one[2]), min(one[1], one[3]), max(one[0], one[2]), max(one[1], one[3])] # 좌표 정렬
        s.append(one)
    s1 = [i[0] for i in s] # x좌표 리스트
    s2 = [i[1] for i in s] # y좌표 리스트
    start, end = 0, 300 # 시작점과 끝점
    while start < end: # 시작점이 끝점을 넘기기 전까지
        k = (start + end) // 2 # 절반으로 k를 정해줌
        found = False # 덮어짐!
        for i in s1:
            for j in s2:
                laser = [i, j, i + k, j + k] # 종양을 지우는 레이저 사각형
                count = 0 #지우는 종양 수
                for two in s:
                    if laser[0] <= two[0] and laser[1] <= two[1] and two[2] <= laser[2] and two[3] <= laser[3]: #범위 안에 있는 지
                        count += 1
                if n - count <= m: # 조건만족
                    end = k
                    found = True
                    break
            if found:
                break
        if not found:
            start = k + 1
    print('#{} {}'.format(tc, start))
