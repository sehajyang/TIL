# 53. 가변인수(varargs)는 신중히 사용하라

Created: 2021년 5월 22일
Created by: Seha Jyang

`varargs` 메서드는 명시한 타입의 파라미터를 0개이상 받을 수 있다. 하지만 받아야하는 파라미터가 1개이상이어야 하는 경우면 다음과 같이 사용해야 한다.

```java
static int min(int firstArg, int... remainingArgs) {
  ...
}
```

성능에 민감한 상황이라면 가변인수가 걸림돌이 된다. 가변인수 메서드는 호출될 때 마다 배열을 새로 하나 할당하고 초기화한다.

그럴땐 다음과 같은 패턴을 사용할 수 있다.

```java
// 해당 메서드 호출의 95%가 파라미터를 3개 이하로 사용하는 경우
public void foo() { }
public void foo(int a1) { }
public void foo(int a1, int a2) { }
public void foo(int a1, int a2, int a3) { }
public void foo(int a1, int a2, int a3, int... rest) { }
// 마지막 다중정의 메서드가 인수 4개이상인 5%호출을 담당한다.
```

이 패턴은 보통땐 별 이득이 없지만, 꼭 필요한 특수 상황에선 좋을 것이다.

EnumSet의 static factory도 이 기법을 사용해 EnumType 집합 생성 비용을 최소화한다.

## 정리

파라미터 개수가 일정하지 않은 메서드를 정의해야 한다면 가변인수가 반드시 필요하다. 메서드를 정의할 때 필수 파라미터는 가변인수 앞에 두고, 가변인수를 사용할땐 성능문제도 고려하자.