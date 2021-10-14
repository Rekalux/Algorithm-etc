x, y, x2, y2 = map(int, input().split())
x3, y3, x4, y4 = map(int, input().split())


class p:
    def __init__(self, x, y):
        self.x = x
        self.y = y


p1 = p(x, y)
p2 = p(x2, y2)
p3 = p(x3, y3)
p4 = p(x4, y4)


def dir(pp1, pp2, pp3):
    s = (pp1.x * pp2.y) + (pp2.x * pp3.y) + (pp3.x * pp1.y) - (pp2.x * pp1.y) - (pp3.x * pp2.y) - (pp1.x * pp3.y)
    return -1 if s < 0 else 0 if s == 0 else 1


def big_small(pp1, pp2):
    return [max(pp1.x, pp2.x), max(pp1.y, pp2.y), min(pp1.x, pp2.x), min(pp1.y, pp2.y)]


def check(pp1, pp2, pp3, pp4):
    c1, c2, c3, c4 = dir(pp1, pp2, pp3), dir(pp1, pp2, pp4), dir(pp3, pp4, pp1), dir(pp3, pp4, pp2)
    if c1 * c2 == 1 or c3 * c4 == 1:
        return 0
    mx1, my1, nx1, ny1 = big_small(pp1, pp2)
    mx2, my2, nx2, ny2 = big_small(pp3, pp4)
    if c1 * c2 == 0 and c3 * c4 == 0:
        if (nx1 <= pp3.x <= mx1 and ny1 <= pp3.y <= my1) or (
                nx1 <= pp4.x <= mx1 and ny1 <= pp4.y <= my1) or (
                nx2 <= pp1.x <= mx2 and ny2 <= pp1.y <= my2) or (
                nx2 <= pp2.x <= mx2 and ny2 <= pp2.y <= my2
        ):
            return 1
        else:
            return 0
    else:
        return 1


print(check(p1, p2, p3, p4))
