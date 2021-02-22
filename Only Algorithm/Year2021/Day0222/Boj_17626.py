num = int(input())
list1 = [4] * 50000
for i in range(1, num+1):
    for j in range(1, i+1):
        k = i - j**2
        if k < 0:
            break
        if k == 0:
            list1[i] = 1
            break
        if list1[k] == 1:
            list1[i] = min(list1[i], 2)
        elif list1[i-j**2] == 2:
            list1[i] = min(list1[i], 3)
print(list1[num])