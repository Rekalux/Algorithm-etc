T = int(input())
while T:
    n = int(input())
    set_1 = set()
    list_1 = []
    result = True
    for i in range(n):
        list_1.append(input())
    list_1.sort(key=len)
    for num in list_1:
        for i in range(len(num)):
            sub_num = num[:(i + 1)]
            if sub_num in set_1:
                result = False
            if not result:
                break
        if not result:
            break
        set_1.add(num)
    print('YES' if result else 'NO')
    T -= 1