def find(leaf, keyword):
    ans = []
    yebi = []
    l = leaf.keys()
    for i in leaf.keys():
        if i.find(keyword) == -1:
            continue
        if i == keyword:
            ans.append(i)
            continue
        test = str(i)
        findlist = []
        while test.find(keyword) != -1:
            fn = test.find(keyword)
            findlist.append(fn)
            test = str(test[:fn] + test[(fn + len(keyword)):])
        yebi.append((i, findlist))
    yebi.sort(key=lambda x: (len(x[1]), x[1], leaf[x[0]]))
    ans = ans + list(map(lambda x: x[0], yebi))
    return ans


def solution(data, word):
    answer = []
    print(data)
    d = {}
    leaf = {}
    for i in data:
        idn, doll, mo = i.split()
        idn, mo = int(idn), int(mo)
        d[idn] = [doll, mo]
        leaf[doll] = idn
    for i in d:
        if d[i][1] and d[d[i][1]][0] in leaf:
            leaf.pop(d[d[i][1]][0])

    flist = find(leaf, word)
    print(d)
    for i in flist:
        mo = leaf[i]
        result_word = ''
        while mo != 0:
            result_word = str(d[mo][0] + '/' + result_word)
            mo = d[mo][1]
        answer.append(result_word[:-1])
    if len(answer)==0:
        answer.append("Your search for ({}) didn't return any results".format(word))
    return answer


ip1 = ["1 ROOTA 0", "2 AA 1", "3 ZZZ 1", "4 AABAA 1", "5 AAAAA 1", "6 AAAA 1", "7 BAAAAAAA 1", "8 BBAA 1", "9 CAA 1", "10 ROOTB 0", "11 AA 10"]
ip2 = "AA"
print(solution(ip1, ip2))
