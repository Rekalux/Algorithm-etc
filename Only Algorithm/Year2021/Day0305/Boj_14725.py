def find(find_dig, depth):
    new_list = sorted(find_dig.keys())
    for new_dig in new_list:
        print('{}{}'.format(depth * '--', new_dig))
        if not len(find_dig[new_dig]):
            continue
        else:
            find(find_dig[new_dig], depth + 1)


n = int(input())
hole = {}
for i in range(n):
    dig = hole
    aunt = input().split()[1:]
    for j in aunt:
        dig[j] = dig.get(j, {})
        dig = dig[j]
find(hole, 0)
