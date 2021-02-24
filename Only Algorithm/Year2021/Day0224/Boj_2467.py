from collections import deque

num = int(input())
num_list = list(map(int, input().split()))
q = deque(num_list)
left = q.popleft()
right = q.pop()
hap = left + right
result = abs(hap)
result_value = [left, right]
while q:
    if hap < 0:
        left = q.popleft()
    elif hap > 0:
        right = q.pop()
    else:
        break
    hap = left + right
    result_temp = min(result, abs(hap))
    if result != result_temp:
        result_value = [left, right]
    result = result_temp
print(result_value[0], result_value[1])
