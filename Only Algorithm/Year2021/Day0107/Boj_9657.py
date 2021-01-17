n = int(input())
a = [False,True]
for i in range(2,n+1):
    if not a[i-1]:
        a.append(True)
    elif i>=4 and not a[i-3]:
        a.append(True)
    elif i>=4 and not a[i-4]:
        a.append(True)
    else:
        a.append(False)
print("SK" if a[-1] else "CY")