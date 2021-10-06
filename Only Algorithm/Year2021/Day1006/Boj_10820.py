file = open(0)
li = list(file)
for st in li:
    a, b, c, d = 0, 0, 0, 0
    for C in st[:-1]:
        if ord('a') <= ord(C) <= ord('z'):
            a += 1
        elif ord('A') <= ord(C) <= ord('Z'):
            b += 1
        elif ord('0') <= ord(C) <= ord('9'):
            c += 1
        else:
            d += 1
    print(a, b, c, d)
