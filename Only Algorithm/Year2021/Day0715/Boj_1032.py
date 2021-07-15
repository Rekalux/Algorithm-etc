n = int(input())
word_list = []
for _ in range(n):
    word_list.append(input())
word = list(word_list[0])
for i in range(len(word)):
    for w in word_list:
        if w[i] != word[i]:
            word[i] = '?'
            break
print(''.join(word))