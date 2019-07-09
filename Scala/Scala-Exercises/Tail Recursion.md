# 꼬리 재귀(Tail Recurstion)
원문 : [scala-exercises tail_recursion](https://www.scala-exercises.org/scala_tutorial/tail_recursion)
## 재귀 함수 응용프로그램
두개의 재귀 메소드의 실행과정(evaluation step) 을 비교해 보겠습니다.
먼저 두 수의 최대공약수를 계산하는 gcd 메소드를 생각해봅시다.
다음의 `gcd` 는 유클리드 알고리즘을 사용해 구현되었습니다.
```scala
def gcd(a: Int, b: Int): Int =
  if (b == 0) a else gcd(b, a % b)
```
`gcd(14, 21)` 는 다음의 실행과정을 거칩니다.
```scala
gcd(14, 21)
if (21 == 0) 14 else gcd(21, 14 % 21)
if (false) 14 else gcd(21, 14 % 21)
gcd(21, 14 % 21)
gcd(21, 14)
if (14 == 0) 21 else gcd(14, 21 % 14)
if (false) 21 else gcd(14, 21 % 14)
gcd(14, 7)
gcd(7, 14 % 7)
gcd(7, 0)
if (0 == 0) 7 else gcd(0, 7 % 0)
if (true) 7 else gcd(0, 7 % 0)
7
```
`factorial` 을 생각해봅시다:
```scala
def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)
```
`factorial(4)`는 다음의 실행과정을 거칩니다.
```scala
factorial(4)
if (4 == 0) 1 else 4 * factorial(4 - 1)
4 * factorial(3)
4 * (3 * factorial(2))
4 * (3 * (2 * factorial(1)))
4 * (3 * (2 * (1 * factorial(0)))
4 * (3 * (2 * (1 * 1)))
24
```
이 두 시퀀스는 뭐가 다른걸까요?
가장 중요한 차이점은 `gcd` 경우 시퀀스가 본질적으로 감소하며 변합니다.
(`gcd(21, 14 % 21)` 가 `gcd(14, 7)` 처럼 점점 줄어든다는 뜻)
이것은 `gcd`의 하나의 호출에서 다음 호출로 넘어가며 마침내 종료됩니다. 
그 사이엔 `if then elses` 같은 표현식이 있습니다. 어쨌든 항상 우리가 최초 호출한 모양인 `gcd(a,b)` 로 돌아옵니다.

반면에 `factorial` 에선, 하나의 요소를 매 단계마다 추가한다는 것을 알 수 있습니다. 
(`4 * factorial(3)` 에서 `4 * (3 * factorial(2))`으로 `3 * ` 요소가 추가 된 것 처럼요)
최종 값으로 줄어들 때 까지 표현식은 점점 커집니다.

## 꼬리 재귀(Tail Recursion)
재작성(rewriting)규칙의 차이는 실제로 컴퓨터의 실제 실행의 차이로 직접 바뀝니다.(데이터를 다시 만들거나 하지 않고 rewriting 합니다)
사실, 마지막 동작으로 자신을 호출하는 재귀함수가 있는 경우 해당 스택 프레임을 재사용할 수 있습니다. 이것을 `꼬리 재귀` 라고 부릅니다.

그리고 이 트릭을 적용함으로써, 꼬리 재귀함수는 불변의 스택 영역에서 실행될 수 있습니다. 따라서 이건 단지 반복적인 프로세스(iterative process) 의 또 다른 공식입니다.
꼬리 재귀함수는 `루프의 함수형` 이며 루프처럼 효율적으로 실행됩니다.

다시 살펴보면, `gdc`의 `else` 부분에서 `gcd`의 마지막 동작으로 자신을 호출한다는 것을 알 수 있습니다. 그리고 이것은 본질적으로 크기가 불변인 재작성 시퀀스(rewriting sequence)로 변환되며,
이는 컴퓨터에서 실제 실행 시 불변의 공간에서 실행할 수 있는 꼬리재귀 호출로 변환됩니다. 





