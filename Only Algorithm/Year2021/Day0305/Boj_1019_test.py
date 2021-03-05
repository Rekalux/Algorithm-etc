# 규칙성을 찾기위한 generator
a = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
n = int(input())
for i in range(n+1):
    for j in list(str(i)):
        a[int(j)] += 1
print(a)