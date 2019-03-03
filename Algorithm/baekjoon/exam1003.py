# ver1
list01 = [0, 1]

def fibonacci_1(n: int) -> int:
    if n > 1:
        for i in range(2, n+1):
            list01.append(list01[i - 1] + list01[i - 2])
    return list01[-1]


if __name__ == '__main__':
    print(fibonacci_1(1000))

# ver2
dic = {1: 1, 2: 1}

def fibonacci_2(n):
    if n == 0:
        return 0
    if n not in dic:
        dic[n] = fibonacci_2(n - 1) + fibonacci_2(n - 2)
    return dic[n]


print(fibonacci_2(int(input())))