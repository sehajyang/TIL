# 70. 복구할 수 있는 상황에는 CheckedException을, 프로그래밍 오류에는 RuntimeException을 사용하라

Created: 2021년 5월 24일
Created by: Seha Jyang

자바는 throwable로 CheckedException, UnCheckedException=(런타임예외, 에러)를 제공한다.

다음은 언제 무엇을 사용해야 하는지에 대한 지침이다.

**호출하는 쪽에서 복구하리라 여겨지는 상황이라면** CheckedException을 **사용하라**

메서드 선언에 포함된 CheckedException은 그 메서드를 호출했을 때 발생할 수 있는 결과임을 사용자에게 알려준다.

호출자가 예외 상황에서 벗어나는데 필요한 정보를 알려주는 메서드를 함께 제공해야한다.

ex) 카드 잔고부족 검사 예외 ⇒ 잔고 얼마나 부족한지 알려주는 접근자 메서드를 제공해야한다.

UnCheckedException은 런타임 예외와 에러로, 프로그램에서 잡을 필요가 없거나 통상적으로 잡지 말아야 한다.(item 75)

**프로그래밍 오류를 나타낼 땐 런타임 예외를 사용하자**

런타임예외의 대부분은 전제조건을 만족하지 못했을 때 발생한다.

복구될 수 있다면 CheckedException을, 그렇지 않다면 런타임 예외를 사용하자. 확신하기 어렵다면 UnCheckedExceptioni를 선택하는 편이 나을 것이다.

에러는 보통 JVM 자원부족, 불변식 깨짐 등 수행을 더이상 할 수 없을때 사용한다.

Error 클래스를 상속해 하위 클래스를 만들지 말자

**구현하는 커스텀 비검사 throwable 은 모두 RuntimeException 의 하위 클래스여야 한다**

Exception, RuntimeExcepction, Error 모두 상속하지 않은 throwable을 만들수도 있지만 절대 사용하지 말자 정상적인 CheckedException보다 나을게 없으면서 API사용자를 헷갈리게 만든다.

예외의 메서드는 주로 그 예외를 일으킨 상황에 관한 정보를 코드로 전달하는데 쓰인다. 이런게 없다면 오류 메시지를 파싱해 정보를 빼내야 하는데 안티패턴이다.([item 12](12%20toString%20%E1%84%8B%E1%85%B3%E1%86%AF%20%E1%84%8C%E1%85%A2%E1%84%8C%E1%85%A5%E1%86%BC%E1%84%8B%E1%85%B4%20%E1%84%92%E1%85%A1%E1%84%85%E1%85%A1%208242aec1803441509cd28ab462b2582b.md))

## 정리

복구할 수 있다면 CheckedException을, 프로그래밍 오류라면 UnCheckedException을 던지고 확실하지 않다면 UnCheckedException를 던지자. 검사예외도, UnCheckedException도 아닌 throwable은 정의하지 말자. CheckedException라면 복구에 필요한 정보를 알려주는 메서드도 제공하자.

### 추가 자료

[https://cheese10yun.github.io/checked-exception/](https://cheese10yun.github.io/checked-exception/)