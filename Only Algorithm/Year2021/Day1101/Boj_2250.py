import sys

input = sys.stdin.readline
sys.setrecursionlimit(1 << 14)  # 최악의 경우 한 방향으로 10000번 순회


def make_tree(node, depth):
    # 루트부터 시작해서 중위순회하며 순서를 깊이에 따라 최소 최대값을 저장하는 함수
    global count
    if link[node][0] != -1: make_tree(link[node][0], depth + 1)
    if depth not in dmm:
        dmm[depth] = (count, count)
    else:
        dmm[depth] = (min(dmm[depth][0], count), max(dmm[depth][1], count))
    count += 1
    if link[node][1] != -1: make_tree(link[node][1], depth + 1)


def width(x): return dmm[x][1] - dmm[x][0]  # 너비 구하는 함수


def delete(x):
    if x in root_set: root_set.remove(x)


n = int(input())
link = {}  # 트리 연결 딕셔너리
dmm = {}  # 깊이별 최소 최대값
root_set = set(range(1, n + 1))  # 모든 노드 중
for i in range(n):
    n, l, r = map(int, input().split())
    link[n] = (l, r)
    list(map(delete, [l, r]))  # l과 r을 root_set 에서 삭제
root = root_set.pop()  # 남는 노드가 루트
count = 1  # 순서 인덱스
make_tree(root, 1)
max_key = max(dmm, key=lambda x: (width(x), -x))  # 너비 큰 순서, 번호 작은 순서 맨 앞의 값
print(max_key, width(max_key) + 1)
