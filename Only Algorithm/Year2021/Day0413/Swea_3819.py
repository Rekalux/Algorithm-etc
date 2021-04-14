g = ''
while g == '':
    g = input().strip()
T = int(g)
for tc in range(1, T + 1):
    li = []
    gg = ''
    while gg=='':
        gg = input().strip()
    n = int(gg)
    for i in range(n):
        ggg = ''
        while ggg == '':
            ggg = input().strip()
        li.append(int(ggg))
    result = li[0]
    nu = 0
    for i in range(n):
        nu = max(li[i], nu + li[i])
        if nu > result:
            result = nu
    print('#{} {}'.format(tc, result))
