# 31. 한정적 와일드카드를 사용해 API 유연성을 높여라

Created: 2021년 4월 4일
Created by: Seha Jyang

```java
public void pushAll(Iterable<? extends E> src) {
	for (E e : src) {
		push(e);
	}
}
```

`pushAll` 의 입력 파라미터 타입은 `E의 Iterable` 이 아니라 `E의 하위타입의 Iterable` 이어야 한다는 뜻

```java
public void popAll(Collection<? super E> dst) {
	while(!isEmpty()) {
		dst.add(pop());
	}
}
```

`popAll` 의 입력 파라미터 타입이 `E 의 Collection` 이 아니라 `E 의 상위 타입의 Collection` 이어야 한다.

유연성을 극대화하려면 원소의 생산자나 소비자용 입력 파라미터에 와일드 카드타입을 사용하라.

- 펙스(PECS)  : producer-extends, consumer-super

생산자라면 extends, 소비자라면 super

Get Put 원칙이라고도 부른다.

리턴타입엔 한정적 와일드카드 타입을 사용하면 안된다. 유연성은 저하되고 클라이언트 코드에서도 와일드카드 타입을 써야하기 때문이다.

- 주의
    - 클래스 사용자가 와일드카드 타입을 신경써야 한다면 그 API 에 무슨 문제가 있을 가능성이크다.