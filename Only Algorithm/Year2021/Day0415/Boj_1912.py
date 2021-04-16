n = int(input())
li = list(map(int, input().split()))
result = -9999999999
hap = -9999999999
for i in range(n):
    hap = max(hap, 0) + li[i]
    if hap > result:
        result = hap
print(result)
