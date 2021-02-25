num = int(input())
num_list = list(map(int, input().split()))
index_list = [0] * 1001
for i in num_list:
    index_list[i] += 1


def make_num(index, result, remind):
    if not remind:
        return result
    recent = -9
    if len(result) != 0:
        recent = result[-1]
    for i in range(len(index)):
        if index[i] != 0 and recent + 1 != i:
            remind -= 1
            result.append(i)
            index[i] -= 1
            get_list = make_num(index, result, remind)
            if get_list:
                return get_list
            index[i] += 1
            result.pop()
            remind += 1
    return []


r = make_num(index_list, [], num)
print(*r)
