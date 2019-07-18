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
만약 복잡한 식(식별자 이상의)을 연결하려면 중괄호로 둘러쌉니다.
```scala
def greet(name: String): String =
  s"Hello, ${name.toUpperCase}!"

greet("Scala") shouldBe "Hello, SCALA!"
```

## 튜플
우리는 이전 섹션들을 통해 케이스 클래스가 정보를 모으는데에 유용하다는 것을 알게되었습니다.  
그러나 때로는 완전한 케이스 클래스를 정의할 필요 없이 정보를 모을 수 있습니다. 튜플로 말이죠
```scala
def pair(i: Int, s: String): (Int, String) = (i, s)

pair(42, "foo") shouldBe (42, "foo")
pair(0, "bar") shouldBe (0, "bar")
```