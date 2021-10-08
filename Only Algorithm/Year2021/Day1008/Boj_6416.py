import sys

inp = sys.stdin.readlines()
numbers = []
for line in inp:
    numbers.extend(map(int,line.split()))
print(numbers)
link = {}
for i in range(0,len(numbers),2):
    if numbers[i] < 0 and numbers[i+1] < 0:
        break
    if numbers[i] == 0 and numbers[i+1] == 0:

        link = {}
        continue
    link[numbers[i]] = link.get(numbers[i],set())