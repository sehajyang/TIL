# 71. 필요 없는 CheckedExceptionCheckedException 사용은 피하라

Created: 2021년 5월 24일
Created by: Seha Jyang

CheckedException를 과하게 쓰면 쓰기 불편한 API가 되고 스트림 안에서 직접 사용할 수 없다.

CheckedException를 회피하는 쉬운 방법은 적절한 결과 타입을 담은 옵셔널을 리턴하는 것이다([item 55](55%20Optional%20%E1%84%85%E1%85%B5%E1%84%90%E1%85%A5%E1%86%AB%E1%84%8B%E1%85%B3%E1%86%AB%20%E1%84%89%E1%85%B5%E1%86%AB%E1%84%8C%E1%85%AE%E1%86%BC%E1%84%92%E1%85%B5%20%E1%84%92%E1%85%A1%E1%84%85%E1%85%A1%20b31095d9d4e049438b252da0d1b0527c.md)) 검사 예외를 던지는 대신 빈 옵셔널을 리턴하면 된다. 단점은 예외가 발생한 이유를 알려주는 부가정보를 담을 수 없다.

반면 예외를 사용하면 예외타입과 예외에 대한 부가정보를 제공할 수 있다.

또다른 방법으론, 검사 예외를 던지는 메서드를 2개로 쪼개 비검사 예외로 바꿀 수 있다.

```java
// 리팩토링 전
try {
  obj.action(args);
} catch (CheckedException e) {
  ... // exception handling
}

//리팩토링 후
if (obj.actionPermitted(args)) {
  obj.action(args)
} else {
  ... // exception handling
}
```

## 정리

꼭 필요한 곳에만 사용한다면 CheckedException는 프로그램의 안정성을 높여주지만 남용하면 좋지 않다. API 호출자가 예외 상황에서 복구할 방법이 없다면 UnCheckedException을 던지자. 복구 가능하고 호출자가 처리를 해주길 바란다면 Optional을 리턴해도 될지 고민하고 그것만으론 충분한 정보를 제공할 수 없을때만 CheckedException을 던지자.