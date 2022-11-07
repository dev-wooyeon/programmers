def solution(food):
    answer = ''

    home_fighter = ''
    away_fighter = ''
    for idx, val in enumerate(food[1:]):
        for i in range(val // 2):
            home_fighter += str(idx + 1)

    away_fighter = (home_fighter[::-1])
    answer = home_fighter + '0' + away_fighter

    return answer