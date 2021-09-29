# 7662. 이중 우선순위 큐
import heapq

# input
T = int(input())
for t in range(T):
    n = int(input())
    big_q, small_q = [], []  # big은 큰 수, small은 작은 수 Priority queue
    big_es, small_es = {}, {}  # 제거된 원소를 저장하는 Dictionary
    for i in range(n):
        com, num = input().split()
        num = int(num)
        if com == 'I':  # insert
            heapq.heappush(big_q, -num)
            heapq.heappush(small_q, num)
        else:  # delete
            if not (big_q and small_q):
                continue
            if num == 1:  # 큰 수 삭제
                erase = -heapq.heappop(big_q)
                small_es[erase] = small_es.get(erase, 0) + 1
            else:  # 작은 수 삭제
                erase = heapq.heappop(small_q)
                big_es[erase] = big_es.get(erase, 0) + 1
            while big_q:
                test_num = -heapq.heappop(big_q)
                if (test_num not in big_es) or (big_es[test_num] < 1):  # 지울 목록에 없으면 되돌림
                    heapq.heappush(big_q, -test_num)
                    break
                else:
                    big_es[test_num] -= 1
            while small_q:
                test_num = heapq.heappop(small_q)
                if (test_num not in small_es) or (small_es[test_num] < 1):  # 지울 목록에 있으면 삭제
                    heapq.heappush(small_q, test_num)
                    break
                else:
                    small_es[test_num] -= 1
    if big_q and small_q:
        print(-heapq.heappop(big_q), heapq.heappop(small_q))
    else:
        print('EMPTY')
