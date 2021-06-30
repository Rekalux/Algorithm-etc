a, b, c, x, y = map(int, input().split())
a2 = a * 2
b2 = b * 2
c2 = c * 2
# 1. 후라이드 1개와 양념 1개 보다 반반 2개가 더 싼 경우
# 1-1. 양념이 남은 경우
# 1-2. 후라이드가 남은 경우
# 2. 후라이드 1개와 양념 1개 보다 반반 2개가 더 비싼 경우
result = 0
if a + b > c2:  # 1
    result = min(x, y) * c2
    if x > y:  # 1-1
        if a > c2:
            result += ((x - y) * c2)
        else:
            result += ((x - y) * a)
    else:  # 1-2
        if b > c2:
            result += ((y - x) * c2)
        else:
            result += ((y - x) * b)
else:  # 2
    result = a * x + b * y
print(result)
