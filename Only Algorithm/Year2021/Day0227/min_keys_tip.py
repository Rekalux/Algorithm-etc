a = [[4], [9, 5], [2, 2, 2]]


def k(x):
    return x[0]


print(min(a, key=k))
print(min(a, key=len))
