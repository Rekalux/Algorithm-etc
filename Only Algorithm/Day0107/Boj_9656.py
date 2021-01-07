n = int(input())
a = [True,False]
for i in range(2,n+1):
    if a[i-1]:
        a.append(False)
    elif i>=4 and a[i-3]:
        a.append(False)
    else:
        a.append(True)
print(a[:])