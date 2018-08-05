
# Design Pattern

### 종류

##### 1 – [Iterator]("")

##### 2 – Adapter

##### 3 - [Factory Method](#factory-method)

##### 4 - Template Method

##### 5 – [Singleton](#singleton)

##### 6 – [Strategy](#strategy)

##### 7 – Composite

##### 8 – [Decorator](#decorator)

##### 9 - Chain of Responsibility

##### 10 – Facade

##### 11 – [Observer](#observer)

##### 12 – Prototyp

##### 13 – Flyweight 

##### 14 – Builder

##### 15 – Mediator

##### 16 – Visitor


## 디자인 원칙(SOLID)

1. Open-Closed-Principle(개방 폐쇄 원칙)

	클래스는 확장에 대해서는 열려있어야하지만, 코드변경에 대해서는 닫혀있어야한다.

2. Dependency-Inversion-Principle(의존성 뒤집기 원칙)

	추상화된것에 의존하게 만들어야한다. 구상클래스에 의존하도록 만들지 않도록 한다.

	어떤 변수에도 구상클래스에 대한 레퍼런스를 저장하지않는다.

	구상 클래스에서 유도된 클래스를 만들지 않는다.

	베이스 클레스에 이미 구현되어있던 메소드를 오버라이드 하지 않는다.


3. Single Responsiblity Principle(단일 책임 원칙)

4. Liskov Subsitution Principle(리스코브 치환 원칙)

5. Interface Segregation Principle(인터페이스 분리 원칙)


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


## Decorator

객체에 추가적인 요건을 동적으로 첨가한다. 

서브클래스를 만드는 것 을 통해서 기능을 유연 하게 확장할 수 있는 방법 을 제공 한다.

데코레이터의 super class는 자신이 장식 하고 있는 객체의 super class와 같다.

한 객체를 여러 개의 데코레이터로 감쌀 수 있다.

데코레이터는 자신이 감싸고 있는 객체와 같은 super class를 갖고 있기 때문에, 원래 객체가 들어갈 자리에 데코레이터 객체를 집어넣어도 상관없다.

데코레이터는 자신이 장식하고 있는 객체에게 어떤행동을 위임하는 것 외에 원하는 추가적인 작업을 수행할 수 있다.

객체를 언제든지 감쌀 수 있기 때문에 실행중에 필요한 데코레이터를 마음 대로 적용할 수 있다.


## Factory Method

객체를 생성하기위한 인터페이스를 정의하는데, 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만든다.

즉, 클래스의 인스턴스 만드는 일을 서브클래스에게 맡긴다.


참고 : HeadFirst Design Pattern


