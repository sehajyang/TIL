# 편리한 문법들(SYNTACTIC CONVENIENCES)
원문 : [scala_tutorial syntactic_conveniences](https://www.scala-exercises.org/scala_tutorial/syntactic_conveniences)

이 섹션에선 언어가 지원하는 몇가지 문법적 설탕에 대해 소개합니다.
## 문자열 보간(INTERPOLATION)
런타임에서 String 에 값을 붙일 시 문자열 보간을 사용할 수 있습니다:
```scala
def greet(name: String): String =
  s"Hello, $name!"

greet("Scala") shouldBe "Hello, Scala!"
greet("Functional Programming") shouldBe "Hello, Functional Programming!" 
```
문자열 리터럴 접미사로 `s`를 붙이면 `$`으로 동적값을 그 안에서 사용할 수 있습니다.  
만약 복잡한 식을 연결할시엔 중괄호로 둘러쌉니다.
```scala
def greet(name: String): String =
  s"Hello, ${name.toUpperCase}!"

greet("Scala") shouldBe "Hello, SCALA!"
```

## 튜플
우리는 이전 섹션들을 통해 케이스 클래스는 정보를 모으는데에 유용하다는 것을 알게되었습니다.  
그러나 때로는 완전한 케이스 클래스를 정의할 필요 없이 정보를 모을 수 있습니다. 튜플로 말이죠
```scala
def pair(i: Int, s: String): (Int, String) = (i, s)

pair(42, "foo") shouldBe (42, "foo")
pair(0, "bar") shouldBe (0, "bar")
```
위 예제에서의 타입은 (Int, String)로 첫번째 요소(element)의 타입은 Int 두번째 요소는 String 입니다.  
비슷하게, `(i, s)` 쌍의 첫번째 요소는 i, 두번째 요소는 s 입니다.    
일반적으로, `(T1, …, Tn)`의 타입은 i번째 요소는 Ti 타입을 가진, n개의 요소가 있는 튜플입니다.    
그리고 값은 n개 요소 `(t1, …, tn)`의 튜플 값 입니다.  
* (역자추가) 튜플의 각 요소들은 타입이 각자 다를 수 있습니다. `("a",1,'b')` 튜플의 타입은 `Tuple[String,Int,Char]` 입니다.  
즉, 튜플의 타입은 요소의 개수와 각각의 타입에 따라 달라집니다. [[출처]](https://hamait.tistory.com/557)

### 튜플 조작하기 
튜플 패턴을 사용해 튜플의 요소를 검색할 수 있습니다.
```scala
val is: (Int, String) = (42, "foo")

is match {
  case (i, s) =>
    i shouldBe 42
    s shouldBe "foo"
}
```
또는 심플하게 다음과 같이 작성할 수 있습니다:
```scala
val is: (Int, String) = (42, "foo")

val (i, s) = is
i shouldBe 42
s shouldBe "foo"
```
또는 `_1`멤버로 첫번째 요소를, `_2`멤버로 두번째 요소를 검색할 수 있습니다:
```scala
val is: (Int, String) = (42, "foo")
is._1 shouldBe 42
is._2 shouldBe "foo"
```

## 객체로서의 함수
우리는 스칼라의 넘버릭 타입들과 `Boolean` 타입이 일반 클래스처럼 상속될 수 있음을 보았습니다.  
그러나 함수는 어떨까요?   
실제로 스칼라에서 함수의 값은 객체로 다뤄집니다.  
타입이 `A = B` 인 함수는 사실 `scala.Function1[A, B]` 가 생략된 것 이며 다음과 같이 정의됩니다:  
```scala
package scala
trait Function1[A, B] {
  def apply(x: A): B
}
```
그래서, 함수는 `apply` 메소드를 가지고있는 객체입니다.  
또한 Function2, Function3... , 등 더 많은 매개변수를 취하는 함수(튜플..최대 22개)가 있습니다.

### 함수값의 확장
아래의 익명함수는:
```scala
(x: Int) => x * x
```
다음과 같이 확장됩니다.
```scala
{
  class AnonFun extends Function1[Int, Int] {
    def apply(x: Int) = x * x
  }
  new AnonFun
}
```
또는 익명 클래스 문법을 사용해 짧아집니다.
```scala
new Function1[Int, Int] {
  def apply(x: Int) = x * x
}
```

### 함수호출의 확장
`f(a, b)` (`f`는 일부 클래스 타입의 값) 함수의 호출은 다음과 같이 확장됩니다.
```scala
f.apply(a, b)
```
그래서 객체지향(OO)으로 변환하면
```scala
val f = (x: Int) => x * x
f(7)
```
아래와 같을 것 입니다:
```scala
val f = new Function1[Int, Int] {
  def apply(x: Int) = x * x
}
f.apply(7)
```
### 함수와 메소드
다음과 같은 메소드 자체는 함수 값이 아닙니다.
```scala
def f(x: Int): Boolean = …
```
그러나 만약 함수 유형이 예상되는 곳에 `f` 가 사용되면, 자동으로 함수값으로 변환됩니다. 
```scala
(x: Int) => f(x)
```

## FOR 표현
표준 라이브러리의 여러 데이터 타입은 `map, flatMap, filter`라는 메소드를 갖고있음을 알 수 있습니다.  
이 메소드들이 실제로 사용되는 경우가 많기 때문에 스칼라는 표현식에 대한 전용 문법을 지원합니다:  
   
`map` 대신:
```scala
xs.map(x => x + 1)
```
다음과 같이 작성할 수 있습니다:
```scala
for (x <- xs) yield x + 1
```

그리고 "`xs`의 모든 요소 `x`에 `x+1` 하고 리턴합니다"라고 읽습니다.
* (역자추가) `xs`의 요소들에 대해 `x` 라고 명명하며 `xs`를 순회하며 `x+1` 을 하고, 그 결과를 새로운 리스트로 리턴합니다.

`filter` 대신:
```scala
xs.filter(x => x % 2 == 0)
```
다음과 같이 작성할 수 있습니다:
```scala
for (x <- xs if x % 2 == 0) yield x
```
이 문법의 이점은 이전 문법과 같이 보면 더욱 분명해집니다(가독성이 향상되었습니다):
```scala
for (x <- xs if x % 2 == 0) yield x + 1

// Equivalent to the following:
xs.filter(x => x % 2 == 0).map(x => x + 1)
```

마지막으로 `flatMap` 대신:
```scala
xs.flatMap(x => ys.map(y => (x, y)))
```
다음과 같이 작성할 수 있습니다:
```scala
for (x <- xs; y <- ys) yield (x, y)
```
그리고 "`xs`의 모든 요소 `x` 와 `ys`의 모든 요소`y`를 `(x,y)`하고 (그 결과를 새로운 리스트로) 리턴합니다" 라고 읽습니다.

### 한꺼번에 값 넣기
다음은 한꺼번에 값을 넣는 예제입니다:
```scala
for {
  x <- xs if x % 2 == 0
  y <- ys
} yield (x, y)
```
문법적 설탕을 해제한 코드는 이렇습니다: 
```scala
xs.filter { x =>
  x % 2 == 0
}.flatMap { x =>
  ys.map { y =>
    (x, y)
  }
}
```

## 메소드의 파라미터
### 명명된 파라미터
때때로 함수에 전달된 몇몇 파라미터의 의미가 무엇인지 파악하기 어려울 수 있습니다. 
다음 예제를보며 생각해봅시다:
```scala
Range(1, 10, 2)
```
이것은 무슨 뜻 일까요? `명명된 파라미터(named parameter)`를 사용해 읽기 쉽게 만들 수 있습니다.  
사실 위의 코드에서 `Range` 는 다음과 같이 정의되어 있습니다:
```scala
case class Range(start: Int, end: Int, step: Int)
```
그리고 다음과 재작성 할 수 있습니다:
```scala
Range(start = 1, end = 10, step = 2)
```
이제 위 코드는 `1 부터 10까지 2씩 증가시킨다` 는 정의를 했음이 명확해졌습니다.

### 기본 값
메소드의 파라미터는 기본값을 가질 수 있습니다.  
`Range`를 재정의 해 봅시다:
```scala
case class Range(start: Int, end: Int, step: Int = 1)
```
위 코드에서, `step` 파라미터는 기본값으로 1을 가집니다.  
그 뒤, `step` 파라미터를 생략할 수 있으며, 생략할 시 컴파일러는 해당 파라미터의 기본값으로 지정한 값을 사용하게 됩니다.
```scala
case class Range(start: Int, end: Int, step: Int = 1)

val xs = Range(start = 1, end = 10)

xs.step shouldBe 1
```

### 반복된 파라미터
다음과 같이 임의의 수의 파라미터(동일한 타입의)를 받을 수 있는 함수를 정의할 수 있습니다:
```scala
def average(x: Int, xs: Int*): Double =
  (x :: xs.to[List]).sum.toDouble / (xs.size + 1)

average(1) shouldBe 1.0
average(1, 2) shouldBe 1.5
average(1, 2, 3) shouldBe 2
```
`average` 함수는 최소한 하나의 `Int` 파라미터와 임의의 수의 파라미터의 값들을 가져와 평균을 계산합니다.  
또한, 사용자가 적어도 하나의 파라미터를 제공하도록 함으로써 빈 숫자 리스트의 평균을 계산할 수 없도록 만듭니다.  
때로는 리스트의 각 요소를 많은 파라미터로 제공하려면, `: _*`를 추가합니다:
 ```scala
 val xs: List[Int] = …
 average(1, xs: _*)
 ```
 
 ## 타입 엘리어스(TYPE ALIASES)
 비슷하게, `타입 표현식(type expressions)` 으로 표현식에 의미있는 이름을 줄 수 있습니다. 
 ```scala
 type Result = Either[String, (Int, Int)]
 def divide(dividend: Int, divisor: Int): Result =
   if (divisor == 0) Left("Division by zero")
   else Right((dividend / divisor, dividend % divisor))
 divide(6, 4) shouldBe Right((1, 2))
 divide(2, 0) shouldBe Left("Division by zero")
 divide(8, 4) shouldBe Right((2,0))
 ```