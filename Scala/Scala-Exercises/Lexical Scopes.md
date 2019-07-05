# Lexical Scopes
url : [scala-exercises](https://www.scala-exercises.org/scala_tutorial/lexical_scopes)
## 스칼라의 블록
* 스칼라의 블록은 중괄호로 구분됩니다.
```
{
  val x = f(3)
  x * x
}
```
* 블록의 마지막 요소는 값을 정의하는 표현식입니다.
* 리턴 표현식 앞엔 보조정의가 올 수 있습니다.
* 블록 내부의 정의는 블록내에서만 볼 수 있습니다.

```scala
val x = 0
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  x * x
} + x
```
이 경우 `result = 16 ` 입니다.

## 세미콜론
한 줄에 둘 이상의 명령문이 있으면 세미콜론으로 구분해야 합니다.
그러나 여러행에 걸쳐있는 표현식은
```scala
someLongExpression  
  +someOtherExpression  
  이럴경우  
someLongExpression;  
  +someOtherExpression  
  이렇게 해석됩니다.
```

따라서 만약 한줄에 둘 이상의 정의를 해야하면 
```scala
(someLongExpression  
  + someOtherExpression)  
  혹은  
someLongExpression +  
  someOtherExpression  
  이렇게 할 수 있습니다.  
```

## 최상위 정의
`def`와 `val`은 top-level object define 해야 합니다.
```scala
object MyExecutableProgram {
  val myVal = …
  def myMethod = …
}
```
또한 점 표기법으로 멤버를 호출할 수 있습니다.
```scala
MyExecutableProgram.myMethod
```

## Package
top-level 정의 은 패키지로 구성될수 있으며 클래스 혹은 객체를 패키지 않에 넣으려면 `package` 절을 사용 합니다.
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
* 모든 맴버가 싱글톤 객체인 scala.Predef 인 경우

지금까지 본 몇가지 유형 및 기능의 풀 네임 
```scala
Int                            scala.Int
Boolean                        scala.Boolean
Object                         java.lang.Object
String                         java.lang.String
```

