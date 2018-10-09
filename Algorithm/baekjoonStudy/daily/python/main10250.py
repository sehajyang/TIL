# 백준 10250 ACM호텔
# https://zetawiki.com/wiki/BOJ_10250_ACM_%ED%98%B8%ED%85%94

instr = int(input())
for t in range(instr):
    h, w, n = map(int,input().split())
    print( (n-1)%h*100 + (n-1)//h + 101 )
