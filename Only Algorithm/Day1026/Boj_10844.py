N = int(input())

arr = [0]+[1]*9
#print(arr)
for i in range(N-1):
    newarr = [0]*10
    for j in range(10):

        if j == 0 :
            newarr[1] += arr[0]
        elif j == 9 :
            newarr[8] += arr[9]
        else:
            newarr[j-1] += arr[j]
            newarr[j+1] += arr[j]
        newarr[j] %= 1000000000
    arr = newarr
    # print(newarr)
print( sum(arr) % 1000000000 )

    # sum = 15;
    # for i in range(N-2):
    #     sum *= 2
    #     sum %= 1000000000
    # result = (sum + 2) % 1000000000
    # print(result)

# 문자열을 만들 때, 만든 문자열 size, 모양
# cnt = 0
# def dfs(string): # 깊이 1000이상 재귀 X => deque 이나 stack 구현
#     global cnt
#     if len(string) == N:
#         cnt += 1
#         return
#     if len(string) == 0:
#         for i in range(1,10):
#             newstring = str(i)
#             dfs(newstring)
#         return
#     num = int(string[len(string)-1])
#     for i in [-1, 1]:
#         newnum = num + i
#         if newnum < 0 or newnum > 9:
#             continue
#         newstring = string + str(newnum)
#         dfs(newstring)[-1, 1]
# dfs("")
# print(cnt)



