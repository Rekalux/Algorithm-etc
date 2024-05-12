# Boj_1509 팰린드롬 분할


str = input()
rev_str = str[::-1]

li = []

for i in range(len(str)):
    n_list = []
    for j in range(len(str)):
        if i == 0 or j == len(str) - 1:
            n_list.append(1 if str[j] == str[i] else 0)
        else:
            n_list.append(li[i-1][j+1] + 1 if str[j] == str[i] else 0)
    li.append(n_list)
for nli in li:
    for n in nli:
        print(n, end=' ')
    print()

