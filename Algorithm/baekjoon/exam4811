"""
https://www.acmicpc.net/problem/4811
알약

1. 첫자리는 무조건 w 고정
2. 앞에 나온 w갯수만큼 h 배치가능
3. 마지막 자리는 무조건 h

재귀로 모든 경우 나눠서 돌림
"""
from functools import lru_cache


@lru_cache(maxsize=None)
def go(w: int, h: int):
    if w == 0:
        return 1

    if w > 0:
        if h > 0:
            return go(w, h - 1) + go(w - 1, h + 1)
        else:
            return go(w - 1, h + 1)


if __name__ == '__main__':
    while True:
        n = int(input())
        if n == 0:
            break
        print(go(n, 0))
