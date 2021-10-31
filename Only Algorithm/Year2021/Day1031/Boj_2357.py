import sys

input = sys.stdin.readline


class node:
    def __init__(self, s, e, m, n):
        self.s = int(s)  # 시작노드
        self.e = int(e)  # 끝노드
        self.m = int(m)  # 최대값
        self.n = int(n)  # 최소값
        self.l = None  # 왼쪽노드
        self.r = None  # 오른쪽노드


def make_tree(s, e):
    if s >= e:
        obj = li[s]
        return node(s, e, obj, obj)
    mid = (s + e) // 2
    ln = make_tree(s, mid)
    rn = make_tree(mid + 1, e)
    new_m = max(ln.m, rn.m)
    new_n = min(ln.n, rn.n)
    n2 = node(s, e, new_m, new_n)
    n2.l = ln
    n2.r = rn
    return n2


def find(s, e, t):
    if t.s == s and t.e == e:
        return (t.n, t.m)
    mid = (t.s + t.e) // 2
    n, m = t.m, t.n
    if t.s <= s <= mid:
        n, m = find(s, min(e, mid), t.l)
        # print(f'{t.s}와 {t.e} 사이 {mid}의 왼쪽 : {n}, {m}')
    if mid < e <= t.e:
        n2, m2 = find(max(s, mid + 1), e, t.r)
        # print(f'{t.s}와 {t.e} 사이 {mid}의 오른쪽 : {n2}, {m2}')
        n, m = min(n, n2), max(m, m2)
    return (n, m)


n, m = map(int, input().split())
li = []
for i in range(n):
    li.append(input())
tree = make_tree(0, len(li) - 1)
for i in range(m):
    a, b = map(lambda x: int(x) - 1, input().split())
    print(*find(a, b, tree))
