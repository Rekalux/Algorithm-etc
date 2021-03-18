import sys
rf = open('testcase.txt','r')
f = open('test2.txt','w')
print = lambda x : f.write(x)
input = rf.readline


def bellmanFord():
    global isPossible

    for i in range(1, N + 1):
        for j in range(1, N + 1):
            for wei, vec in adjList[j]:
                if dist[vec] > wei + dist[j]:
                    dist[vec] = wei + dist[j]
                    if i == N:
                        isPossible = False


T = int(input())

for _ in range(T):
    N, M, W = map(int, input().split())

    INF = 2147483647
    dist = [INF for _ in range(N + 1)]

    adjList = [[] for _ in range(N + 1)]

    for _ in range(M):
        S, E, T = map(int, input().split())

        adjList[S].append((T, E))
        adjList[E].append((T, S))

    for _ in range(W):
        S, E, T = map(int, input().split())

        adjList[S].append((-T, E))

    isPossible = True

    bellmanFord()

    print("NO\n" if isPossible else "YES\n")

rf.close()
f.close()