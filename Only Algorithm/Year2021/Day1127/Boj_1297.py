d,h,w = map(int,input().split())
k=pow(d**2/(w**2+h**2),0.5)
print(int(h*k),int(w*k))