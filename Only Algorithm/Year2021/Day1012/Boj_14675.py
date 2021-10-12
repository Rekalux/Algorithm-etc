import sys
input = sys.stdin.readline
n = int(input())
link = [set() for _ in range(n)]
for i in range(n-1):
    a,b = map(lambda x: int(x)-1,input().split())
    link[a].add(b)
    link[b].add(a)
m = int(input())
for i in range(m):
    t, k = map(lambda x: int(x)-1,input().split())
    if t == 0: # k번 정점이 단절점인지? 해당 정점을 연결하는 간선이 2개 이상이라면 단절점이다.
        # 1. 트리는 모든 정점과 연결되어 있는 반면 사이클이 없다.
        # 2. 따라서 트리에서 두 정점을 잇는 경로는 유일하다.
        # 3. 두 정점을 잇는 어느 하나의 정점도 단절점임이 자명하다.
        if len(link[k]) >= 2:
            print('yes')
        else:
            print('no')
    else: # k번째 간선이 단절선인지? -> 트리에서 간선의 개수는 n-1개로 절대적이다.
        # 따라서 어떠한 간선도 자르면 트리가 아니다.
        print('yes')