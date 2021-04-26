n = int(input())
link = {}
for i in range(n-1):
    a, b = map(int, input().split())
    link[b] = a

m = int(input())
for j in range(m):
    a, b = map(int, input().split())
    alist, blist = [], []
    while a != 1:
        alist.append(a)
        print(a)
        a = link[a]
    while b != 1:
        blist.append(b)
        print(b)
        b = link[b]
    com = 1
    while alist and blist and alist[-1] == blist[-1]:
        com = alist[-1]
        alist.pop()
        blist.pop()
    print(com)
