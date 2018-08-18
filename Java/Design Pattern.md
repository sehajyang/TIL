
# Design Pattern

### 종류

##### 1 – [Iterator](#iterator-pattern)

##### 2 – [Adapter](#adapter-pattern)

##### 3 - [Factory Method](#factory-method-pattern)

##### 4 - [Template Method](#template-method-pattern)

##### 5 – [Singleton](#singleton-pattern)

##### 6 – [Strategy](#strategy-pattern)

##### 7 – [Composite](#composite-pattern)

##### 8 – [Decorator](#decorator-pattern)

##### 9 - [Chain of Responsibility](#chain-of-responsibility-pattern)

##### 10 – [Facade](#facade-pattern)

##### 11 – [Observer](#observer-pattern)

##### 12 – [Prototype](#prototype-pattern)

##### 13 – [Flyweight](#flyweight-pattern)

##### 14 – [Builder](#builder-pattern)

##### 15 – [Mediator](#mediator-pattern)

##### 16 – [Visitor](#visitor-pattern)

##### 17 - [Command](#command-pattern)

##### 18 - [State](#state-pattern)

##### 19 - [Proxy](#proxy-pattern)

##### 20 - [Compound](#compound-pattern)

##### 21 - [Bridge](#bridge-pattern)

##### 22 - [Interpreter](#interpreter-pattern)

##### 23 - [Memento](#memento-pattern)


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


## Singleton Pattern
 
특정클래스에 대해 객체 인스턴스 한개만 만들어 사용하기 위한 패턴

필요할 때만 객체를 만들기 위함

해당 클래스의 인스턴스가 하나만 만들어지고, 어디서든지 그 인스턴스에 접근할 수 있도록 하기 위한 패턴

```
public MyClass {
	public static MyClass getInstance(){
	}
}
```
>> MyClass에 정적메소드가 있고 그 정적 메소드는 이렇게 호출할 수 있다.

MyClass.getInstance();

>> 정적 메소드를 지칭할 때는 클래스 이름을 써야한다.(MyClass)



new 를 사용할 수 없도록 생성자에 private를 지정하고 정적메소드를 지원해야하며

참조변수가 필요하다

동시에 접근할 경우 인스턴스 두개가 생성되게된다

따라서 synchronized 로 동기화시킨다.

인스턴스 사용하지 않는 경우에도 메모리에 있으며 그것을 방지하기위해 Volatile를 사용한다

모든 스레드에 대한 최신의 값을 읽어올 수 있게 해준다.


## Strategy Pattern

알고리즘군을 정의하고 캡슐화해, 교환해서 사용할 수 있도록 만든다.

알고리즘을 사용하는 클라이언트와는 독립적으로 알고리즘을 변경할 수 있다.


## Observer Pattern

Subject 인터페이스와 Observer 인터페이스가 들어있는 클래스 디자인을 바탕으로 구현한다.

한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고, 자동으로 내용이 갱신되는 방식이다. 

일대다 의존성을 정의.

Loose Coupling 이다.

* Loose Coupling(느슨한 결합)의 장점

	=> 객체 사이의 상호의존성을 최소화 했기에, 변경사항이 생겨도 무난히 처리할 수 있는 유연한 객체지향 시스템을 구축할 수 있다.
  
Subject 인터페이스가 옵저버에 대해 아는것은 옵저버가 인터페이스를 구현한다는 것 뿐이다.

옵저버는 언제든지 새로 추가/제거 할 수 있으며 Subject를 변경하지 않아도 된다.

Subject 인터페이스와 옵저버는 서로 독립적으로 재사용 할 수 있으며 서로 바뀌더라도 서로에게 영향을 주지 않는다.


## Decorator Pattern

객체에 추가적인 요건을 동적으로 첨가한다. 

서브클래스를 만드는 것 을 통해서 기능을 유연 하게 확장할 수 있는 방법 을 제공 한다.

데코레이터의 super class는 자신이 장식 하고 있는 객체의 super class와 같다.

한 객체를 여러 개의 데코레이터로 감쌀 수 있다.

데코레이터는 자신이 감싸고 있는 객체와 같은 super class를 갖고 있기 때문에, 원래 객체가 들어갈 자리에 데코레이터 객체를 집어넣어도 상관없다.

데코레이터는 자신이 장식하고 있는 객체에게 어떤행동을 위임하는 것 외에 원하는 추가적인 작업을 수행할 수 있다.

객체를 언제든지 감쌀 수 있기 때문에 실행중에 필요한 데코레이터를 마음 대로 적용할 수 있다.


## Factory Method Pattern

객체를 생성하기위한 인터페이스를 정의하는데, 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만든다.

즉, 클래스의 인스턴스 만드는 일을 서브클래스에게 맡긴다.



**아래부터 보충 필요


## Command Pattern

메소드 호출을 캡슐화하는 패턴

커맨드 패턴을 이용하면 요구사항을 객체로 캡슐화 할 수 있으며, 매개변수를 써서 여러 가지 다른 요구사항을 집어넣을 수 있다.

요청 내역을 큐에 저장하거나 로그로 기록할 수 있으며, 작업취소 기능도 지원 가능하다.


## Adapter Pattern

한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환한다. 

어댑터를 이용하면 인터페이스 호환성 문제떄문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있다.


## Facade Pattern

어떤 서브시스템의 일련의 인터페이스에 대한 통합된 인터페이스를 제공한다.

퍼사드에서 고수준 인터페이스를 정의하기 때문에 서브시스템을 더 쉽게 사용할 수 있다.


## Template Method Pattern

알고리즘을 캡슐화 해서 서브클래스에서 필요할 때마다 쓸 수 있게 한다.

메소드에서 알고리즘의 골격을 정의한다.

알고리즘의 여러단계 중 일부는 서브클래스에서 구현 할 수 있다.

템플릿 메소드를 이요하면 알고리즘의 구조는 그대로 유지하면서 서브클래스에서 특정 단계를 재정의할 수 있다. 


## Iterator Pattern

내부적인 구현방법을(반복작업을 별도의 객체로 캡슐화 함으로써) 외부에 노출시키지 않으면서도 그 집합체 안에 들어있는 모든 항목에 접근할 수 있게 해주는 방법을 제공한다.



## composite Pattern

객체들을 트리 구조로 구성하여 부분과 전체를 나타내는 계층구조로 만들 수 있다.

이 패턴을 이요하면 클라이언트에서 개별 객체와 다른 객체들로 구성된 복합 객체(composite)를 똑같은 방법으로 다룰 수 있다.

복합 구조(composite structure)를 사용하면 복합객체와 개별객체에 대해 똑같은 작업을 적용할 수 있다.



## State Pattern

객체의 내부 상태가 바뀜에 따라서 객체의 행동을 바꿀 수 있다. 

마치 객체의 클래스가 바뀌는 것과 같은 결과를 얻을 수 있다. 



## Proxy Pattern

어떤 객체에 대한 접근을 제어하기 위한 용도로, 대리인이나 대변인에 해당하는 객체를 제공하는 패턴

원격객체라던가 생성하기 힘든 객체, 보안이 중요한 객체와 같은 다른 객체에 대한 접근을 제어하는 대변자 객체를 만들 수 있다. 



## Compound Pattern

두개이상의 패턴을 결합해서 사용하는 것



## Bridge Pattern

구현뿐만 아니라 추상화된 부분까지 변경시켜야 하는 경우에 사용

브리지 패턴을 이용하면 추상화된 부분과 추상클래스/인터페이스를 구현한 클래스를 서로 다른 클래스 계층구조에 집어넣음으로써 그 둘을 모두 변경시킬 수 있다.



## Builder Pattern

제품 생산 단계들을 캡슐화하고싶다면 사용

복합객체가 생성되는 과정을 캡슐화한다. 여러단계와 다양한 절차를 통해 객체를 만들 수 있다. (팩토리패턴에선 한단계에서 모든걸 다 처리한다)



## Chain of responsibility Pattern

역할사슬 패턴

주어진 요청을 검토하기 위한 객체사슬을 생성한다.

그 사슬에 속해있는 각 객체에서는 자기가 받은 요청을 검사해 직접 처리하거나 사슬에 들어있는 다른 객체에게 넘기게 된다.
 

## Flyweight Pattern

어떤 클래스 인스턴스 한 개만 가지고 여러개의 가상인스턴스를 제공하고 싶을 때 사용

인스턴스는 한개만 만들어 여러 가상 객체의 상태를 한곳에 집중시켜놓을 수 있다.



## Interpreter Pattern

어떤 언어에 대한 인터프리터를 만들 때는 인터프리터 패턴을 사용

각 문법 규칙을 클래스로 표현하기 때문에 언어를 쉽게 구현할 수 있다.

문법이 클래스에 의해 표현되기 때문에 언어를 쉽게 변경하거나 확장할 수 있다.



## Mediator Pattern

서로 관련된 객체 사이의 복잡한 통신과 제어를 한 곳으로 집중시키고자 하는 경우에 사용

시스템하고 각 객체를 분리시킴으로써 재사용성을 향상시킬 수 있다.

제어로직을 한군데에 모아두었기 때문에 관리하기가 수월하다.


## Memonto Pattern

객체를 이전의 상태로 복구시켜야 하는 경우에 사용


## Prototype Pattern

어떤 클래스의 인스턴스를 만드는것이 자원/시간을 많이 잡아먹거나 복잡한 경우에 사용

기존 인스턴스를 복사하기만 하면 새로운 인스턴스를 만들 수 있다.

클라이언트 코드에서 어떤 클래스의 인스턴스를 만드는지 모르는 상태에서도 새로운 인스턴스를 만들 수 있다.


## Vititor Pattern

다양한 객체에 새로운 기능을 추가해야하는데 캡슐화가 별로 중요하지 않을 경우 사용

구조 자체를 변경시키지 않으면서도 복합 객체 구조에 비교적 손쉽게 새로운 기능을 추가할 수 있다.



<hr>
참고 : HeadFirst Design Pattern


