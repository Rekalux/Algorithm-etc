n = int(input())
s = 0
for i in range(8):
    if n & 1 << i:
       s += 1
print(s)