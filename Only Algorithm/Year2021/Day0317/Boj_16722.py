import sys

input = sys.stdin.readline
shape = []
for i in 'c' * 9:
    shape.append(tuple(input().split()))
n = int(input())
dap = set()

for i in range(9):
    for j in range(9):
        for k in range(9):
            if i == j or j == k or i == k:
                continue
            select = [shape[i], shape[j], shape[k]]
            flag = True
            for test in range(3):
                test_set = set([select[case][test] for case in range(3)])
                if len(test_set) == 2:
                    flag = False
                    break
            if flag:
                dap.add(tuple(sorted([i + 1, j + 1, k + 1])))
score = 0
find = False
for i in range(n):
    check = input().split()
    if check[0] == 'H':
        check = tuple(sorted(map(int, check[1:])))
        if check in dap:
            score += 1
            dap.remove(check)
        else:
            score -= 1
    else:
        if not len(dap) and not find:
            score += 3
            find = True
        else:
            score -= 1
print(score)
