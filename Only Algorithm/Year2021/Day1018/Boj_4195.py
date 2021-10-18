import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 7)


def find(num):
    if num == party[num]:
        return num
    party[num] = find(party[num])
    return party[num]


def union(a, b):
    a, b = map(lambda x: find(nametag[x]), [a, b])
    if a < b:
        a, b = b, a
    if a == b:
        return cnt_party[b]
    cnt_party[b] += cnt_party[a]
    party[a] = b
    return cnt_party[b]


def add_name(name):
    global count
    if name not in nametag:
        nametag[name] = count
        party.append(count)
        cnt_party.append(1)
        count += 1
    return name


T = int(input())
for tc in range(T):
    n = int(input())
    count = 0
    nametag = {}
    party = []
    cnt_party = []
    for i in range(n):
        a, b = map(add_name, input().split())
        print(union(a, b))
