from collections import defaultdict


def solution(genres, plays):
    result = []

    genre_data = defaultdict(list)
    for genre, _index_and_plays in zip(genres, enumerate(plays)):
        genre_data[genre].append(_index_and_plays)

    sum_of_genres = {}
    for genre, index_and_play_list in genre_data.items():
        sum_of_genres[genre] = sum([_index_and_play[1] for _index_and_play in index_and_play_list])

    max_genres = sorted(sum_of_genres.keys(), key=sum_of_genres.get, reverse=True)

    for genre in max_genres:
        sorted_index_and_plays = sorted(genre_data[genre], key=lambda e: (-e[1], e[0]))
        for index_and_play in sorted_index_and_plays[:2]:
            result.append(index_and_play[0])

    return result


if __name__ == '__main__':
    print(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))
