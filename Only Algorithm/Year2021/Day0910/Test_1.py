import sys
sys.setrecursionlimit(10**7)
m = 0

def solution(info, edges):
    answer = 0
    tree = [[-1,-1] for i in range(len(info))]
    for e in edges:
        if tree[e[0]][0] == -1:
            tree[e[0]][0] = e[1]
        else:
            tree[e[0]][1] = e[1]
    print(tree)

    tracking(tree,1,0,tree[0][:],info)
    global m
    answer = m
    return answer

def tracking(tree,sheep,wolf,road,info):
    global m
    m = max(m, sheep)
    if sheep <= wolf:
        return
    for i in range(len(road)):
        nroad = road[:i]+road[i+1:]
        print(m, nroad, i, road[i] ,sheep,wolf,info)
        if tree[road[i]][0] != -1:
            nroad.append(tree[road[i]][0])
        if tree[road[i]][1] != -1:
            nroad.append(tree[road[i]][1])
        if info[road[i]] == 0:
            m = max(m,sheep + 1)
            tracking(tree,sheep + 1, wolf,nroad,info)
        else:
            tracking(tree,sheep,wolf + 1,nroad,info)

print(solution([0,0,1,1,0],[[0,1],[1,2],[2,3],[3,4]]))