T = int(input()) # 먼저 입출력을 받아옵니다.
for tc in range(1, T + 1): # 그리고 테스트 케이스만큼 반복합니다.
    n, m = map(int, input().split()) # 종양개수인 n과 남겨도 되는 최대 종양 수 m을 가져옵니다.
    # n-m : 최소로 치료해야 할 종양개수
    tumors = [] # 종양을 받아올 리스트
    for i in range(n): #그리고 종양의 개수만큼 반복하여
        get_tumor = list(map(int, input().split())) # 종양을 받아옵니다.
        get_tumor = [min(get_tumor[0], get_tumor[2]), min(get_tumor[1], get_tumor[3]),
                     max(get_tumor[0], get_tumor[2]), max(get_tumor[1], get_tumor[3])]
        # 이후 종양을 정렬하는 과정을 거칩니다.
        # 두 x좌표 중 작은 값을 0번 인덱스자리에, 큰 값을 2번 인덱스자리에 저장합니다.
        # y좌표도 둘 중 작은 값을 1번 인덱스, 큰 값을 3번 인덱스에 저장합니다.
        # 이렇게 되면 앞의 두 인덱스는 직사각형의 왼쪽 아래 좌표가 되고,
        # 뒤의 두 인덱스는 오른쪽 위 좌표가 됩니다.
        # 여기서 저는 종양의 왼쪽 아래 좌표를 기준으로 연산을 하겠습니다.
        tumors.append(get_tumor) #그리고 종양 리스트에 저장합니다.
    tumors_x = [i[0] for i in tumors] # x좌표 리스트
    tumors_y = [i[1] for i in tumors] # y좌표 리스트

    # 여기에서 조금 더 빠른 효율을 위해 종양을 치료하는 방사능의 한변 길이인 k를 이분탐색합니다.
    start, end = 0, 300 # 시작점과 끝점을 정하고
    while start < end: # 시작점이 끝점을 넘기기 전까지 반복합니다.
        k = (start + end) // 2 # 절반으로 k를 정해줌
        found = False # 종양 제거에 성공했는 지의 여부를 확인할 변수를 초기화 해줍니다.
        for i in tumors_x: # 종양을 덮을 때, 종양의 x좌표 중 하나를 가져오고
            for j in tumors_y: # 종양의 y좌표 중 하나를 가져옵니다.
                # 해당 좌표는 선택된 종양 2개를 동시에 덮기위한 최적의 위치입니다.
                # 또한 해당 좌표 중 나머지 종양을 모두 덮을 수 있는 위치가 적어도 하나는 존재합니다.
                laser = [i, j, i + k, j + k]
                # 해당 위치에서 가로세로가 k인 정사각형의 좌표로 방사능의 범위를 정합니다.
                count = 0 # 지우는 종양 수를 세기위한 카운트를 정합니다.
                for tumor in tumors:
                    if laser[0] <= tumor[0] and laser[1] <= tumor[1]\
                            and tumor[2] <= laser[2] and tumor[3] <= laser[3]:
                        # 각 종양이 방사능 범위 안에 있는 지 확인합니다.
                        count += 1 # 맞다면 카운트를 증가시킵니다.
                if n - count <= m: # 남은 종양의 개수를 m 이하로 조건을 만족시켰다면
                    end = k # k 범위의 최대값을 줄입니다.
                    found = True # 찾았음을 저장하고
                    break
            if found: # 해당 반복문이 끝날 때까지 break를 활용합니다.
                break
        if not found: # 만약 찾지 못하였다면
            start = k + 1 # k 범위의 최소값을 줄입니다.
        # 시작점이 끝점을 넘기기 전, 즉 조건을 만족하는 최소의 k를 구할 때까지 이분탐색을 반복하였습니다.
    print('#{} {}'.format(tc, start)) # 출력 양식에 맞게 출력합니다.
