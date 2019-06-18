# source : https://www.acmicpc.net/problem/16283

def solution(a, b, tc, tf):
    b_minus_a = b - a
    tf_minus_tca = tf - (tc * a)

    # 해 2개이상이거나 없는
    if a == b:
        if a + b == tf and tc == 2:
            return '1 1'
        return '-1'

    elif b_minus_a != 0:
        if tf_minus_tca % b_minus_a == 0:
            y = tf_minus_tca / b_minus_a
            x = tc - y
            if x < 1 or y < 1:
                return '-1'
            else:
                return f'{int(x)} {int(y)}'

    return '-1'

if __name__ == '__main__':
    ll = input().split()
    print(solution(int(ll[0]), int(ll[1]), int(ll[2]), int(ll[3])))
