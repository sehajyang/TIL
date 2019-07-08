# 고차함수(Higher Order Functions)
원문 : [scala_tutorial higher_order_functions](https://www.scala-exercises.org/scala_tutorial/higher_order_functions)

함수형 언어는 함수를 `일급 객체(first-class) 값` 으로 다룹니다.
이것은 즉 값처럼 함수를 매개변수로 전달하고 결과를 반환합니다. 또한 프로그램을 유연하게 조립하는 방법입니다.  
이렇게 마치 값 처럼 함수를 입력받거나 함수를 리턴하는 함수를 `고차함수`라고 부릅니다.

## MOTIVATION
 a와 b사이의 `정수(integer)`들의 합을 합니다.
```scala
def sumInts(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts(a + 1, b)
```
 a 와 b 사이의 `정수(integer)`들인 `cube` 들의 합을 합니다.
```scala
def cube(x: Int): Int = x * x * x

def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)
```
 a 와 b 사이의 `정수(integer)`들인 `factorial` 들의 합을 합니다.
```scala
def sumFactorials(a: Int, b: Int): Int =
  if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)
```
이 메소드들은 비슷합니다. 공통패턴들을 제외할 수 있을까요?

## 고차함수로 더하기(SUMMING WITH HIGHER-ORDER FUNCTIONS)
정의해봅시다:
```scala
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0
  else f(a) + sum(f, a + 1, b)
```
그리고 이렇게 작성할 수 있습니다:
```scala
def id(x: Int): Int = x
def sumInts(a: Int, b: Int) = sum(id, a, b)
def sumCubes(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)
```

## 함수 타입(FUNCTION TYPES)
`A => B`의 타입은 함수 입니다. 함수 형태인 `A` `argument` 를 입력한 결과를 B 라는 결과로 리턴합니다.  
그러므로, `Int => Int`는 int를 int로 맵핑하는 함수 입니다.

## 익명함수(ANONYMOUS FUNCTIONS)
함수를 매개변수로 전달하면 많은 작은 함수가 생깁니다.  
때로는 `def` 를 사용해 이런 함수(및 함수의 이름)를 정의해야 되는 일들은 지루합니다.  
`string` 과 비교하자면 : 우리는 `val`을 사용해 `string`을 정의할 필요가 없습니다.(그것은 지루한 작업이기 때문이죠)   
```scala
val str = "abc"; println(str)
```
대신에 우리는 바로 아래와 같이 이렇게 작성할 수 있습니다.
```scala
println("abc")
```
왜냐하면, `string` 은 `리터럴(literals)`로 존재하기 때문입니다. 이와 비슷하게 우리는 함수 `리터럴`을 원하므로, 함수 `리터럴`에 이름을 주지않고 함수를 작성하게 됩니다.  
이를 `익명 함수(anonymous functions)` 라고 합니다.

## 익명함수의 문법
`argument` 를 `cube` 로 전달하는 함수는 다음과 같습니다.  
```scala
(x: Int) => x * x * x
```
`(x: Int)`는 `함수의 매개변수(parameter)` 이며 `x * x * x`는 함수의 body 입니다.  
파라미터의 타입은 만약 컴파일러가 컨텍스트에서 유추할 수 있는 경우 생략할 수 있습니다.  
파라미터가 여러개인 경우 쉼표로 구분됩니다.
```scala
(x: Int, y: Int) => x + y
```
## 익명함수는 문법적 설탕(사람이 읽기 쉽게 표현) 입니다(Anonymous Functions are Syntactic Sugar)
익명함수 `(x1: T1, …, xn: Tn) => e`는 항상 `def` 를 사용해 다음과 같이 표현할 수 있습니다.  
```scala
{ def f(x1: T1, …, xn: Tn) = e ; f }
```
여기서 `f` 는 프로그램에서 아직 사용되지않은 임의의 새로운 이름입니다 따라서 익명함수로 표현될 수 있습니다.  
그러므로 익명함수는 문법적 설탕 이라고 할 수 있습니다.

## 익명함수로 더하기(Summation with Anonymous Functions)
익명함수를 사용하면, 더하는 함수를 좀더 짧게 작성할 수 있습니다.  
```scala
def sumInts(a: Int, b: Int) = sum(x => x, a, b)
def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
```

같이 보면 좋은 포스팅 : [일급 함수](https://hjaem.info/articles/kr_4_1)
