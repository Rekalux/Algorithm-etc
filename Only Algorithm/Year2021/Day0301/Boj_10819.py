from collections import deque
import sys
input = sys.stdin.readline
n = int(input())
li = sorted(map(int,input().split()))
left = True
new_li = [li.pop(-1)]
turn = True
while li:
    if left:
        num = li.pop(0)
    else:
        num = li.pop(-1)
    if turn:
        new_li = [num] + new_li[:]
    else:
        new_li.append(num)
    left = not left
    if left:
        turn = not turn
result = 0
for i in range(n-1):
    result += abs(new_li[i]-new_li[i+1])
result2 = abs(new_li[0]-new_li[-1])
for i in range(1,n-1):
    result2 += abs(new_li[i]-new_li[i+1])
print(max(result,result2))