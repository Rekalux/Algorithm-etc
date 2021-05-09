def hap(lione, litwo):
    return [lione[i] + litwo[i] for i in range(10)]


def digit(start, end):  # 시작 수, 끝 수, 수의 길이
    global dig
    temp = [0] * 10
    if dp.get((start, end), 0):
        temp = hap(temp, dp[(start, end)])
        return temp
    if len(end) == 1:
        for i in range(int(start), int(end) + 1):
            temp[i] = 1
        dp[(start, end)] = temp
        return temp
    if start[0] == end[0]:
        temp[int(start[0])] += (int(end) - int(start) + 1)
        temp = hap(temp, digit(start[1:], end[1:]))
        dp[(start, end)] = temp
        return temp
    for d in range(int(start[0]), int(end[0])):
        s = str(d) + ('0' * (len(start) - 1))
        e = str(d) + ('9' * (len(start) - 1))
        temp = hap(temp, digit(s, e))
    temp = hap(temp, digit(end[0] + ('0' * (len(start) - 1)), end))
    dp[(start, end)] = temp
    return temp


n = int(input())
dig = [0] * 10
dp = {}
dig = hap(dig, digit('0' * len(str(n)), str(n)))
dig[0] -= int(('1' * len(str(n))))
print(*dig)
