num = int(input())
input_list = list(map(int, input().split()))
s = int(input())
while s:
    max_num = 0
    j = 0
    if len(input_list) == 1:
        break
    for i in range(s+1):
        if i == len(input_list):
            break
        if max_num < input_list[i]:  # 바꿀 수 있는 거리 내에 가장 큰 값을 찾아서 저장
            max_num = input_list[i]
            j = i
    print(input_list.pop(j), end=' ')  # 맨 앞으로 이동 ( 바로 출력 )
    s -= j  # 이동 횟수 사용
if input_list:
    print(*input_list)