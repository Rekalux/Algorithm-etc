import sys
sys.setrecursionlimit(10**5)
def suyul(anow,snow):
    if anow == m:
        print(*dap_list)
        return
    if snow == len(nlist):
        return
    dap_list[anow] = nlist[snow]
    suyul(anow+1,snow)
    suyul(anow,snow+1)


n,m = map(int,input().split())
nlist = sorted(list(set(map(int,input().split()))))
dap_list = [0]*m
suyul(0,0)