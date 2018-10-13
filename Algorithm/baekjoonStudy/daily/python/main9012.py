import sys
n = int(sys.stdin.readline())
k = 0

for i in range(n):
    arr = list((sys.stdin.readline()))

for i in range(len(arr)):
    if arr[i]=='(':
        k+=1
    elif arr[i]==')':
        k-=1
    if k < 0:
        print("NO")
if k == 0:
    print("YES")
else:
    print("NO")
