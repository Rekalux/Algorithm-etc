n, m = map(int, input().split())
poke_dic = {}
for i in range(1, n + 1):
    get_string = input()
    poke_dic[get_string] = i
    poke_dic[str(i)] = get_string
print(poke_dic)
for _ in range(m):
    get_string = input()
    print(poke_dic[get_string])
