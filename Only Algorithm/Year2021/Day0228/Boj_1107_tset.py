obj = input()
obj_num = int(obj)
n = int(input())
if n == 0:
    s = {i for i in range(10)}
else:
    s = {0,1,2,3,4,5,6,7,8,9} - set(map(int, input().split()))
big = ''
small = ''
pre_big = ['up']*10
pre_small = ['down']*10
count = 0
for i in list(obj):
    if int(i) in s: # 숫자가 있는 경우
        big = big + i
        small = small + i
        for j in range(int(i)+1,10): # 하나 더 큰 수를 찾아둠
            if j in s:
                pre_big[count] = str(j)
                break
        for j in range(int(i),-1,-1): # 하나 더 작은 수를 찾아둠
            if j in s:
                pre_small[count] = str(j)
                break
    else: # 없는 경우
        find_big = False
        find_small = False
        min_count = count
        for j in range(int(i)+1,10): # 큰수
            if j in s:
                big += str(j)
                big += str(min(s))*(len(obj)-count-1)
                find_big = True
                break
        if not find_big:
            while count > 0:
                if pre_big[count-1] == 'up':
                    count -= 1
                else:
                    big = big[:count] + pre_big[count-1] +str(min(s))*(len(obj)-count)
                    break
            if count == 0:
                if not len(s-{0}):
                    big = '99999999'
                else:
                    big = str(min(s-{0}))+str(min(s)) * (len(obj))

        for j in range(int(i),-1,-1): # 작은수
            if j in s:
                small += str(j)
                small += str(max(s))*(len(obj)-min_count-1)
                find_small = True
                break
        if not find_small:
            while min_count > 0:
                if pre_small[min_count-1] == 'down':
                    min_count -= 1
                else:
                    small = small[:min_count] + pre_small[min_count-1] +str(max(s))*(len(obj)-min_count)
                    break
            if min_count == 0:
                if not len(s):
                    big = '-9999999'
                else :
                    small = str(max(s)) * (len(obj)-1)
                if len(obj)-1 == 0:
                    small = '-9999999'
        break
    count += 1
big_num = len(big) + int(big) - obj_num
small_num = len(small) + obj_num - int(small)
print(min(abs(big_num),abs(small_num),abs(100-obj_num)))