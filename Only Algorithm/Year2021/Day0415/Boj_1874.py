import sys
input = sys.stdin.readline
n = int(input())
li = []
for i in range(n):
    li.append(int(input()))
stack = []
yul = []
check = 0
for i in range(1,n+1):
    stack.append(i)
    yul.append('+')
    while check < n and stack and stack[-1] == li[check]:
        stack.pop()
        check += 1
        yul.append('-')
if len(yul) == 2 * n:
    for i in yul:
        print(i)
else:
    print('NO')
