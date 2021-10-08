import sys, heapq


def add(p, le):  # p는 문제번호, le는 난이도
    q[p] = le
    if le not in n_level:
        level[le] = [[], []]
    heapq.heappush(level[le][0], p)  # 해당 난이도의 최소힙에 추가
    heapq.heappush(level[le][1], -p)  # 해당 난이도의 최대힙에 추가
    if le not in n_level:
        heapq.heappush(low_level, le)  # 최소 힙에 추가
        heapq.heappush(high_level, -le)  # 최대 힙에 추가
    n_level[le] = n_level.get(le, 0) + 1  # 해당 레벨에 개수를 세줌


input = sys.stdin.readline
n = int(input())
q = {}  # 문제 테이블
level = {}  # 난이도에 따른 분류 (list 안에 list 형식으로 미리 100개를 구현해뒀는데 시간 초과로 틀렸음)
# level = [[[] for _ in range(2)] for in range(100)] -> 시간초과... 왜..?
low_level = []  # 최소 난이도 힙
high_level = []  # 최대 난이도 힙
n_level = {}  # 난이도 별 개수
for _ in range(n):
    p, le = map(int, input().split())
    add(p, le)
m = int(input())
for _ in range(m):
    f_command = input()
    if f_command[0] == 'a':  # 추가 연산
        com, p, le = f_command.split()
        p, le = map(int, [p, le])
        add(p, le)  # 새로운 문제 추가
    elif f_command[0] == 'r':  # 출력 연산
        com, num = f_command.split()
        num = int(num)
        # -1이면 최소난이도에서 최소힙 문제를 찾음
        # 1이면 최대난이도에서 최대힙 문제를 찾음
        print(level[low_level[0]][0][0] if num == -1 else -level[-high_level[0]][1][0])
    else:  # 삭제연산
        com, num = f_command.split()
        num = int(num)
        le = q.pop(num)  # 문제 번호로 레벨 찾고 삭제
        n_level[le] -= 1  # 해당 레벨의 개수를 줄임
        if n_level[le] == 0:  # 0이라면
            del n_level[le]  # 해당 개수도 삭제
            del level[le]  # 레벨에서도 삭제
            while -high_level[0] not in n_level:  # 최대힙의 최대값에 해당하면 존재하는 레벨이 나올때까지 삭제
                heapq.heappop(high_level)
            while low_level[0] not in n_level:  # 최소힙도 동일
                heapq.heappop(low_level)
        while le in level and level[le][0] and level[le][0][0] not in q:  # 해당레벨에서의 번호 최소힙에서 가장 작은 문제라면 삭제
            heapq.heappop(level[le][0])
        while le in level and level[le][1] and -level[le][1][0] not in q:  # 최대힙도 마찬가지
            heapq.heappop(level[le][1])
