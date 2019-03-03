inp = input()
rst = 1
roomNum = 1
addNum = 6

while True:
    if inp <= roomNum:
        break
    roomNum += addNum
    addNum += 6
    rst += 1

print(rst)
