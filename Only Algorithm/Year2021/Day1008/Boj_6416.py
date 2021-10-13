import sys

inp = sys.stdin.readlines()
numbers = []
for line in inp:
    numbers.extend(map(int, line.split()))
link = {}
node = {}  # 등장한 노드 : visit 여부
down_list = set()
case = 1
find = True  # 트리라고 가정하고 시작함
for i in range(0, len(numbers), 2):
    up, down = numbers[i], numbers[i + 1]
    if up < 0 and down < 0:
        break
    if up == 0 and down == 0:  # Case 마지막
        root_list = []
        for key in node:
            if not node[key]:
                root_list.append(key)
        if not node:  # 들어온 노드가 없으면
            print(f'Case {case} is a tree.')
            case += 1
            find = True
            continue
        if len(root_list) == 1:  # 루트노드가 단 하나인 경우만 인정
            root = root_list[0]
            stack = [root]  # 스택에 루트를 넣고 시작
            while stack:  # dfs 시작
                now_node = stack.pop()
                for next_node in link[now_node]:
                    if not node[next_node]:  # 가려는 노드가 이미 방문한 노드이면?
                        find = False
                        break
                    stack.append(next_node)
                    node[next_node] = False  # 방문했음을 처리
            for key in node:
                if node[key]:  # 방문 안 한 곳이 있다면?
                    find = False
        else:
            find = False
        print(f'Case {case} is a tree.' if find else f'Case {case} is not a tree.')
        case += 1
        find = True  # 트리라고 다시 초기화
        link = {}  # 연산이 끝났으니 초기화
        node = {}
        down_list = set()
        continue
    if down not in link:  # 자식 연결도 빈 링크를 넣어준다
        link[down] = set()
    if up not in link:  # 부모 연결에 자식 노드를 입력한다
        link[up] = set()
    link[up].add(down)
    if up not in node:  # 새로운 노드면 추가
        node[up] = False
    node[down] = True  # 부모가 있는 노드는 True로 변화
    if down in down_list:  # 이미 노드를 한 번 받았으면
        find = False  # 두 개의 노드가 가르키고 있는 꼴이므로 트리가 아님 처리
    down_list.add(down)
