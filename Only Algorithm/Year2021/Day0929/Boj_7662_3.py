import sys, bisect

input = sys.stdin.readline
T = int(input())
for _ in ' ' * T:
    n = int(input())
    li, nums = [], {}
    for _ in ' ' * n:
        command, num = input().split()
        num = int(num)
        if command == 'I':
            nums[num] = nums.get(num, 0) + 1
            if nums[num] == 1:
                bisect.insort(li, num)
        elif li:
            num = -1 if num == 1 else 0
            nums[li[num]] -= 1
            if nums[li[num]] == 0:
                del li[num]
    print(f'{li[-1]} {li[0]}' if li else 'EMPTY')
