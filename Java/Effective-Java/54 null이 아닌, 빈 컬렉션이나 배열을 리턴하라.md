# 54. null이 아닌, 빈 컬렉션이나 배열을 리턴하라.

Created: 2021년 5월 22일
Created by: Seha Jyang

컬렉션이나 배열같은 컨테이너가 비었을 때 null을 리턴하는 메서드를 사용하면 항상 null 방어 코드를 넣어줘야하기 때문에 null을 리턴하게 하는건 좋지 않다.

그러니 대부분의 상황에선 이렇게 하면 된다.

```java
public List<Cheese> getCheeses() {
  return new ArrayList<>(cheesesInStock);
}
```

가능성은 낮지만 빈 컬렉션 할당이 성능을 떨어뜨릴 수도 있다. 이럴땐 매번 똑같은 빈 불변 컬렉션을 리턴하면 된다. 불변 객체는 공유해도 안전하다.

```java
public List<Cheese> getCheeses() {
  return cheesesInStock.isEmpty() ? Collections.emptyList() 
    : new ArrayList<>(cheeesesInStock);
}
```

배열을 쓸 때도 절대 null을 리턴하지 말고 길이가 0인 배열을 리턴하라.

```java
private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

public Cheese[] getCheeses() {
  return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
}
```

단순히 성능을 개선할 목적이라면 toArray에 넘기는 배열을 미리 할당하는건 추천하지 않는다, 오히려 성능이 떨어진다는 연구결과도 있다.

```java
// 나쁜 예
return cheesesInStock.toArray(new Cheese[cheesesInSock.size()]);
```

## 정리

**null이 아닌 빈 비열이나 컬렉션을 반환하라**. null을 리턴하는 API는 사용하기 어렵고 오류 처리 코드도 늘어나는데 그렇다고 성능이 좋은것도 아니다.