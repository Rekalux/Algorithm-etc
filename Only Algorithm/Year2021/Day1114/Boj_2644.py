n = int(input())
a, b = map(int, input().split())
m = int(input())
link = {}
for i in range(m):
    mo, ja = map(int, input().split())
    link[ja] = mo
ali, bli = [], []
while a in link:
    ali.append(a)
    a = link[a]
while b in link:
    bli.append(b)
    b = link[b]
ali.append(a)
bli.append(b)
if ali[-1] != bli[-1]:
    print(-1)
    exit()
else:
    while ali and bli and ali[-1] == bli[-1]:
        ali.pop()
        bli.pop()
    print(len(ali) + len(bli))
