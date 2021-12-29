code = input()
li = [1, 1]
for i in range(1, len(code)):
    s = 0
    if 10 <= int(code[i - 1:i + 1]) <= 26:
        s += li[-2]
    if int(code[i]) != 0:
        s += li[-1]
    li.append(s % 1000000)
print(li[-1] if code != '' and code[0] != '0' else 0)
