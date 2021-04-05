n = int(input())
li = list(map(int, input().split()))
result = 0
t = 100000
one_set = set()
two_set = set()
three_set = set()

for i in range(n):
    if li[i] in three_set:
        result += 1
    one_set.add(li[i])
    for one in one_set:
        if -100000 <= one+li[i] <= 100000:
            two_set.add(one+li[i])
    for two in two_set:
        if -100000 <= two+li[i] <= 100000:
            three_set.add(two+li[i])
print(result)