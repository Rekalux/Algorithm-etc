n = int(input())
li = list(map(int, input().split()))
result = 0
t = 100000
one_set = set()
two_set = set()
three_set = set()

for i in range(n):
    for one in one_set:
        if li[i] - one in two_set:
            result += 1
            break
    one_set.add(li[i])
    for one in one_set:
        if -100000 <= one + li[i] <= 100000:
            two_set.add(one + li[i])

print(result)
