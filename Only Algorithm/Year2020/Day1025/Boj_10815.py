import sys
from bisect import bisect_left

# input = sys.stdin.readline
# n = int(input().rstrip())
# li = list(map(int,input().rstrip().split()))
# di = dict()
# for i in li:
#     di[i] = True
# m = int(input())
# cli = list(map(int,input().rstrip().split()))
# for n in cli:
#     if di.get(n):
#         print(1,end=" ")
#     else:
#         print(0,end=" ")


input = sys.stdin.readline
input()
li = list(map(int,input().rstrip().split()))
input()
cli = list(map(int,input().rstrip().split()))
li.sort()
for n in cli:
    i = bisect_left(li, n) # 이진탐색을 하고 만약 결과값이 있다면 그 인덱스를 없다면 그 숫자가 들어갈 인덱스를 찾아준다.
    if i == len(li):
        print("0",end="")
        continue
    print(1 if li[i] == n else 0,end=" ") # 결과값이 있으면 1 없으면 0