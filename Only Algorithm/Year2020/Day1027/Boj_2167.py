import sys
input = sys.stdin.readline

Y, X = map(int,input().strip().split())
nums = []
for _ in range(Y):
    nums.append(list(map(int,input().strip().split())))
num = int(input().strip())
for _ in range(num):
    a,b,c,d = map(int,input().strip().split())
    a,b,c,d = a-1,b-1,c-1,d-1
    result = 0
    for i in range(a, c+1):
        for j in range(b, d+1):
            result += nums[i][j]
    print(result)