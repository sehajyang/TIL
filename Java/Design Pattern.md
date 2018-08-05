
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

##### 11 – Observer

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






참고 : HeadFirst Design Pattern


