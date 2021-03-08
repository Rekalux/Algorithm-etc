def slice_string(word, n):
    li = []
    k = 0
    while word[k:n + k]:
        li.append(word[k:n + k])
        k += n
    return li


s = input()
answer = 999999999
for i in range(1, len(s) // 2 + 1):
    new_list = slice_string(s, i)
    result = len(s)
    count = 0
    for j in range(1, len(new_list)):
        if new_list[j] == new_list[j - 1]:
            count += 1
        else:
            if count:
                result = result + (len(str(count + 1))) - (count * i)
                count = 0
    if count:
        result = result + (len(str(count + 1))) - (count * i)
    answer = min(result, answer)
if answer == 999999999:
    answer = 1
print(answer)
