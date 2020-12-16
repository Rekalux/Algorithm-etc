drug = []
for w in range(31):
    druglist = []
    for h in range(31-w):
        if w == h == 0:
            druglist.append(1)
            continue
        half = 0
        whole = 0
        if w > 0:
            whole = drug[w-1][h+1]
        if h > 0:
            half = druglist[h-1]
        druglist.append(half+whole)
    drug.append(druglist)
while True:
    a = int(input())
    if not a:
        break
    print(drug[a][0])