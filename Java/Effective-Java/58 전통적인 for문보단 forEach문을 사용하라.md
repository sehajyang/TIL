# 58. 전통적인 for문보단 forEach문을 사용하라

Created: 2021년 5월 23일
Created by: Seha Jyang

```java
// 전통적인 for문
for (Iterator<Element> i = c.iterator(); i.hasNext();) {
  Element e = i.next;
  ... // e와 i로 뭔가 한다
}

// 이게 더 가독성 측면에서도, 변수를 잘못 사용할 틈새를 줄이는데에도 좋다.
for(Element e : elements) {
  ... // e로 뭔가 한다.
}
```

컬렉션을 중첩해 순회해야한다면 for-each가 더 낫다

```java
List<Card> deck  = new ArrayList<>();
for (Iterator<Suit> i = suits.iter(); i.hasNext();)
  for (Iterator<Rank) j = suits.iter(); i.hasNext();) {
    deck.add(new Card(i.next(), j.next())); // 오류
}

// 이게 더 간결하고 오류가 발생할 여지도 적음
for (Suit suit : suits)
  for(Rank rank :ranks)
    deck.add(new Card(suit,rank));
```

하지만 for each 를 사용할 수 없는 상황이 세가지 있다.

- **파괴적인 필터링(destructive filtering)**
    - 컬렉션을 순회하며 선택된 원소를 제거해야 한다면 반복자의 remove 메서드를 호출해야 한다. 자바 8부터는 Collection의 `removeIf` 메서드를 사용해 컬렉션을 명시적으로 순회하는 일을 피할 수 있다.
- **변형(transforming)**
    - 리스트나 배열을 순회하며 그 원소의 값 일부 혹은 전체를 교체야 한다면 리스트의 반복자나 배열의 인덱스를 사용해야 한다.
- **병렬 반복(parallel iteration)**
    - 여러 컬렉션을 병렬로 순회해야 한다면 각각의 반복자와 인덱스 변수를 사용해 엄격하고 명시적으로 제어해야 한다.

forEach문은 Iterable 인터페이스를 구현한 객체다. 원소들의 묶음을 표현하는 타입을 작성해야 한다면 Iterable을 구현하는 쪽으로 고민해보는게 좋다.

## 정리

전통적인 for문과 비교했을 때 forEach문은 명료하고 유연하고 버그를 예방해준다. 성능 저하도 없다. 가능한 모든 곳에서 for문이 아닌 forEach문을 사용하자.