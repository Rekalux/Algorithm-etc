def multiple(li):
    result = 1
    for i in li:
        result *= i
    return result


s = input()
toNum = lambda X: ord(X) - ord('a') + 1
nums = list(map(toNum, list(s)))
print(nums,multiple(nums))