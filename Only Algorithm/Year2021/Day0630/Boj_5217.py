n = int(input())
li = []
for i in range(n):
    li.append(int(input()))


def hap(num):
    l = []
    for i in range(1, num):
        if i >= num - i:
            break
        l.append((i, num - i))
    return l


for i in range(n):
    get_list = hap(li[i])
    print(f"Pairs for {li[i]}:", end=" ")
    for pair in range(len(get_list)):
        print(f"{get_list[pair][0]} {get_list[pair][1]}", end="")
        if pair != len(get_list)-1:
            print(", ",end="")
    print()
