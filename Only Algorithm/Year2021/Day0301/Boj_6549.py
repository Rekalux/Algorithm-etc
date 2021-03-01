from collections import deque

while 1:
    histo = list(map(int, input().split()))[1:]
    if len(histo) == 0:
        break
    histo.append(0)
    stack = deque()
    stack.append([0, 0])
    max_value = 0
    for i in range(len(histo)):
        pre_l, pre_time = stack.pop()
        check = False
        con_time = 0
        while pre_l > histo[i]:
            max_value = max(max_value, (i - pre_time) * pre_l)
            con_time = pre_time
            pre_l, pre_time = stack.pop()
            check = True
        stack.append([pre_l, pre_time])
        if check:
            stack.append([histo[i],con_time])
        if pre_l < histo[i]:
            stack.append([histo[i], i])
    print(max_value)
