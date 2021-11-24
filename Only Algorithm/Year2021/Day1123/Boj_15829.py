input();l,r,t=input(),0,1234567891
for i in range(len(l)):
    r+=(((ord(l[i])-ord('a')+1)*(31**i))%t)
    r%=t
print(r)