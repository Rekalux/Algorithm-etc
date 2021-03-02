x, a, b, c, d = map(int, input().split())

result = False
turn = False
while a >= 0:
    use_a = x - a
    if use_a <= 0:
        result = [x, 0, 0, 0]
        break
    if use_a % 5:
        a -= 1
        continue
    _b = b
    while _b >= 0 :
        use_b = use_a - (_b * 5)
        if use_b <= 0:
            result = [a,use_a//5,0,0]
            break
        _c = c
        signal = False
        while _c >= 0:
            use_c = use_b - (_c * 10)
            if use_c <= 0 and use_b % 10 == 0:
                result = [a,_b,use_b//10,0]
                break
            if use_c > 0 and use_c % 25 == 0 and use_c // 25 <= d and not signal:
                if result:
                    sum_re = sum(result)
                    if sum_re >= sum([a, _b, _c, use_c // 25]):
                        _c -= 1
                        continue
                result = [a,_b,_c,use_c//25]
                signal = True
            _c -= 1
        if result:
            if not turn:
                turn = True
                _b -= 1
                continue
            break
        _b -= 1
    if result:
        break
    a -= 1
print(*result if result else [0,0,0,0])