# 38. 확장할 수 있는 Enum타입이 필요하면 인터페이스를 사용하라

Created: 2021년 5월 2일
Created by: Seha Jyang

- 확장 가능한 Enum Type이 이 어울리는 경우
    - 연산코드(opcode)
        - API가 제공하는 기본 연산외에 추가적인 제공이 필요할 때가 있다.

```java
public interface Operation {
	double apply(double x, double y);
}

public enum BasicOper impl Operation {
	PLUS("+") {
		public double apply(double x, double y) { return x + y; }
	}
	private final String symbol;

	BasicOper(String symbol) {
		this.symbol = symbol;
	}
}
```

타입수준에서도, 기본 EnumType 대신 확장된 EnumType을 넘겨 확장된 EnumType의 원소 모두를 사용하게 할 수도 있다.

두가지 방법이 있다. 

- 첫번째 방법, Class 객체가 한정적 타입 토큰 역할을 한다.

```java
private static **<T extends Enum<T> & Operation> void test(
	Class<T> opEnumType**, double x, double y) { 
...
}
```

`Class<T>` : Class 객체가 **EnumType인 동시에 Operation의 하위 타입**이어야 한다.

- 두번째 방법, Class 객체 대신 한정적 와일드 카드 타입인 `Collections<? extends Operation>` 을 넘긴다

```java
private static void test(
	Collection<? extends Operation> opSet, double x, double y)  {
		...
	}
```

ex ) java.nio.file.LinkOption

### 정리

Enum Type자체를 확자할 수 없지만 인터페이스와 그 인터페이스를 구현하는 기본 Enum type을 함께 사용해 같은 효과를 낼 수 있다. 이렇게 하면 클라이언트는 이 인터페이스를 구현해 자기만의 Enum type 을 만들 수 있다. 그리고 API 가 인터페이스 기반으로 작성됐다면 기본 Enum type의 인스턴스가 쓰이는 모든 곳을 새로 확장한 Enumtype의 인스턴스로 대체해 쓸 수 있다.