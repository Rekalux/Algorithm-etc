import random
f = open('testcase.txt','w')
print = lambda x : f.write(str(x))
rr = random.random
r = lambda x : int(rr()*x)
T = 10
print(T)
print('\n')
for i in range(T):
    a = r(100)
    b = r(50)
    c = r(50)
    print = lambda a,b,c: f.write(''.join([' '.join([str(a),str(b),str(c)]),'\n']))
    print(a+1,b,c)
    for i in range(b):
        print(r(a)+1,r(a)+1,r(10))
    for i in range(c):
        print(r(a)+1,r(a)+1,r(10))

f.close()