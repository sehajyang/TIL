# 내장제어구문
※ Programming in Scala를 공부하며 정리한 문서입니다.
## while 루프
```scala
def gcdLoop(x:Long, y:Long) :Long ={
    var a = x
    var b = y
    while(a != 0) {
        val tmp = a
        a = b % a
        b = temp
    }
    b
}
```

## do-while 루프
```scala
var line =""
do {
  line = readLine()
  println(line) 
}while (line != "")
```
루프의 결과 타입은 Unit value 이다.
이 값은 ()Unit 로 표기됨

## for 표현식(for comprehension)
배열 뿐 아니라 컬렉션에서도 동작함:
> for (i <- 1 to 4)

최댓값을 제외하고 싶으면 until 사용
> for (i <- 1 until 4)

이 내용은 23챕터에서 계속

## 필터링
전체 컬렉션을 걸러내 일부만 사용하고 싶을 때 사용
for (file <= fileHere if file.getName.endWith(".scala")) 
  print(file)

## 중첩 이터레이션
여러개의 `<-`를 추가하면 중첩루프를 작성할 수 있다.
```scala
for ( items <- sampleList
      i <- items) print(i)
```

## yield
`yield`를 사용해서 이터레이션의 매 반복 단계를 저장하기 위한 값을 만들 수 있다.
`yield`는 전체 본문의 앞에 위치한다:
```scala
for {절} yield {본문}
```

## 예외
예외는 `Nothing`이란 타입을 갖는다.. 따라서 throw를 표현식처럼 사용할 수 있다.
발생한 예외 catch는 패턴매치로 잡는다.

## match
다른 언어들의 `switch`문과 유사하다.  
자바의 case문엔 enum이나 정수, 문자열 값만 쓸 수 있지만 스칼라는 어떤종류의 상수라도 사용할 수 있다. 
자바 switch와의 가장 큰 차이는 `match`표현식의 결과가 값이라는 것이다.

## break, continue 없이 살기
continue -> if  
break -> boolean 변수로 대체

## 명령형 스타일 코드 리팩토링

