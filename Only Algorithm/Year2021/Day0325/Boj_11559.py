# 1. 세로로 보면서 각각의 색 위치에서 DFS를 부른다.
# 1-1 DFS는 색의 개수를 세고 4개 이상이면 체크를 해둔다.
# 2. 세로로 한줄을 가지고 와서 색을 차례대로 적는다.
# 3. 다 점으로 바꾼 뒤 색을 차례대로 적어준다.
# 1-3까지 반복하다 체크가 존재하지 않으면 break를 하고 출력한다.

puyo = []
for i in range(12):
    puyo.append(list(input().split()))
print(puyo)