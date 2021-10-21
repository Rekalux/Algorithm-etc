import sys

input = sys.stdin.readline
n, m = map(int, input().split())
dic = {}
for _ in range(n):
    ID, password = input().split()
    dic[ID] = password
for _ in range(m):
    ID = input().strip()
    print(dic[ID])
