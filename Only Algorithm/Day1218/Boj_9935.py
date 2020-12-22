a = input()
b = input()
a = " ".join(a).split() # 리스트 변환
b = " ".join(b).split()
scanlist = []
for i in a:
    scanlist.append(i)
    if len(b) > len(scanlist):
        continue
    if scanlist[-len(b):] == b:
        for _ in range(len(b)):
            scanlist.pop()
print("".join(scanlist) if scanlist else "FRULA")