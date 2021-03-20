def solution(table,languages, preference):
    table = list(map(lambda x: x.split(),table))
    t = {}
    for i in table:
        t[i[0]] = i[1:]
    d = {}
    for i in range(len(languages)):
        d[languages[i]] = preference[i]
    score = {}
    for i,j in t.items():
        score[i] = 0
        for k in range(len(j)):
            if j[k] in d:
                score[i] += ((5-k) * d[j[k]])
    alist = []
    max_value = max(score.values())
    for i in score:
        if score[i] == max_value:
            alist.append(i)
    alist.sort()
    answer = alist[0]
    return answer

kkk = ["SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"]
kkkk =  ["PYTHON", "C++", "SQL"]
print(solution(kkk,kkkk,[7, 5, 5]))