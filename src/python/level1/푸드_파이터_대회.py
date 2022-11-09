def solution(food):
    answer = ''

    # stack = []
    # return ''.join(map(str, chain(stack, [0], stack[::-1])))
    # ''.join(str(chain(stack, [0], stack[::-1]))))

    for idx, val in enumerate(food[1:]):
        for _ in range(val // 2):
            answer += str(idx + 1)

    answer = answer + '0' + answer[::-1]
    print(answer)
    return answer