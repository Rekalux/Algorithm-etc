# readlines, dictionary 활용법
# import sys
#
# input = sys.stdin.readlines
# dic, n = {}, 0
# trees = input()
# for tree in trees:
#     dic[tree] = dic.get(tree, 0) + 1
#     n += 1
# for tree in sorted(dic.keys()):
#     print(tree[:-1], format((dic[tree] / n * 100),".4f"))

#####################################################################################
# open, Counter 활용법
from collections import Counter

file = open(0)
trees = list(file)
counter = Counter(trees)
n = len(trees)
for tree in sorted(counter):
    print(tree[:-1], format((counter[tree] / n * 100), ".4f"))
