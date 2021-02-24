num = int(input())
A, B, C, D = [], [], [], []
for _ in range(num):
    a, b, c, d = map(int, input().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)
front_dict = dict()
back_dict = dict()
for a in A:
    for b in B:
        front_dict[a + b] = front_dict.get(a + b, 0) + 1
result = 0
for c in C:
    for d in D:
        result += front_dict.get(-(c + d), 0)
print(result)
