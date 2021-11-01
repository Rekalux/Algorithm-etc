import sys

input = sys.stdin.readline
division_num = 1000000007


class Node:
    def __init__(self, s, e, v):
        self.s = s  # 왼쪽 영역
        self.e = e  # 오른쪽 영역
        self.v = v  # 누적 곱
        self.l = None  # 왼쪽노드
        self.r = None  # 오른쪽노드


def make_tree(s, e):
    if e <= s:
        return Node(s, s, li[s])
    mid = (s + e) // 2
    l = make_tree(s, mid)
    r = make_tree(mid + 1, e)
    new_node = Node(s, e, l.v * r.v % division_num)
    new_node.l = l
    new_node.r = r
    return new_node


def change_li(se, value, node):
    if node.s == node.e == se:  # 찾으면
        node.v = value  # 변경
        return
    mid = (node.s + node.e) // 2
    change_li(se, value, node.l) if node.s <= se <= mid else change_li(se, value, node.r)  # 더 깊이 들어가서 찾는다
    node.v = node.l.v * node.r.v % division_num  # 바뀐 노드를 바탕으로 재 계산


def find_product(s, e, node):
    if node.s == s and node.e == e:
        return node.v
    result = 1
    mid = (node.s + node.e) // 2
    if node.s <= s <= mid:
        result = result * find_product(s, min(e, mid), node.l) % division_num
    if mid < e <= node.e:
        result = result * find_product(max(s, mid + 1), e, node.r) % division_num
    return result


n, m, k = map(int, input().split())
li = []
for _ in range(n):
    li.append(int(input()))
tree = make_tree(0, n - 1)
for _ in range(m + k):
    c, a, b = map(lambda x: int(x) - 1, input().split())
    if c == 0:
        change_li(a, b + 1, tree)
    else:
        print(find_product(a, b, tree))
