import sys
from pprint import pprint

input = sys.stdin.readline
n, m = map(int, input().split())
seg = []
first_row = []
for i in range(n):
    g = int(input())
    first_row.append((g, g))
seg.append(first_row)
last_row = first_row
while len(last_row) > 1:
    new_row = []
    for i in range(0, len(last_row), 2):
        if i == len(last_row) - 1:
            new_mm = last_row[i]
        else:
            new_max, new_min = max(last_row[i][0], last_row[i + 1][0]), min(last_row[i][1], last_row[i + 1][1])
            new_mm = (new_max, new_min)
        new_row.append(new_mm)
    seg.append(new_row)
    last_row = new_row
pprint(seg)
d = len(seg) - 1
for i in range(m):
    a, b = map(lambda x: int(x) - 1, input().split())