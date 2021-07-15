for i in range(3):
    li = list(map(int, input().split()))
    num = sum(li)
    ch = chr(ord('A') + 3 - num)
    print(ch if ch != '@' else 'E')
