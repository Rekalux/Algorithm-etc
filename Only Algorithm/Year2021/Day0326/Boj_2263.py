import sys

input = sys.stdin.readline
sys.setrecursionlimit(10 ** 7)


def pre_order_append(i):
    pre_order.append(tree[i])
    if i * 2 in tree:
        pre_order_append(i * 2)
    if i * 2 + 1 in tree:
        pre_order_append(i * 2 + 1)


def make_a_tree(k, s, e):
    print(k,s,e)
    input()
    if s > e:
        return
    tree[k] = post_order[e]
    if s == e:
        return
    tree_size = e-s-1
    # make_a_tree(k * 2, s, s + tree_size)
    # make_a_tree(k * 2 + 1, s+tree_size+1,s+1)


n = int(input())
index = [-1] * (n + 1)
mid_order = list(map(int, input().split()))
for i in range(n):
    index[mid_order[i]] = i
post_order = list(map(int, input().split()))
tree = {}
make_a_tree(1,0,n-1)

pre_order = []
pre_order_append(1)

print(*pre_order)
