def dfs(i, j):
    # 본인 0, visit = T로 바꿈
    visited[i][j] = 'T'
    input_list[i][j] = 0

    for t in range(8):
        # 현재 위치에서 8방향 탐색
        if -1 < i + x[t] < h and -1 < j + y[t] < w:
            # 연결된 곳으로 이동
            if input_list[i + x[t]][j + y[t]] == 1 and visited[i + x[t]][j + y[t]] == 'F':
                dfs(i + x[t], j + y[t])


if __name__ == '__main__':
    x = [0, 0, 1, -1, 1, -1, 1, -1]
    y = [-1, 1, 0, 0, -1, 1, 1, -1]

    while True:
        w, h = map(int, input().split())
        # 0 0일경우 종료
        if not w and not h:
            break

        input_list = [list(map(int, input().split())) for item in range(h)]
        visited = [['F' for col in range(w)] for row in range(h)]

        cnt = 0
        for i, one_line in enumerate(input_list):
            for j in range(len(one_line)):
                # 실제에서 1이면서 탐색한이력이 없어야됨
                if input_list[i][j] != 0 and visited[i][j] == 'F':
                    dfs(i, j)
                    cnt += 1

        print(cnt)
