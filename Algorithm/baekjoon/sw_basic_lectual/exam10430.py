input_list = input().split(' ')
a, b, c = int(input_list[0]), int(input_list[1]), int(input_list[2])

print((a + b) % c)
print((a % c + b % c) % c)
print((a * b) % c)
print((a % c * b % c) % c)


"""
컴퓨터의 정수는 저장범위에 한계가있어 M으로 나누라는 문제가 많이 나옴
(A + B) mod M = ((A mod M) + (B mod M)) mod M, 곱하기도 성립함
그러나 나누기의 경우엔 성립하지 않음
뺄셈의 경우엔 먼저 mod 한 결과가 음수가 될 수 있으므로
(A-B) mod M = ((A mod M) - (B mod M) + M) mod M 해야됨
"""