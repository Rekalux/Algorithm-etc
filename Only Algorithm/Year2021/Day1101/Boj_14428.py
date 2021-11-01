import sys

input = sys.stdin.readline
lkey = lambda x: (li[x], x)
min_idx = lambda x, y: min(x, y, key=lkey)


class Node:
    def __init__(self, s, e, v):
        self.s = s
        self.e = e
        self.v = v
        self.l = None
        self.r = None


def make_tree(s, e):
    if s == e:
        return Node(s, s, s)
    mid = (s + e) // 2
    l = make_tree(s, mid)
    r = make_tree(mid + 1, e)
    nn = Node(s, e, min_idx(l.v, r.v))
    nn.l, nn.r = l, r
    return nn


def change_li(s, node):
    if node.s == node.e: return
    mid = (node.s + node.e) // 2
    change_li(s, node.l) if node.s <= s <= mid else change_li(s, node.r)
    node.v = min_idx(node.l.v, node.r.v)


def find(s, e, node):
    if node.s == s and node.e == e:
        return node.v
    mid = (node.s + node.e) // 2
    idx = s
    if node.s <= s <= mid:
        idx = min_idx(idx, find(s, min(e, mid), node.l))
    if mid < e <= node.e:
        idx = min_idx(idx, find(max(s, mid + 1), e, node.r))
    return idx


n = int(input())
li = list(map(int, input().split()))
tree = make_tree(0, n - 1)
m = int(input())
for i in range(m):
    c, a, b = map(int, input().split())
    if c == 1:
        li[a - 1] = b
        change_li(a - 1, tree)
    else:
        print(find(a - 1, b - 1, tree) + 1)
