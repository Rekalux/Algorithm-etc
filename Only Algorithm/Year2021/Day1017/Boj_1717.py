# 유니온 파인드

import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 7)


def find(object):
    if object == parent[object]:
        return object
    parent[object] = find(parent[object])
    return parent[object]


def union(a, b):
    a = find(a)
    b = find(b)
    a, b = min(a, b), max(a, b)
    parent[b] = a


def check(a, b):
    print('YES') if find(a) == find(b) else print('NO')


n, m = map(int, input().split())
parent = list(range(n + 1))
for i in range(m):
    c, a, b = map(int, input().split())
    union(a, b) if c == 0 else check(a, b)
