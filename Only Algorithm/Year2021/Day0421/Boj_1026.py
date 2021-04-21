n = int(input())
A = list(reversed(sorted(list(map(int, input().split())))))
B = sorted(list(map(int, input().split())))
print(sum([A[i] * B[i] for i in range(n)]))
