class Solution(object):
    def largestRectangleArea(self, heights):
        index = 1
        result = 0
        stack = [(0,0)]
        heights.append(0)
        for i in heights:
            flag = 0
            while stack[-1][0] > i:
                temp = stack.pop()
                flag = temp[1]
                block = (index - temp[1]) * temp[0]
                result = max(result,block)
            if stack[-1][0] != i:
                if flag == 0:
                    stack.append((i,index))
                else:
                    stack.append((i,flag))
            index += 1
        return result