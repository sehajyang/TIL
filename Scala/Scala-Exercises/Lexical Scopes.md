# 유효범위(Lexical Scopes)
원문 : [scala tutorial lexical scopes](https://www.scala-exercises.org/scala_tutorial/lexical_scopes)
## 중첩 함수
작업을 여러 작은 함수로 분리하는 것은 좋은 함수형 프로그래밍 스타일입니다.  
그러나 `sqrtIter`, `improve`, `isGoodEnough` 같은 함수는 `sqrt` 의 구현만을 위한 것이지 사용되기 위한 것은 아닙니다.  
일반적으로 우리는 사용자가 저런 함수에 직접적으로 접근하는 것을 원하진 않습니다.   
이것을 해결하려면 `sqrt`안에 보조함수를 두어 `이름 공간 오염(name-space pollution)` 을 피할 수 있습니다.      
즉, 이렇게 따로 있던 함수들을 : 
```scala
def sqrtIter(guess: Double, x: Double): Double =
  if (isGoodEnough(guess, x)) guess
  else sqrtIter(improve(guess, x), x)
  
def improve(guess: Double, x: Double) =
  (guess + x / guess) / 2

def isGoodEnough(guess: Double, x: Double) =
  abs(guess * guess - x) < 0.001
  
def sqrt(x: Double) = sqrtIter(1.0, x)
```
이렇게 말이죠:
```scala
def sqrt(x: Double) = {
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x)

  def improve(guess: Double, x: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double, x: Double) =
    abs(square(guess) - x) < 0.001

  sqrtIter(1.0, x)
}
```

## 스칼라의 블록
* 스칼라의 블록은 중괄호로 구분됩니다.
```
{
  val x = f(3)
  x * x
}
```
* 여기에는 일련의 정의 또는 표현식이 포함됩니다.  
* 블록의 마지막 요소는 값을 정의하는 표현식입니다.  
* 리턴 표현식 앞엔 보조정의가 올 수 있습니다.  
* 블록 자체는 표현식이며, 표현이 가능할 때 마다 블록이 나타날 수 있습니다.  

## 블록 및 가시성
* 블록 내부의 정의는 블록내에서만 볼 수 있습니다.  
* 블록 내부의 정의는 블록 외부 정의와 같은 이름인 `그림자 정의(shadow definitions)`입니다.

```scala
val x = 0
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  x * x
} + x
```
이 경우 `result = 16 ` 입니다.

## 유효범위(LEXICAL SCOPING)
블록 외부의 정의가 그림자 정의가 되지 않는 한 블록 내부에서도 볼 수 있습니다.  
따라서 모든 곳에서 동일한 것을 의미하는 `x`파라미터의 중복 발생을 제거함으로써 `sqrt`를 단순화 할 수 있습니다:  
```scala
def sqrt(x: Double) = {
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def improve(guess: Double) =
    (guess + x / guess) / 2

  def isGoodEnough(guess: Double) =
    abs(square(guess) - x) < 0.001

  sqrtIter(1.0)
}
```
## 세미콜론
스칼라에서 대부분의 경우 세미콜론은 옵션입니다.   
이렇게 쓸 수 있습니다:
```scala
val x = 1;
```
그러나 대부분의 사람은 세미콜론을 생략할 것 입니다.    
반면에 만약 한 줄에 둘 이상의 명령문이 있다면 세미콜론으로 구분해야 합니다.  
```scala
val y = x + 1; y * y
```
## 세미콜론과 삽입 연산자(SEMICOLONS AND INFIX OPERATORS)
스칼라 세미콜론 규칙엔 여러행에 걸쳐있는 표현식 작성하는 방법에 대한 문제가 있습니다.     
예를들면 :
```scala
someLongExpression  
  +someOtherExpression 
```
이럴경우 
```scala
someLongExpression;  
  +someOtherExpression  
```
이렇게 해석됩니다.    
이 문제를 해결하는데엔 두 가지 방법이 있습니다.    
세미콜론은 내부에 삽입되지 않으므로 괄호안에 여러 줄 표현식을 쓸 수 있습니다 `(…)`:  
```scala
(someLongExpression  
  + someOtherExpression)  
```
또는 첫번째 행에 연산자를 쓰면 됩니다.   
이렇게 하면 스칼라 컴파일러에게 표현식이 아직 완료되지 않았음을 알릴 수 있기 때문입니다.    
```scala
someLongExpression +  
  someOtherExpression  
```

## 최상위 정의
스칼라 프로그램에서 `def`와 `val`은 최상위 객체 정의(top-level object define )를 해야합니다.  
```scala
object MyExecutableProgram {
  val myVal = …
  def myMethod = …
}
```
위 코드는 `MyExecutableProgram` 라는 객체(object)를 정의합니다.  
또한 점 표기법으로 멤버를 참조할 수 있습니다  .
```scala
MyExecutableProgram.myMethod
```
`MyExecutableProgram` 정의는 다른 정의에 내포되어 있는 정의가 아니기 때문에 최상위(top-level) 정의 입니다.  
 
## PACKAGES AND IMPORTS
최상위 정의 는 패키지로 구성될수 있으며 클래스 혹은 객체를 패키지 안에 넣으려면 `package` 절을 소스 파일 상단에 사용 합니다.  
```scala
// file foo/Bar.scala
package foo
object Bar { … }

// file foo/Baz.scala
package foo
object Baz { … }
```
패키지에 있는 정의는 동일한 패키지에 있는 다른 정의 에서도 볼 수 있습니다.
```scala
// file foo/Baz.scala
package foo
object Baz {
  // Bar is visible because it is in the `foo` package too
  Bar.someMethod
}
```
하지만 다른 패키지에 있는 다른 정의는 못보므로 이를 참조하려면 풀 네임(fully qualified names)을 사용해야 합니다.
```scala
// file quux/Quux.scala
package quux
object Quux {
  foo.Bar.someMethod
}
```
혹은 이렇게도 가능합니다.
```scala
// file quux/Quux.scala
package quux
import foo.Bar
object Quux {
  // Bar refers to the imported `foo.Bar`
  Bar.someMethod
}
```

## Auto Import
스칼라 프로그램에서 몇몇 엔티티는 자동으로 `import` 됩니다.  
* 모든 맴버가 스칼라 패키지인 경우
* 모든 맴버가 `java.lang` 패키지인 경우 
* 모든 맴버가 싱글톤 객체인 `scala.Predef` 인 경우

아래는 지금까지 본 몇가지 유형 및 기능의 풀 네임 입니다.
```scala
Int                            scala.Int
Boolean                        scala.Boolean
Object                         java.lang.Object
String                         java.lang.String
```

## 실행 프로그램 작성하기
지금까지의 코드 예제는 웹 브라우저(scala-exercises 사이트)에서 실행됐지만 스칼라에서 독립 실행형 응용프로그램을 만들 수 있습니다.  
이러한 각 응용프로그램에는 `main`메소드가 있는 객체가 있습니다.  
예를들어 여기 "Hello World!" 가 있습니다.    
스칼라 프로그램:
```scala
object Hello {
  def main(args: Array[String]) = println("hello world!")
}
``` 
이 프로그램을 컴파일 후 다음 명령으로 실행할 수 있습니다.
```scala
$ scala Hello
```
