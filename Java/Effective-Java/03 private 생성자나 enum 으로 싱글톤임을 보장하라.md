# 3. private 생성자나 enum 으로 싱글톤임을 보장하라

Created: 2021년 3월 1일
Created by: Seha Jyang

## 싱글톤

- 클래스를 싱글톤으로 만들면 클라이언트를 테스트하기가 어렵다.

### static factory method

```java
public class Elvis {
  private static final Elvis INSTANCE = new Elvis();

  private Elvis() {
  }

  public static Elvis getInstance() {
    return INSTANCE;
  }

  public void leaveTheBuilding() {
  }
}
```

이 static factory 방식은 세가지 장점이 있다.

- API를 바꾸지 않고도 싱글톤이 아니게 변경할 수 있다.
    - 호출하는 스레드별로 다른 인스턴스를 넘겨주게 할 수 있다.
- static factory 를 제네릭 싱글톤 팩토리로 만들 수 있다. [아이템30]
- static factory moethod 참조를 supplier 로 사용할 수 있다. [아이템44,45]
    - `Elvis::getInstance` 를 `Supplier<Elvis>` 로 사용

## enum 타입 선언

```java
private Object readResolve() {
	return INSTRANCE; 

	public void leaveTheBuilding();
}
```

대부분의 상황에선 원소가 하나뿐인 enum타입이 싱글톤을 만드는데에 가장 좋은 방법이다.