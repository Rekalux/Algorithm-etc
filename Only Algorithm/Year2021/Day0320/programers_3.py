def solution(enter, leave):
    answer = [0] * len(enter)
    enter = list(map(lambda x:x-1,enter))
    leave = list(map(lambda x:x-1,leave))
    room = set()
    i = 0
    j = 0
    while j < len(leave):
        if leave[j] in room:
            room.remove(leave[j])
            j += 1
            continue
        answer[enter[i]] += len(room)
        for k in room:
            answer[k] += 1
        room.add(enter[i])
        i += 1
    return answer


ip1 = [1, 3, 2]
ip2 = [1, 2, 3]
print(solution(ip1, ip2))
