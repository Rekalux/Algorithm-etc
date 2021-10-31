input();l,d,c,r=input(),{'p':1,'P':2,'A':3},0,0
for i in l:
    if c==3and d[i]==1:r,c=r+1,0;continue
    if c+1==d[i]:c+=1
    elif d[i]==1:c=1
    else:c=0
print(r)

# i=input;i();print(i().count('pPAp'))