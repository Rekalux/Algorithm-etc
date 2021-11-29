for i in '1'*3:
    a,b,c,A,B,C = map(int,input().split())
    A,B,C= A-a,B-b,C-c
    if C < 0:
        B-=1
        C+=60
    if B < 0:
        A-=1
        B+=60
    print(A,B,C)