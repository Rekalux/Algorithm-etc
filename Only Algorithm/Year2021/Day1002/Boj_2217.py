n = int(input())
li = []
for i in range(n):
    li.append(int(input()))
li.sort()
m = 0
for num in range(n-1,-1,-1):
    if ( n - num ) * li[num] > m:
        m = (n - num) * li[num]
print(m)