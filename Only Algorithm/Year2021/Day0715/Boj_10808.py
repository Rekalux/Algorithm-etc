li = [0] * 26
word = input()
for i in word:
    li[ord(i)-ord('a')] += 1
for i in range(26):
    print(li[i],end=' ')