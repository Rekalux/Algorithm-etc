num = int(input())
result = 0
x2, y2 = map(int, input().split())
sx, sy = x2, y2
for _ in range(num-1):
    x1, y1 = map(int, input().split())
    result += ((x1 + x2) * (y1 - y2))
    x2, y2 = x1, y1
result += ((sx + x2) * (sy - y2))
print(round(abs(result / 2), 2))
