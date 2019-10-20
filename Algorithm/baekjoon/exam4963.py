x = [0, 0, 1, -1, 1, -1, 1, -1]
y = [-1, 1, 0, 0, -1, 1, 1, -1]


def get_land_cnt(map_list, width, height):
    visited = [['F' for col in range(width)] for row in range(height)]

    def dfs(idx_i, idx_j):
        will_visit = [(idx_i, idx_j)]

        while will_visit:
            if idx_j == width and idx_i == height:
                break

            # 본인 0, visit = T로 바꿈
            idx_i, idx_j = will_visit.pop()
            visited[idx_i][idx_j] = 'T'
            map_list[idx_i][idx_j] = 0

            for _x, _y in zip(x, y):
                # 현재 위치에서 8방향 탐색
                if -1 < idx_i + _x < height and -1 < idx_j + _y < width:
                    # 연결된 곳 stack에 넣기
                    if map_list[idx_i + _x][idx_j + _y] == 1 and visited[idx_i + _x][idx_j + _y] == 'F':
                        if (idx_i + _x, idx_j + _y) not in will_visit:
                            will_visit.append((idx_i + _x, idx_j + _y))

    cnt = 0
    for i, one_line in enumerate(map_list):
        for j in range(len(one_line)):
            # 실제에서 1이면서 탐색한이력이 없어야됨
            if map_list[i][j] != 0 and visited[i][j] == 'F':
                dfs(i, j)
                cnt += 1
    return cnt


if __name__ == '__main__':
    while True:
        w, h = map(int, input().split())
        # 0 0일경우 종료
        if not w and not h:
            break

        map_list = [list(map(int, input().split())) for item in range(h)]
        print(get_land_cnt(map_list, w, h))
