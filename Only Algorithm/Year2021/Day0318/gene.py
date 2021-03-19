import random
f = open('testcase.txt','w')
print = lambda x : f.write(str(x))
rr = random.random
r = lambda x : int(rr()*x)
T = 3
print(T)
print('\n')
for i in range(T):
    a = r(10)
    b = r(7)
    c = r(5)
    print = lambda a,b,c: f.write(''.join([' '.join([str(a),str(b),str(c)]),'\n']))
    print(a+1,b,c)
    for i in range(b):
        print(r(a)+1,r(a)+1,r(10))
    for i in range(c):
        print(r(a)+1,r(a)+1,r(10))

f.close()