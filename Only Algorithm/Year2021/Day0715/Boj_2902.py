word = input()
new_word = ''
for i in word:
    if ord('A') <= ord(i) <= ord('Z'):
        new_word += i
print(new_word)