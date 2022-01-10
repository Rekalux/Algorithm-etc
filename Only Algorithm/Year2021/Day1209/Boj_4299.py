a, b = map(int, input().split())
print(-1) if a < b or (a + b) % 2 else print((a + b) // 2, (a - b) // 2)
