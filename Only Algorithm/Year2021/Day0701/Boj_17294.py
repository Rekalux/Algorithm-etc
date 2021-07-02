n = input()
if len(n) < 3:
    print("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!")
    exit(0)
cha = ord(n[0]) - ord(n[1])
for i in range(1, len(n)-1):
    if cha != ord(n[i]) - ord(n[i+1]):
        print("흥칫뿡!! <(￣ ﹌ ￣)>")
        exit(0)
print("◝(⑅•ᴗ•⑅)◜..°♡ 뀌요미!!")