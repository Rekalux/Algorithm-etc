from pprint import pprint


def change1(list1):
    new_list = []
    for i in range(len(list1) - 1, -1, -1):
        new_list.append(list1[i])
    return new_list


def change2(list1):
    new_list = []
    for line in list1:
        new_line = []
        for one in range(len(line)-1,-1,-1):
            new_line.append(line[one])
        new_list.append(new_line)
    return new_list

def change3(list1):
    for i in range(len(list1)):
        for j in range(list1[i]):




A = []
y, x, m = map(int, input().split())
for i in range(y):
    A.append(list(map(int, input().split())))
pprint(A)
print()
pprint(change1(A))
print()
pprint(change2(A))