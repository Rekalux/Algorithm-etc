n = int(input())

num_list = list()
dp = [[0] * n for _ in range(n)]
for i in range(n):
    input_num = int(input())
    num_list.append(input_num)
    dp[i][i] = n * input_num  # 그 위치별로 dp 연산
for i in range(2, n + 1):  # 2부터 문자열의 길이만큼
    for j in range(n - i + 1):  # 그 길이에서 구할 횟수만큼
        dp[j][j + i - 1] = max(dp[j + 1][j + i - 1] + num_list[j] * (n - i + 1),  # 오른쪽 dp 사용
                               dp[j][j + i - 2] + num_list[j + i - 1] * (n - i + 1))  # 왼쪽 dp 사용
print(dp[0][n-1])
