import sys

input = sys.stdin.readline
n = int(input())
num = set()
count = {}
for i in range(n):
    g = int(input())
    num.add(g)
    count[g] = count.get(g, 0) + 1
num = list(num)
num.sort()
N = len(num)
dic = [{} for _ in range(N)]
for i in range(N):
    for j in range(i + 1, N):
        chai = abs(num[i] - num[j])
        dic[j][chai] = dic[i].get(chai, 0) + 1
m_list = []
for i in range(N):
    if not dic[i]:
        continue
    m_list.append(max(dic[i].values()))
a = 1
if m_list:
    a = max(m_list) + 1
b = max(count.values())
print(max(a,b))