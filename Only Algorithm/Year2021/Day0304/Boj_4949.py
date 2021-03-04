class Stack:
    def __init__(self):
        self.li = []
        self.count = 0

    def push(self, word):
        self.li.append(word)
        self.count += 1

    def pop(self):
        if not len(self.li):
            return False
        self.count -= 1
        return self.li.pop()

    def length(self):
        return self.count


link = {')': '(', ']': '['}

while True:
    st = input()
    if st == '.':
        break
    s = Stack()
    result = True
    for c in st:
        if c == '[' or c == '(':
            s.push(c)
        elif c == ']' or c == ')':
            test_value = s.pop()
            result = False if not test_value or link[c] != test_value else True
        if not result:
            break
    if s.length() != 0:
        result = False
    print('yes' if result else 'no')
