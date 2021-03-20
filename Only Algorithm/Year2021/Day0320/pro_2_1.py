def is_string(string):  # STRING 조건을 만족하는 지 확인하는 함수
    for character in string:  # 각각의 글자가 STRING의 조건을 만족해야 함
        if not (ord('A') <= ord(character) <= ord('Z') or ord('a') <= ord(character) <= ord('z')):
            return False
    return True


def is_num(string):  # NUMBER 조건을 만족하는 지 확인하는 함수
    for character in string:  # 각각의 글자가 NUMBER의 조건을 만족해야 함
        if not (ord('0') <= ord(character) <= ord('9')):
            return False
    return True


def solution(program, flag_rules, commands):
    answer = []
    flag_rules = list(map(lambda x: x.split(), flag_rules))  # flag_rules를 flag_name과 flag_argument_type으로 나누어 저장합니다.
    flag_rules_dict = dict()
    for flag_rule in flag_rules:
        if flag_rule[0] in flag_rules_dict:
            # 플래그 룰이 여러번 등장 시 무시함
            continue
        flag_rules_dict[flag_rule[0]] = flag_rule[1]
    for command in commands:
        answer_flag = True  # 성공과 실패를 나누는 flag
        command_list = command.split()  # 명령어 형식을 띄어쓰기 단위로 분리합니다.
        if program != command_list[0]:  # 사용하는 프로그램 이름이 다르면
            answer.append(False)  # 실패한 것으로 간주합니다.
            continue
        command_list = command_list[1:]

        command_flag_dict = {}  # flag의 인덱스와 해당 argument들을 저장
        prev = -1  # 이전의 인덱스
        for i in range(len(command_list)):
            if command_list[i][0] == '-':
                # -가 붙은 명령어는 flag
                command_flag_dict[i] = set()
                prev = i
            else:  # argument인 경우
                if prev not in command_flag_dict:
                    # argument인데 앞선 flag가 없음
                    answer_flag = False
                    break
                command_flag_dict[prev].add(command_list[i])  # argument 추가
        for flag_idx in command_flag_dict:
            flag = command_list[flag_idx]
            if flag_rules_dict[flag] == 'STRING':  # flag가 STRING이면
                if len(command_flag_dict[flag_idx]) == 1:  # 길이 1 이어야하고
                    for argument in command_flag_dict[flag_idx]:  # STRING인지 확인
                        if not is_string(argument):
                            answer_flag = False
                    continue
            if flag_rules_dict[flag] == 'STRINGS':  # flag가 STRING이면
                for argument in command_flag_dict[flag_idx]:  # 모두 STRING 확인
                    if not is_string(argument):
                        answer_flag = False
                continue
            if flag_rules_dict[flag] == 'NUMBER':  # flag가 NUMBER이면
                if len(command_flag_dict[flag_idx]) == 1:  # 길이 확인
                    for argument in command_flag_dict[flag_idx]:  # NUMBER 확인
                        if not is_num(argument):
                            answer_flag = False
                    continue
            if flag_rules_dict[flag] == 'NUMBERS':  # flag : NUMBERS
                for argument in command_flag_dict[flag_idx]:  # 모두 NUMBER 확인

                    if not is_num(argument):
                        answer_flag = False
                continue
            if flag_rules_dict[flag] == 'NULL':
                if len(command_flag_dict[flag_idx]) == 0:  # 길이가 0이어야 됨
                    continue
            answer_flag = False
        answer.append(answer_flag)
    return answer


A = "trip"
B = ["-days NUMBERS", "-dest STRING"]
C = ["trip -days 15 10 -dest Seoul Paris", "trip -days 10 -dest Seoul"]
print(solution(A, B, C))
