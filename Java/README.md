# Java

### 1. Java 란

[객체지향(OPP)]("") 프로그래밍 언어

JVM 을 이용(운영체제에 독립적). 

자바에서 컴파일 시 바이트코드(.class)로 출력되며 그 바이트코드는 기계코드로 변경되어 실행된다.

자동으로 메모리 관리(Garbage collector)를 해준다.

[다중 쓰레드]("")를 제공한다.

##### C언어와의 차이점

* C

  하드웨어를 직접 제어가능하다.

  절차지향

  구조화된 프로그램 개발이 가능하다.

* java

  중간코드(바이트코드)를 생성해 어느 플랫폼이나 사용 가능하다.

  객체지향

  C언어에 비해 메모리와 속도가 느리다(JVM을 사용하기 때문).

  

### 2. 객체지향 프로그래밍(Object Oriented Programming)

실 생활의 특징을 모델링 해 소프트웨어로 옮겨오는것

객체란 실 생활의 사물에 대한 추상화 한 것이며, 그에 필요한 멤버변수와 메소드를 정의한다. 

추상화, 캡슐화,다형성등의 특징이 있다.

이미 작성한 코드에대한 재사용성이 높다( 로직을 라이브러리로 만든다던지).

라이브러리 생성시 버그를 잡기 때문에 버그가 발생할 확률이 낮아진다.(디버깅이 쉽고 유지보수가 용이)

또한 라이브러리가 제공하는 기능을 사용하게되면 생산성 또한 높아진다.

##### 추상화란?

굳이 구현할 필요없는 부분을 생략하고 필요한 부분만을 나타내는 것.

##### 다형성이란?

하나의 메소드나 클래스가 다양한 방법으로 동작하게하는 요소

단순한 상속이나 인터페이스가 구현이 된 클래스

계층적으로 다단계 상속을 이루고 있는 클래스

여려개의 인터페이스를 한번에 구현한 클래스 등으로 표현된다.

Overriding, Overloading 이 있다.

* Overriding

  자식클래스에서 부모클래스 메소드를 재정의한다.

  super()를 쓰면 부모클래스 메소드를 사용한다.

* Overloading

  같은 이름이지만 매개변수의 종류 및 숫자가 다른 메소드

  같은 기능이지만 다른 인자를 수행하는 메소드 정의시 사용.

##### 캡슐화(encapsulation)란?

메소드의 기능만 알며, 어떻게 동작하는지는 알필요 없이 사용하는 것

외부에서 변경 불가하게 private로 선언하고 setter getter 메소드를 통해서만 접근 가능하다.

=> 무결성을 보장한다.

##### 상속이란?

부모클래스의 속성과 메소드를 자식클래스가 물려받아 사용할 수 있는 것.

부모클래스에서 private로 선언시 자식클래스는 상속받아도 사용하지 못한다.

다중상속(extends)이 불가능하므로 [interface]("")를 사용해 다중상속을 한다.



### 3. 자료형(Data type)

#### 기본 자료형

사용전 선언되어야한다.

생성한 변수에는 하나의 값을 저장한다.

call-by-value에 의해 메소드의 인자값을 전달한다.

* 종류 

  byte, char, short, int, double, long, float, boolean

* [WrapperClass]("") 

  기본 데이터타입을 참조자료형으로 만든것(Class 화 한 것)

  참조 자료형을 매개변수로 받거나, 객체자료형으로 저장해야하거나 객체간 비교가 필요할 경우 사용


#### 참조 자료형(Reference Data Type)

주소값을 저장한다.

 call-by-reference에 의해 메소드의 인자값을 전달한다.

* 종류

   class, interface, array, enum

* 명명 규칙

  알파벳 대소문자, 숫자, 한글가능.

  특수문자 사용 X (예외 : _ $ 가능)

  숫자로 시작 불가능하다.

  클래스는 대문자로, 메소드와 변수는 소문자로 시작.

  합성어의 경우 첫 문자는 대문자로

  예약어는 사용 불가능하다.

  


### 4. 접근제어자(Access modifire)

접근 영역을 제한시 사용한다 선언 생략시 default로 setting

* 종류

  public         :    제한없이 사용 가능

  default        :    private + 같은 패키지 내에서 사용가능

  protected   :    default  + 상속이면 사용가능

  private        :    자신의 클래서 내 에서만 사용 가능

  

### 5. FrameWork 

소프트웨어 설계와 구현을 재사용 가능하도록 해주는 뼈대

구체적, 확장 가능한 기반코드를 가지고 설계자의 의도에 따르는 여러 디자인 패턴 집합으로 구성



### 6. Collection

* 종류

  List 계열 : AbstractList, ArrayList, LinkedList, Vector 

  Set계열 : AbstractSet, HashSet, LinkedHashSet, TreeSet

  Map 계열 : AbstractMap, Attributes, HashMap, Hashtable, IdentityHashMap,RenderingHints, TreeMap, WeakHashMap , Properties

* List

  순서가 있다(순차적 데이터 저장). 동일 데이터 중복 가능

  데이터 순차 검색시 용이하다.

  * Vector

    동기화(Synchronized)

  * ArrayList

    동기화 안함

* Set

  순서 없음. 중복 불가능

  순차 접근을 위해 Iterator을 사용한다.

* Map

  Key와 Value 형태로 입력

  순서 없음, Key값 중복 안됨

  특정 데이터 검색시 용이하다.

  * HashMap

    데이터 입출력 동기화 안됨, 처리속도 빠름

  * HashTable

    모든 입출력이 동기화(토큰을 부여받아 순차접근)되나 처리속도는 떨어진다.

### 6. 추상 클래스(Abstract Class)와 인터페이스(Interface)

##### - 추상클래스(abstract)

extends이용해 상속을 진행한다.

단일 상속

형태만 정의(미완성 메소드)함으로 자식클래스에선 미완성 메소드를 재정의 해야한다.

##### - 인터페이스(interface)

implements 를 이용해 상속을 진행한다.

다중 상속

추상클래스보다 추상화 정도가 높다. 기능의 재정의에 큰 의미를 둔다

상수와 추상 메소드만 선언 가능하다.

자식클래스에서 반드시 메소드를 재정의(overriding) 해야한다

### 7. 쓰레드(Thread)

프로세스내에서 동시에 실행되는 독립적인 실행 단위 

쓰레드는 각자의 스택 메모리영역을 갖고있으며 다른 쓰레드들과 전역 메모리를 공유한다.

##### 특징

자원을 많이 사용하지않고 구현이 쉬우며 범용성이 높다.

##### 구현방법(2가지)

1. Thread 클래스를 상속받는다.
2. Runnable interface를 상속받아 run 메소드 재정의

##### Thread의 동기화(synchronized)와 데드락(deadlock)

* synchronized

  2개이상 쓰래드가 공유자원에 접근해 값 변경하려 할 수가 있으므로 공유변수에 synchronized를 사용해야한다.

  synchronized를 사용하면 하나의 쓰레드가 공유자원 점유시 타 쓰레드가 대기상태에 머문다.

* deadlock

  두 쓰레드가 서로 공유변수에 lock걸고 작업중 서로의 것에 필요한 코드가 있으나

  각자 선점중이므로 둘다 대기상태에 계속 머무르게 되는 현상

  망에선 사용 가능한 버퍼가 없어 노드들이 패킷을 전송할 수 없는 상태이다.

##### process와의 차이점

쓰레드와 달리 프로세스는 자기자신의 메모리 영역을 가진다.

자원쓰기시 복사(copy on write) 방식으로 자식프로레스에게 복사하여 사용하는 방식이다. 

thread에 비해 느린 수행능력을 보여준다.

 ##### Thread 사용여부

지나친 다중화는 각 스레드를 스케줄링하는데에 대부분의 CPU 타임을 소모하며

Thrashing과 같은 문제가 생길 수 있다. 

각 스레드는 다른 스레드가 끝날 때까지 대기상태에 있기 때문에 병행적이지 않은 프로그램은 더 느려지고 복잡해질 수 있다.

##### 사용해야하는 예

병렬적으로 다수의 작업을 수행하며 다중프로세서 하드웨어등에서 동작하는 프로그램

중복될 수 있는 많은 입출력을 수행하는 프로그램



### 7. JVM 메모리 구조

class, stack, heap, native 메소드, PC 레지스터로 구성되어있다.

##### Class 영역

프레임(호출된 메소드를 위한 공간)이 생성되어 각종 값이 임시로 저장된다

메소드 실행 종료시 프레임삭제가 진행된다.

##### heap 영역

new 로 생성된 객체와 배열이 저장된다.

permanent geration, new, old 영역으로 나뉜다.

* permanent geration = 객체의 주소값 저장
* new 
  * eden = 객체 최초 생성영역
  * survivor = 참조되는 객체 저장 영역
* old = new영역에서 참조되고있는 객체 저장공간

##### native 메소드 영역 

자바 외 타 언어에서 제공되는 메소드가 저장

##### PC 레지스터 영역

쓰레드 생성시 생성되는 영역

쓰레드의 현재 실행되는 부분의 명령 및 주소를 실행할지 저장



### 8. Garbage Colloetion

garbage를 회수해 사용할 수 있는 메모리공간을 늘리는 것

garbage collector가 수행

JVM이 자동 실행해주지만 System.gc() 로 수동으로도 가비지 컬랙션을 요청할 수 있다.



### 9. NIO(new input-output)

자바 IO(input-output)의 단점을 보완한 새로운 IO 패키지

기존의 모든 IO에 대해 쓰레드를 생성하는 방식이 아닌 채널관리자(selector)를 사용해

실제 IO가 발생한 채널만 쓰레드를 생성해 관리.

하지만 기존의 다중쓰레드 이용한 방식보다 구현하기 어렵다.



##### 참고 

[JongMin Kim님 repository]("https://github.com/devetude/Java-Interview-QnA")

[HanjaeYeop님 reposiroty]("https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Development_common_sense")

