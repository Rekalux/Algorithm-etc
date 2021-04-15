n, m = map(int, input().split())
day = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
while n != 1:
    m = m + month[n - 2]
    n -= 1
print(day[m % 7])
