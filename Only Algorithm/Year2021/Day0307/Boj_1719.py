n, m = map(int, input().split())
link = [[999999999] * n for _ in range(n)]
first = [[-1]*n for _ in range(n)]
for i in range(m):
    start, end, dis = map(int, input().split())
    link[start - 1][end - 1] = dis
    link[end - 1][start - 1] = dis
    first[start-1][end-1] = end-1
    first[end-1][start-1] = start-1
for i in range(n):
    link[i][i] = 0
for m in range(n):
    for s in range(n):
        for e in range(n):
            distance = link[s][m] + link[m][e]
            if distance < link[s][e]:
                link[s][e] = distance
                if first[s][m] == -1:
                    first[s][e] = m
                else:
                    first[s][e] = first[s][m]
for i in range(n):
    for j in range(n):
        print(first[i][j]+1 if first[i][j]!=-1 else '-',end = ' ')
    print()
