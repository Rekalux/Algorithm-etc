n = int(input())
for i in range(2*n):
    print('{}{}'.format(' '*(abs(n-i-1)),'*'*(2*((n-1)-abs(i-(n-1)))+1)))