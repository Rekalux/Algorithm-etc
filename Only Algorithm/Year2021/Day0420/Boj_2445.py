n = int(input())
for i in range(2*n):
    print('{}{}{}'.format('*'*(n - abs(n-i-1)),' '*(2*abs(n-i-1)),'*'*(n - abs(n-i-1))))