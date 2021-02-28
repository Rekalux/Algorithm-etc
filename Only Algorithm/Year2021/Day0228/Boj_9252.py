# 왼쪽값? / 윗쪽값? / 왼쪽위 대각선 +1(같은경우) 이 중에서 맥스값 고르기
a, b = list(input()), list(input())
dp = [[[0, 0, 0] for _ in range(len(a) + 1)] for _ in range(len(b) + 1)]


def of_len(x):
    return x[0]


for i in range(1, len(b) + 1):
    for j in range(1, len(a) + 1):
        temp = [dp[i - 1][j - 1][0], i, j]
        if a[j - 1] == b[i - 1]:
            temp[0] += 1
        dp[i][j] = [k for k in max(dp[i][j - 1], dp[i - 1][j], temp, key=of_len)]
print(dp[len(b)][len(a)][0])
if dp[len(b)][len(a)]:
    i = dp[len(b)][len(a)][1]
    j = dp[len(b)][len(a)][2]
    result_list = []
    while dp[i][j][0]:
        result_list += b[dp[i][j][1] - 1]
        i, j = dp[i - 1][j - 1][1], dp[i - 1][j - 1][2]
    print(''.join(result_list[::-1]))
