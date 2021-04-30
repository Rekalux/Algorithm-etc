while True:
    li = list(map(int, input().split()))
    n, li = li[0], li[1:]
    if n == 0:
        break
    da = [0] * 6


    def ch(a, b, dap):
        if a == 6:
            print(*dap)
            return
        if b == n:
            return
        dap[a] = li[b]
        ch(a + 1, b + 1, dap)
        ch(a, b + 1, dap)


    ch(0, 0, da)
    print()
