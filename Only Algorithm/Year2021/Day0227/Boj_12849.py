# 정보과학관 : 0
# 전산관 : 1
# 미래관 : 2
# 신앙관 : 3
# 진리관 : 4
# 학생회관 : 5
# 한경직기념관 : 6
# 형남공학관 : 7
route = {0: [1, 2], 1: [0, 2, 3], 2: [0, 1, 3, 6], 3: [1, 2, 4, 6], 4: [3, 5, 6], 5: [4, 7], 6: [2, 3, 4, 7], 7: [5, 6]}
dp = [0] * 8
dp[0] = 1
step = int(input())
for _ in range(step):
    new_dp = [0] * 8
    for i in range(8):
        for j in route[i]:
            new_dp[j] = (dp[i] + new_dp[j]) % 1000000007
    dp = [k for k in new_dp]
print(dp[0])
