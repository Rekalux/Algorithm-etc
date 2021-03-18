rf = open('test1.txt','r')
a = rf.readlines()
rf = open('test2.txt','r')
b = rf.readlines()
if a == b:
    print(True)
else:
    print(False)
