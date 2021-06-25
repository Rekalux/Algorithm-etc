from sys import setrecursionlimit

setrecursionlimit(200000)
n = int(input())
mid = list(map(int, input().split()))
post = list(map(int, input().split()))
T = [[-1 for i in range(2)] for j in range(n + 1)]
mid_p = [-1] * (n + 1)
for i in range(n):
    mid_p[mid[i]] = i


def make_tree(mid_a,mid_b,post_a,post_b):
    if not mid_a < mid_b:
        return
    parent = post[post_b]
    p_index = mid_p[parent]
    post_len = p_index - mid_a
    if 0 < post_len:
        T[parent][0] = post[post_a + post_len - 1]
    if post_a + post_len < post_b:
        T[parent][1] = post[post_b - 1]
    make_tree(mid_a, p_index - 1, post_a, post_a + post_len - 1)
    make_tree(p_index + 1, mid_b, post_a + post_len, post_b - 1)


def pre_print(mother):
    print(mother, end=' ')
    if not T[mother][0] == -1:
        pre_print(T[mother][0])
    if not T[mother][1] == -1:
        pre_print(T[mother][1])


make_tree(0, n - 1, 0, n - 1)
root = post[-1]
pre_print(root)
