n, k = map(int, input().split())
li = list(map(int, input().split()))
nli = [li[i] - li[i - 1] for i in range(1, n)]
nli.sort()
print(sum(nli[:n - k]))
