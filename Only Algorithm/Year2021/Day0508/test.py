li = []
def a():
    def b():
        return 45
    return b()+4

print(a())