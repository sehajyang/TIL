
# Design Pattern

### 종류

##### 1 – [Iterator]("")

##### 2 – Adapter

##### 3 - Factory Method

##### 4 - Template Method

##### 5 – [Singleton](#singleton)

##### 6 – [Strategy](#strategy)

##### 7 – Composite

##### 8 – Decorator

##### 9 - Chain of Responsibility

##### 10 – Facade

##### 11 – [Observer](#observer)

##### 12 – Prototyp

##### 13 – Flyweight 

##### 14 – Builder

##### 15 – Mediator

##### 16 – Visitor


## Singleton

어플리케이션에서 인스턴스 한개만 만들어 사용하기 위한 패턴

new 를 사용할 수 없도록 생성자에 private를 지정하고 정적메소드를 지원해야하며

참조변수가 필요하다

동시에 접근할 경우 인스턴스 두개가 생성되게된다

따라서 synchronized 로 동기화시킨다.

인스턴스 사용하지 않는 경우에도 메모리에 있으며 그것을 방지하기위해 Volatile를 사용한다

모든 스레드에 대한 최신의 값을 읽어올 수 있게 해준다.


## Strategy

알고리즘군을 정의하고 캡슐화해, 교환해서 사용할 수 있도록 만든다.

알고리즘을 사용하는 클라이언트와는 독립적으로 알고리즘을 변경할 수 있다.


## Observer

Subject 인터페이스와 Observer 인터페이스가 들어있는 클래스 디자인을 바탕으로 구현한다.

한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고, 자동으로 내용이 갱신되는 방식이다. 

일대다 의존성을 정의.

Loose Coupling 이다.

* Loose Coupling(느슨한 결합)의 장점

	=> 객체 사이의 상호의존성을 최소화 했기에, 변경사항이 생겨도 무난히 처리할 수 있는 유연한 객체지향 시스템을 구축할 수 있다.
  
Subject 인터페이스가 옵저버에 대해 아는것은 옵저버가 인터페이스를 구현한다는 것 뿐이다.

옵저버는 언제든지 새로 추가/제거 할 수 있으며 Subject를 변경하지 않아도 된다.

Subject 인터페이스와 옵저버는 서로 독립적으로 재사용 할 수 있으며 서로 바뀌더라도 서로에게 영향을 주지 않는다.





참고 : HeadFirst Design Pattern


