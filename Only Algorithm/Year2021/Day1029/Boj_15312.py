dic = [3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1]
a, b = input(),input()
A, B = [dic[ord(i)-ord('A')] for i in a], [dic[ord(i)-ord('A')] for i in b]
S = []
for i in range(len(A)):
    S.append(A[i])
    S.append(B[i])
while len(S) > 2:
    s = []
    for i in range(1,len(S)):
        s.append((S[i-1] + S[i]) % 10)
    S = s
print(f'{S[0]}{S[1]}')