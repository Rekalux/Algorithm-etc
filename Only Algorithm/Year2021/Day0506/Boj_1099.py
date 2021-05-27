sentence = input()
n = int(input())
words = []
for i in range(n):
    words.append(input())
dp = [-1] * (len(sentence) + 1)  # dp[i]는 i-1까지의 알파벳으로 만들 수 있는 비용을 의미한다.
dp[0] = 0
for i in range(len(sentence)):  # 각 자리에서부터
    if dp[i] == -1:  # 이미 앞선 단어들이 완성될 수 없다면 무시한다.
        continue
    for word in words:  # 각 단어들이 들어갈 수 있는지 확인
        le = len(word)  # 단어의 길이가 le
        is_possible = True
        if le + i > len(sentence):  # 길이초과로 넣을 수 없다면 패스
            continue
        arr = {}
        dif = 0
        for j in range(len(word)):  # 단어의 알파벳을 확인
            arr[sentence[i + j]] = arr.get(sentence[i + j], 0) - 1  # 센텐스의 알파벳은 감소
            arr[word[j]] = arr.get(word[j], 0) + 1  # 워드의 알파벳은 증가
            if sentence[i + j] != word[j]:  # 각 자리가 다르면 1씩 숫자 증가
                dif += 1
        for j in arr.values():  # 결국 워드와 센텐스가 모두 같은 알파벳이었어야 하므로
            if not j == 0:
                is_possible = False  # 0인 경우는 단어로 해석할 수 없음을 의미한다.
                break
        if not is_possible:
            continue
        dp[i + le] = min(dp[i + le], dp[i] + dif) if dp[i + le] != -1 else dp[i] + dif
print(dp[-1])  # 마지막으로 최소변경값으로 저장된 값을 불러온다
