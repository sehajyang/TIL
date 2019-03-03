from collections import defaultdict


def solution(genres, plays):
    result = []
    plays_and_index = []

    for item in enumerate(plays):
        plays_and_index.append(item)
    genres_and_plays_and_index = list(zip(genres, plays_and_index))

    d = defaultdict(list)
    for k, v in genres_and_plays_and_index:
        d[k].append(v)

    dic = {}
    for item in d.items():
        item[1].sort(key=lambda e: e[0])
        dic[item[0]] = sum([item[1] for item in item[1]])

    max_genres = sorted(dic, key=dic.get, reverse=True)
    for item in max_genres:
        sorted_d = sorted(d[item], key=lambda e: (-e[1], e[0]))
        for item in sorted_d[:2]:
            result.append(item[0])

    return result
