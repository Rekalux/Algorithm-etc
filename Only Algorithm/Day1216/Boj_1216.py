nacho = [[0] * 66 for _ in range(10)]
# 그냥 초기값 설정을 위한 1 저장
nacho[9][0] = 1
# 각각의 자리수 길이에 대해
for n in range(1,66):
    # 맨 앞의 값이 9부터 0까지 각각 올 수 있는 정수의 개수를 구한다.
    for digit in range(9,-1,-1):
        # 맨 앞의 값이 digit이 오기 위해서는 digit 이상의 정수만 올 수 있다.
        # 따라서 n-1 자리의 값의 digit 이상 9 이하의 값의 누적합이 필요.
        # n-1 자리의 digit의 값 (=left) + n자리의 digit-1의 값(누적합)(=under)
        # = n자리의 digit값(누적합)
        left = nacho[digit][n-1]
        under = 0
        if digit < 9:
            under = nacho[digit+1][n]
        nacho[digit][n] = left + under
T = int(input())
for _ in range(T):
    m = int(input())
    print(nacho[0][m+1])