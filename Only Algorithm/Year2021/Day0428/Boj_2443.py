n = int(input())
for i in range(n):
    print('{}'.format(' '*(i)),end='')
    print('{}'.format('*'*(2*(n-i)-1)))