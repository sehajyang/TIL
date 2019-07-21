# Object Oriented Programming

## 함수와 데이터
함수가 어떻게 데이터 구조를 생성하며 캡슐화하는지 보겠습니다.

효율적인 산술연산을 위한 패키지를 설계하려고 합니다.
유리수 `x / y`는 두개의 정수로 표현됩니다:

## 유리수 더하기
두 유리수를 더한다고 가정해봅시다.
```scala
def addRationalNumerator(n1: Int, d1: Int, n2: Int, d2: Int): Int
def addRationalDenominator(n1: Int, d1: Int, n2: Int, d2: Int): Int
```
이러한 모든 분자 및 분모를 관리하는 것은 어렵습니다.
대신 데이터 구조에서 유리수의 분자와 분모를 결합하는, 더 나은 선택을 할 수 있습니다.

## 클래스
스칼라에서, 클래스는 이렇게 정의합니다:
```scala
class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y
}
```
이 정의는 두가지 엔티티를 소개합니다:
* `Rational` 이라는 새로운 타입
* 이러한 타입(x: Int, y: Int)으로 요소를 생성하기 위한 생성자 `Rational` 생성자
스칼라는 타입의 이름과 값을 다른 네임스페이스에 갖고 있습니다. 따라서 `Rational`의 두 정의 사이에 충돌이 나지는 않을 것 입니다.

## 객체(오브젝트)
클래스의 요소(element)의 타입은 객체(object)라고 합니다.



