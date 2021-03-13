def binary_search(li, obj):
    start, end = 0, len(li)
    while start < end:
        mid = (start + end) // 2
        if li[mid] == obj:
            return mid
        elif li[mid] > obj:
            end = mid
        else:
            start = mid + 1
    return start


max_num = 9999999999
n = int(input())
num_list = sorted(list(map(int, input().split())))
dis = max_num
dap_list = []
for i in range(len(num_list)):
    for j in range(len(num_list)):
        if i == j:
            continue
        hap = num_list[i] + num_list[j]
        chai = binary_search(num_list, -hap)
        for k in range(-1, 2):
            if chai + k < 0 or chai + k >= len(num_list):
                continue
            if chai + k == i or chai + k == j:
                continue
            value = abs(num_list[chai + k] + hap)
            if dis > value:
                dis = value
                dap_list = [i, j, chai + k]
print(*sorted(map(lambda X: num_list[X], dap_list)))
