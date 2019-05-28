# Reversing

### nasm 을 사용  
* nasm 이란?  
컴파일 명령어  
```shell
nasm -felf32 hello.asm && ld -I/lib/ld-linux.so.2 -lc --entry main hello.
```
=> object file 생긴다 (exam.o)  

ld => 링크해주는 명령어  
-entry point main이라고 지정  

global main //이 프로그램 실행하면 메인이라는 섹션을 보겠다  
section .text // 지금부터 코드영역이라고 명시  
```
main:
	push 10h
	push 0x1234567
	pop eax
	pop ebx
```
	
