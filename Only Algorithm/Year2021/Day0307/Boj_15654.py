def yul(dep, li, use_set, num):
    if dep == 0:
        print(*li)
        return
    for i in nums:
        if i in use_set:
            continue
        use_set.add(i)
        li.append(i)
        yul(dep - 1, li, use_set, num)
        li.pop()
        use_set.remove(i)


n, m = map(int, input().split())
nums = sorted(map(int, input().split()))
yul(m, [], set(), nums)