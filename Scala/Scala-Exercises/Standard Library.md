# 표준 라이브러리 (STANDARD LIBRARY)
원문 : [scala-exercises standard_library](https://www.scala-exercises.org/scala_tutorial/standard_library)
## LIST
함수형 프로그림에서 리스트는 기본적인 데이터 구조입니다.  
`x1, ..., xn` 요소(element)를 가지고 있는 리스트는 `List(x1, ..., xn)` 로 작성되어집니다.
```scala
val fruit = List("apples", "oranges", "pears")
val nums = List(1, 2, 3, 4)
val diag3 = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
val empty = List()
```
* 리스트는 불변입니다 --- 리스트의 요소들은 변경될 수 없습니다.
* 리스트는 재귀적입니다(다음 섹션에서 볼 수 있습니다) 
* 리스트는 동질적(homogeneous) 입니다: 리스트의 요소들은 반드시 같은 타입이어야 합니다.

`요소(element)`들의 타입이 `T`인 리스트는 `List[T]`로 작성되어집니다:
```scala
val fruit: List[String] = List("apples", "oranges", "pears")
val nums: List[Int] = List(1, 2, 3, 4)
val diag3: List[List[Int]] = List(List(1, 0, 0), List(0, 1, 0), List(0, 0, 1))
val empty: List[Nothing] = List()
```

## 리스트의 생성자 
사실 스칼라의 모든 리스트는 이렇게 구성되어집니다:
* `Nil` (빈 리스트)
* `::` 메소드: `x::xs`는 첫번째 요소(`x`)에 새 리스트를 지정하고, 그 뒤에 `xs` 목록(리스트 목록 자체)이 뒤따릅니다.
```scala
val fruit = "apples" :: ("oranges" :: ("pears" :: Nil))
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
val empty = Nil
```
오른쪽과의 연관성  
규칙 : `:` 로 끝나는 작업은 오른쪽과 연결됩니다.  
`A :: B :: C` 는 `A :: (B :: C)`라고 해석됩니다.  
그러나 다음처럼 괄호를 생략할 수 있습니다.
```scala
val nums = 1 :: 2 :: 3 :: 4 :: Nil
```
하지만 `:`로 끝나는 작업은 오른쪽 피연산자의 메소드 호출과는 다릅니다.    
(1이 2 요소를 호출하진 않습니다 라는 뜻)    
사실 위 표현식은 다음과 같습니다.  
```scala
val nums = Nil.::(4).::(3).::(2).::(1)
```
- 추가 1) 왜 이런일이 일어났냐면, 스칼라에서 **이름이 콜론(:)으로 끝나는 메소드는 오른쪽 피연산자의 것으로 호출하기 때문**입니다.       
- 추가 2) `Nil`는 `::` 메소드가 `List` 클래스의 멤버이기 때문입니다.   
만약 `1::2::3` 이라고 하면 마지막 `3`이 Int 형이라서 `::`메소드가 없기 때문에 리스트로 인식이 안됩니다. `1::2::3` 는 `Nil.(3).::(2).::(1)`라는 뜻이기 때문이죠.   
마지막 요소에 `Nil`을 넣어주면 `Nil`은 리스트의 멤버이기 때문에 타입을 추론해 List로 만들어 줍니다. [[출처]](https://hamait.tistory.com/556)

## 리스트 조작
패턴 매칭으로 리스트를 분해(decompose) 할 수 있습니다.  
* `Nil`: `Nil`은 고정값 입니다.  
* `p :: ps` :  리스트의 패턴인 `head` 는 `p`와 `tail`은 `ps` 과 매칭됩니다.  
```scala
nums match {
  // 1 그리고 2로 시작하는 Int 리스트
  case 1 :: 2 :: xs => …
  // 리스트의 길이 1
  case x :: Nil => …
  // `x :: Nil`과 같습니다
  case List(x) => …
  // 빈 리스트는 `Nil` 과 같습니다
  case List() =>
  // 2로 시작하는 또 다른 리스트를 요소로 포함하는 리스트
  case List(2 :: xs) => …
}
```

## 연습 : 리스트 정렬
리스트의 숫자들을 오름차순으로 정렬해야 된다고 가정해봅시다:  
리스트를 정렬하기 위한 방법 중 중 한가지 방법으로 해보겠습니다.  
* `List(7, 3, 9, 2)` 리스트를 정렬하려면 우선 `List(2, 3, 9)`를 얻기위해 tail 인 `List(3, 9, 2)` 를 정렬합니다.  
* 그 다음 head 인 `7`을 올바른 자리에 삽입해 `List(2, 3, 7, 9)`를 얻습니다.  
이 아이디어를 `삽입 정렬(Insertion Sort)` 이라고 합니다.  
```scala
def insertionSort(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case y :: ys => insert(y, insertionSort(ys))
}
```
```scala
val cond: (Int, Int) => Boolean = (x, y) => x < y

def insert(x: Int, xs: List[Int]): List[Int] =
  xs match {
    case List() => x :: Nil

    case y :: ys =>
      if (cond(x, y)) x :: y :: ys
      else y :: insert(x, ys)
  }
insert(2, 1 :: 3 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
insert(1, 2 :: 3 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
insert(3, 1 :: 2 :: Nil) shouldBe (1 :: 2 :: 3 :: Nil)
```

## 리스트에 대한 일반적인 작업(Common Operations)
`map`을 사용해 요소를 바꿉니다.
```scala
List(1, 2, 3).map(x => x + 1) == List(2, 3, 4)
```
`filter`를 사용해 요소를 조건에 맞게 걸러냅니다.
```scala
List(1, 2, 3).filter(x => x % 2 == 0) == List(2)
```
리스트 안의 각 요소들을 변환 후 리스트에 담고, `flatMap`을 사용해 결과를 단일 리스트로 만듭니다. 
```scala
val xs =
  List(1, 2, 3).flatMap { x =>
    List(x, 2 * x, 3 * x)
  }
xs == List(1, 2, 3, 2, 4, 6, 3, 6, 9)
```

## 선택적 값(Option Values)
 `Option[A]`로 `A` 타입의 `선택적 값(Option Values)` 을 표현할 수 있습니다.  
이것은 부분적으로 정의된 함수 구현시 유용합니다.
```scala
// The `sqrt` function is not defined for negative values
def sqrt(x: Double): Option[Double] = …
```
`Option[A]`는 `None`(값이 없음) 혹은 `Some[A]`(값이 있음) 가 될 수 있습니다.
```scala
def sqrt(x: Double): Option[Double] =
  if (x < 0) None else Some(…)
```

## 옵션 조작(Manipulating Options)
패턴 매칭으로 리스트를 분해(decompose) 할 수 있습니다:
```scala
def foo(x: Double): String =
  sqrt(x) match {
    case None => "no result"
    case Some(y) => y.toString
  }
```

## 옵션에 대한 일반적인 작업
`map`을 사용해 요소를 바꿉니다.
```scala
Some(1).map(x => x + 1) shouldBe Some(2)
None.map((x: Int) => x + 1) shouldBe None
```
`filter`를 사용해 요소를 조건에 맞게 걸러냅니다.
```scala
Some(1).filter(x => x % 2 == 0) shouldBe None
Some(2).filter(x => x % 2 == 0) shouldBe Some(2)
```
`flatMap`으로 값을 선택적 값(Option value)으로 변환합니다.
```scala
Some(1).flatMap(x => Some(x + 1)) shouldBe Some(2)
None.flatMap((x: Int) => Some(x + 1)) shouldBe None
```

### 에러 핸들링
이 서브섹션은 오류를 핸들링하는데에 유용한 타입들을 소개합니다.
#### Try
`Try[A]`는 A 를 리턴하려고 시도한 계산을 표현합니다. 이것은 `Success[A]` 과 `Failure` 중 하나 입니다.    
`None`과 `Failure`사이엔 중요한 차이점이 있는데, `Failure`는 실패에 대한 이유를 알려줍니다.
```scala
def sqrt(x: Double): Try[Double] =
  if (x < 0) Failure(new IllegalArgumentException("x must be positive"))
  else Success(…)
```
`Try[A]` 값 조작하기    
Options 와 리스트처럼, `Try[A]`는 대수적인 데이터 타입입니다.     
따라서 패턴 매칭으로 리스트를 분해(decompose) 할 수 있습니다.  
또한 `Try[A]`는 `map, filter, flatMap`을 가지고 있습니다.     
따라서 실행중 발생한 오류는 `Failure`로 변환된다는 점을 제외하면, 마치 `Option[A]` 처럼 동작합니다.  

#### Either
`Either`또한 예외 처리하는데에 유용하며, 기본적으로 타입 `Either[A, B]`는 `A` 혹은 `B` 타입 일 수 있는 값을 나타냅니다.  
이것은 `Left` 혹은 `Right`라는 두가지 경우로 나뉘어집니다.  
한가지 경우는 `Failure`를 나타내고 다른 하나는 `SUCCESS`를 나타낼 수 있습니다.  
한가지 차이점은, `Try`는 `Throwable` 이 아닌 다른 타입을 선택해 예외를 나타낼 수 있습니다.  
또 다른 차이점은  `Either`값을 변환할 때 발생하는 예외는 `failure` 로 변환되지 않는다는 점 입니다. 
```scala
def sqrt(x: Double): Either[String, Double] =
  if (x < 0) Left("x must be positive")
  else Right(…)
```
`Either[A, B]` 값 조작
스칼라 2.12 이후로 `Either` 는 `map`과 `flatMap`을 갖게 되었습니다. 이 메소드들은 `Right` 케이스로만 변환됩니다.   
따라서 `Either`는 "우편향(right biased)" 라고 할 수 있습니다. (`Right` 로만 가기 때문이죠)
```scala
Right(1).map((x: Int) => x + 1) shouldBe Right(2)
Left("foo").map((x: Int) => x + 1) shouldBe Left("foo")
```
또한 `Either` 는 `filterOrElse` 메소드도 갖고 있습니다. 이 메소드는 만약 `Right`값이 `predicate(술어)` 를 만족하지 못하는 경우 `Left`로 만들어줍니다.  
* 여기서 `predicate` 는 `(A) ⇒ B ` 같은 것을 의미합니다.[참고](https://stackoverflow.com/questions/40009857/scala-predicates)
```scala
Right(1).filterOrElse(x => x % 2 == 0, "Odd value") shouldBe Left("Odd value")
```
그러나 스칼라 2.12 이전에는, `Either`는 편향되지 않았습니다(unbiased).     
무슨 뜻이냐면, 스칼라 2.12 이전엔 `map` 사용시 `Side(Right or Left)`를 명시적으로 지정해야 했습니다.
```scala
def triple(x: Int): Int = 3 * x

def tripleEither(x: Either[String, Int]): Either[String, Int] =
  x.right.map(triple)
  
tripleEither(Right(1)) shouldBe Right(3)
tripleEither(Left("not a number")) shouldBe Left("not a number")
```


같이 보면 좋은 포스팅
- [HAMA 블로그 | 스칼라 강좌 (3) - List](https://hamait.tistory.com/556)
- [스칼라 강좌 (21) - Option 과 Either](https://hamait.tistory.com/649)
