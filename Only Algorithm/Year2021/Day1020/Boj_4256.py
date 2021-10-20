import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 7)


class Tree:
    def __init__(self, num):
        self.num = num
        self.left = None
        self.right = None

    def a_left(self, tree):
        self.left = tree

    def a_right(self, tree):
        self.right = tree

    def __str__(self):
        return f'{self.num}'


def make_tree(l, r, idx):
    if r < l or len(pre) <= idx:
        return None
    top = pre[idx]
    t = Tree(top)
    if l == r:
        return t
    m_idx = dic[top]
    t.a_left(make_tree(l, m_idx - 1, idx + 1))
    t.a_right(make_tree(m_idx + 1, r, idx + (m_idx - l) + 1))
    return t


def post_print(tree):
    if tree.left != None:
        post_print(tree.left)
    if tree.right != None:
        post_print(tree.right)
    post.append(tree.num)
    return


T = int(input())
for tc in range(T):
    n = int(input())
    pre = list(map(int, input().split()))
    mid = list(map(int, input().split()))
    dic = {x: i for i, x in enumerate(mid)}
    tr = make_tree(0, len(pre) - 1, 0)
    post = []
    post_print(tr)
    print(*post)
