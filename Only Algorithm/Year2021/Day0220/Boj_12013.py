n = input()
n_list = []
for i in range(int(n)):
      n_list.append(int(input()))
for i in range(1,50):
      start = -1
      end = -1
      j=-1
      while j != len(n_list):
            j += 1
            # print(n_list,j,start,end)
            if j==len(n_list):
                  if start != end:
                        minus = end - start
                        if minus % 2:
                              middle_list = [i+1] * (minus//2+1)
                        else:
                              small_list = [i+1] * (minus//2)
                              middle_list = small_list + [1] + small_list 
                        n_list = n_list[:start] + middle_list + n_list[end+1:]
                        j = -1
                        start = -1
                        end = -1
                  continue
            if i == n_list[j] and start == -1:
                  start = j
            if i == n_list[j]:
                  end = j
            if i != n_list[j] and start == end:
                  start = -1
                  end = -1
                  continue
            if i != n_list[j]:
                  minus = end - start
                  if minus % 2:
                        middle_list = [i+1] * (minus//2+1)
                  else:
                        small_list = [i+1] * (minus//2)
                        middle_list = small_list + [i] + small_list      
                  n_list = n_list[:start] + middle_list + n_list[end+1:]
                  start = -1
                  end = -1
                  j = -1
print(max(n_list))
