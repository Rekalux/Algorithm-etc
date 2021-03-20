def solution(inp_str):
    answer = []
    if not 8<=len(inp_str)<=15:
        answer.append(1)
    ord_list = list(map(ord, list(inp_str)))
    found = False
    giho = set(map(ord,list('~!@#$%^&*')))
    use_list = set()
    for i in ord_list:
        if ord('A')<=i<=ord('Z'):
            use_list.add(1)
            continue
        if ord('a')<=i<=ord('z'):
            use_list.add(2)
            continue
        if ord('0')<=i<=ord('9'):
            use_list.add(3)
            continue
        if i in giho:
            use_list.add(4)
            continue
        found = True
    if found:
        answer.append(2)
    if len(use_list) < 3:
        answer.append(3)
    for i in range(3,len(inp_str)):
        s = set(inp_str[i-3:i+1])
        if len(s) == 1:
            answer.append(4)
            break
    d = {}
    for i in ord_list:
        d[i] = d.get(i,0) + 1
        if d[i] >= 5:
            answer.append(5)
            break
    if not len(answer):
        answer.append(0)
    return answer

ip = "CaCbCgCdC888834A"
print(solution(ip))