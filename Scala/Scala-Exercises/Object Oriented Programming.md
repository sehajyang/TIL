# Object Oriented Programming
원문 : [[scala-exercises object_oriented_programming]](https://www.scala-exercises.org/scala_tutorial/object_oriented_programming)

# 객체지향 프로그래밍
## 함수와 데이터 
어떻게 함수가 생성되고 데이터 구조를 캡슐화 하는지 살펴보겠습니다.  
우린 산술연산을 위한 패키지를 만들려 합니다.  
분수 `x/y`는 두가지 정수로 표현됩니다:
* 분자 x 그리고 분모 y

## 유리수 덧셈
두 분수의 덧셈을 하고 싶다고 가정해봅시다.
```scala
def addRationalNumerator(n1: Int, d1: Int, n2: Int, d2: Int): Int
def addRationalDenominator(n1: Int, d1: Int, n2: Int, d2: Int): Int
```
이 많은 분자와 분모를 관리하기는 어렵습니다.    
이렇게 하기보단, 데이터구조 안에서 분자와 분모를 결합하는 것이 더 낫습니다.

## 클래스
스칼라에서, 클래스를 이렇게 정의할 수 있습니다:
```scala
class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
}
```
이 정의는 두가지 엔티티를 나타냅니다:
* Rational 이라는 새로운 타입
* 이러한 타입으로 요소를 생성하기 위한 Rational 생성자
스칼라는 서로 다른 네임스페이스에 타입과 생성된 값을 보관합니다. 따라서 Rational에 대한 두 정의끼리 충돌하지 않습니다. 

## 객체
클래스 타입의 요소(element)는 객체라고 불리며 클래스 생성자의 어플리케이션 앞에 new 연산자를 붙여 객체를 생성합니다.
```scala
new Rational(1, 2)
```

## 객체의 멤버
Rational 클래스 의 객체는 numer 과 denom 라는 두 멤버를 갖고 있습니다.  
자바처럼 `.` 연산자를 객체에 붙여 멤버를 호출할 수 있습니다.
```scala
val x = new Rational(1, 2) // x: Rational = Rational@2abe0e27
x.numer // 1
x.denom // 2
```

## 분수 연산
이제 스탠다드 룰에 따른 분수를 연산하는 함수를 정의할 수 있습니다.
```scala
n1 / d1 + n2 / d2 = (n1 * d2 + n2 * d1) / (d1 * d2)
n1 / d1 - n2 / d2 = (n1 * d2 - n2 * d1) / (d1 * d2)
n1 / d1 * n2 / d2 = (n1 * n2) / (d1 * d2)
n1 / d1 / n2 / d2 = (n1 * d2) / (d1 * n2)
n1 / d1 = n2 / d2 iff n1 * d2 = d1 * n2
```

## 분수 연산 구현
```scala
def addRational(r: Rational, s: Rational): Rational =
  new Rational(
    r.numer * s.denom + s.numer * r.denom,
    r.denom * s.denom
  )

def makeString(r: Rational) =
  r.numer + "/" + r.denom
```
그런다음 : 
```scala
makeString(addRational(new Rational(1, 2), new Rational(2, 3)))
```

## 메소드
더 나아가 데이터 추상화 자체에서 데이터 추상화에 따라 작동하는 기능도 패키징할 수 있습니다.  
이러한 함수를 메소드 라고 합니다.  
Rational 클래스는 numer 과 denom 함수 뿐 만 아니라 add, sub, mul, div, equal, toString 함수도 있습니다.  
구현은 다음과 같습니다:
```scala
class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
  def add(r: Rational) =
    new Rational(numer * r.denom + r.numer * denom, denom * r.denom)
  def mul(r: Rational) = ...
  ...
  override def toString = numer + "/" + denom
}
```
수정자 `override` 선언은 `java.lang.Object` 클래스에 있던 `toString` 메소드를 재정의 합니다.  
다음은 new Rational 을 사용하는 방법 입니다:
```scala
val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.add(y).mul(z)
```

## 데이터 추상화
위의 분수 예제는 항상 가장 단순한 형태로 표현된 것이 아닙니다.    
역자 추가) 42/77 은 6/11로 약분될 수 있지만, 위의 분수 예제는 42/77 을 나타내므로 가장 단순한 형태(약분이 다 된 상태) 가 아니란 뜻  
따라서 분수가 약분될 수 있음을 예상할 수 있습니다:
* 최대공약수로 나눠서 가장 작은 분자와 분모로 줄입니다

우린 분수 연산을 할 때 마다 약분을 할 수 있지만 약분해야 한다는 걸 금방 까먹을 것 입니다.  
그러니 다음과 같이 객체가 생성될 때 클래스의 약분함수를 거쳐 객체가 생성되는게 더 낫습니다.
```scala
class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g
  ...
}
```
`gcd와 d`는 private 멤버이므로, Rational 클래스 안에서만 접근할 수 있습니다.  
이 예제에서, gcd 함수를 즉시 계산하며, 그 값을 numer과 denom의 계산에서 재사용할 수 있습니다.  
또한 numer과 denom 코드안에서 gcd 호출이 가능합니다(Rational 클래스 안이기 때문에):
```scala
class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  def numer = x / gcd(x, y)
  def denom = y / gcd(x, y)
}
```
위 코드는 numer과 denom 함수가 가끔 호출되는 경우에 유리합니다.  
numer과 denom의 def를 val로 변환하는 것 과도 같습니다. 그리고 val 는 단 한번만 계산됩니다:
```scala
class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)
}
```
이는 numer과 denom이 종종 호출될 때 유리합니다.

### 클라이언트 뷰
클라이언트는 각각의 케이스에서 정확히 같은 경향을 보입니다.  
클라이언트에 영향을 주지 않고 데이터의 다른 구현을 선택할 수 있는 이러한 기능을 데이터 추상화라고 합니다.   
이것은 소프트 엔지니어링의 초석입니다.

## 자기 참조
클래스 내부의 `this`는 현재 메소드가 실행되는 객체를 나타냅니다.  
Rational 클래스에 less 와 max 함수를 추가해봅시다: 
```scala
class Rational(x: Int, y: Int) {
  ...
  def less(that: Rational) =
  numer * that.denom < that.numer * denom

  def max(that: Rational) =
    if (this.less(that)) that else this
}
```
클래스의 다른 멤버를 참조하는 `x`는, `this.x`이 생략된 표현됩니다. this를 생략하지 않은 less 구현은 다음과 같습니다:
```scala
def less(that: Rational) =
  this.numer * that.denom < that.numer * this.denom
```

## 전제 조건(Preconditions)
Rational 클래스의 분모는 양의  정수여야 한다고 가정해봅시다.  
`require` 라는 함수로 이를 구현할 수 있습니다.
```scala
class Rational(x: Int, y: Int) {
  require(y > 0, "denominator must be positive")
  ...
}
```
`require`는 미리 정의된 함수입니다. 이 함수는 조건과 메세지 문자열(옵션)이 필요합니다.    
만약 require의 조건 결과가 false 라면 메세지 문자열과 함께 `IllegalArgumentException` 오류를 던집니다.

## ASSERTIONS
require 말고, `assert`도 있습니다.  
`assert`또한 조건과 메세지 문자열(옵션)이 필요합니다.
```scala
val x = sqrt(y)
assert(x >= 0)
```
require 처럼 assert의 조건이 실패시 예외를 던집니다, 그러나 assert의 `AssertionError`과 require의 `IllegalArgumentException`는 한가지 차이가 있습니다.  
이것은 의도의 차이를 나타냅니다.
* `require`는 함수 호출시 사전 조건을 적용하는데에 사용됩니다.
* `assert`는 함수의 자체의 코드를 검사하기 위해 사용됩니다.

## 생성자
스칼라에서, 클래스는 암시적으로 생성자를 선언합니다. 이것을 `주 생성자(primary constructor)`라고 합니다.  
주 생성자는 :
* 클래스의 파라미터를 가져옵니다.
* 그리고, 클래스 바디안의 모든 명령문을 실행합니다(require 같은 것들)

### 보조 생성자
또한 스칼라는 보조생성자의 선언을 허용하며 이름은 `this`라고 합니다.  
Rational 클래스에 보조 생성자를 추가해봅시다:
```scala
class Rational(x: Int, y: Int) {
  def this(x: Int) = this(x, 1)
  ...
}
```

## 클래스와 치환(Subtitution)
이전엔 치환에 기반한 계산 모델을 사용해 함수 어플리케이션의 의미를 정의했습니다. 이제 이 모델을 클래스와 객체로 확장합니다.
`new C(e1, …, en)`(C: 클래스, e: 인스턴스)는 어떻게 값이 구해질까요?
표현식 인수(argument) `e1, …, en`는 일반 함수의 인수와 같이 간주됩니다.
결과 표현식 `new C(v1, …, vn)`은 이미 값입니다.
이제 클래스 정의가 있다고 가정해봅시다:
```scala
class C(x1, …, xn) {
  …
  def f(y1, …, ym) = b
  …
}
```
* `x1, …, xn`는 클래스의 형식적인 파라미터입니다.
* 이 클래스는 `y1, …, ym`파라미터가 있는 f 메소드를 정의합니다

(함수 파라미터 리스트가 없을 수 있습니다. 심플함을 위해, 파라미터 타입을 생략했습니다)
다음의 표현식은 어떻게 될까요?
```scala
new C(v1, …, vn).f(w1, …, wm)
```
다음과 같은 세가지의 치환이 발생합니다.

* 인수 `w1, ..., wm`에 대한 함수 f의 매개변수 `y1, ..., ym` 치환.
* 클래스 인수 `v1, ..., vn`에 의한 클래스 C의 매개변수 `x1, ..., xn` 치환
* 자체 참조 `this`를 `new C(v1, ..., vn)` 객체의 값으로 치환.

## 연산자
원칙적으로, Rational이 정의한 분수는 정수와 같습니다(분수는 정수라는 뜻).
하지만 눈에 띄는 차이점이 있습니다:
* x 과 y가 정수인 `x+y`를 작성했지만, 
* `r.add(s)`의 경우 r과 s 는 분수입니다.
* 역자추가) x와 y는 정수라서 +가 되는데 r과 s는 분수라 +가 없어서 add 메소드를 씀니다.    
근데 원칙적으로 분수는 정수인데 뭐지? 라는 차이점이 있다는 뜻 입니다. 

스칼라에선, 연산자를 식별자로 사용할 수 있으므로 이 차이를 없앨 수 있습니다.  
식별자는 다음과 같습니다:
* Alphanumeric : 문자로 시작하고 문자 또는 숫자 시퀀스
* 심볼릭 : 연산자 기호로 시작하고, 그 뒤에 다른 연산자 기호가 옵니다.
* 밑줄 문자 `_`는 문자로 계산됩니다.
* Alphanumeric 식별자는 밑줄로 끝나며 일부 연산자 기호가 이어질 수 있습니다.

식별자 예제:
```scala
x1 * +?%& vector_++ counter_=
```

### 분수를 위한 연산자
여기 Rational 클래스에 대한 보다 자연스러운 정의가 있습니다:
```scala
class Rational(x: Int, y: Int) {
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g
  def + (r: Rational) =
    new Rational(
      numer * r.denom + r.numer * denom,
      denom * r.denom
    )
  def - (r: Rational) = ...
  def * (r: Rational) = ...
  ...
}
```
이제 분수는 Int 나 Double 처럼 사용될 수 있습니다.
```scala
val x = new Rational(1, 2)
val y = new Rational(1, 3)
x * x + y * y
```

## 우선순위 규칙
연산자 우선순위는 첫 문자에 의해 결정됩니다.
다음은 우선순위가 높은 순서대로 문자를 나열한 것 입니다:
```scala
(all letters)
|
^
&
< >
= !
:
+ -
* / %
(all other special characters)
```

## 추상 클래스
IntSet 클래스의 작성에 대해 생각해봅시다.
```scala
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
}
```
`IntSet`은 추상 클래스입니다.  
추상 클래스는 구현이 되지 않은 멤버를 포함할 수 있습니다(이 경우엔, `incl`과 `contains` 이며 추상메소드 라고 합니다).  
그렇기 때문에, 추상클래스는 new 연산자로 새로운 객체를 생성할 수 없습니다.

## 클래스 확장
set 을 이진트리로 구현하는 것에 대해서 생각해봅시다.
가능한 트리에는 두가지 타입이 있습니다.
1. 빈 세트에 대한 트리
2. 정수와 두개의 하위트리로 구성된 트리
 
구현은 다음과 같습니다:
```scala
class Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {

  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
}
```
`Empty`와 `NonEmpty`는 `IntSet` 클래스를 상속 받았습니다.  
이 상속은 Empty와 NonEmpty의 타입이 `IntSet`의 타입을 따르게 합니다.  
Empty 혹은 NonEmpty는 IntSet 타입의 객체가 필요한 곳이라면 어디서나 사용할 수 있습니다.

IntSet은 Empty와 NonEmpty의 '슈퍼클래스' 라고 불립니다.
Empty 및 NonEmpty는 IntSet의 하위 클래스입니다.
스칼라에서는 사용자 정의 클래스가 다른 클래스를 상속받습니다.
슈퍼 클래스가 주어지지 않는 경우, Java 패키지 java.lang의 표준 클래스 객체로 가정합니다.
C 클래스의 직접 또는 간접 슈퍼클래스를 C 의 기본 클래스라고 합니다.
그래서, NonEmpty의 기본 클래스는 `IntSet`과 `Object` 입니다.

## 상속(implementation)과 오버라이딩
Empty 와 NonEmpty 클래스의 `contains 과 incl`의 정의는 IntSet 의 추상 함수를 구현합니다.
또한 오버라이드를 사용하여 하위 클래스에서 기존 비추상 정의를 재정의할 수 있습니다.
```scala
abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends Base {
  override def foo = 2
  def bar = 3
}
```

## 객체 정의
IntSet 예제에서, 실제론 하나의 빈 IntSet만 존재한다고 할 수도 있습니다.  
그렇기 때문에 사용자가 많은 인스턴스를 만들도록 하는 것은 지나친 것 같습니다.  
우린 객체 정의로 이 경우를 개선할 수 있습니다: 
```scala
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
}
```
위 코드는 Empty라는 싱클톤 객체를 정의합니다.  
다른 어떤 Empty 객체도 생성될 수 없습니다.      
싱글톤 객체는 값이기 때문에 Empty는 스스로 계산됩니다.

## 동적 바인딩
스칼라를 포함한 OOP 언어에선 `동적 메소드 디스패치`를 구현합니다.
이것은 메소드 호출에 의해 호출된 코드는 메소드를 포함하는 객체의 런타임 유형에 따라 다르다는 것을 의미합니다.[추가](https://riptutorial.com/ko/java/topic/9204/%EB%8B%A4%EC%9D%B4%EB%82%B4%EB%AF%B9-%EB%A9%94%EC%86%8C%EB%93%9C-%EB%94%94%EC%8A%A4%ED%8C%A8%EC%B9%98)  
```scala
Empty contains 1 shouldBe false
new NonEmpty(7, Empty, Empty) contains 7 shouldBe true
```
메소드의 동적 디스패치는 고차함수의 호출과 비슷합니다.
이 개념을 다른 개념으로 구현할 수 있습니까?
* 고차함수의 측면에서 객체?
* 객체 측면에서 고차함수?

## 트레잇
스칼라에서, 클래스는 단 하나의 슈퍼클래스를 가질 수 있습니다.
그러나 한 클래스가 몇 가지 슈퍼타입을 가지고 있거나 그로부터 코드를 상속받고자 하면 어떨까요?
이때, 당신은 `트레잇(trait)`를 사용할 수 있습니다.
트레잇은 추상클래스처럼 선언되며, `trait` 으로 선언합니다.
```scala
trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}
```
클래스, 객체, 트레잇은 최대 하나의 클래스에서 상속 할 수 있지만 임의의 많은 트레잇이 있습니다:
```scala
class Square extends Shape with Planar with Movable …
```
반면에, 트레잇은 값 파라미터를 가지지 않으며 클래스만 가질 수 있습니다.

## 스칼라의 클래스 계층
![scala_type_hierarchy](/images/blogpost/scala_type_hierarchy.png)

### Top Type
타입 계층 구조의 맨 위에는 다음이 있습니다.
* Any
    * 모든 타입의 기본 타입
    * 메소드: ==, !=, equals, hashCode, toString
* AnyRef
    * 모든 참조 타입의 기본 타입
    * 별칭 java.lang.Object
* AnyVal
    * 모든 원시 타입의 기본 타입

### Bottom Type
`Nothing`은 스칼라의 타입 계층의 최하위에 있습니다. 그것은 다른 모든 타입의 하위 유형입니다.  
`Nothing`타입의 값은 없습니다.  
이걸 어디에 사용하나요?  
* 비정상 종료 신호
* 빈 콜렉션 의 요소(element) 타입

### Null Type
모든 참조 클래스 타입은 또한 `null`을 값으로 갖고 있습니다.  
`null` 타입은 `Null` 입니다.    
`Null`은 `Object`에서 상속하는 모든 클래스의 하위 타입이며, `AnyVal`의 하위 타입과 호환되지 않습니다.
```scala
val x = null // x: Null
val y: String = null // y: String
val z: Int = null    // error: type mismatch
```

