# Java

### 1. Java 란

[객체지향(OPP)]("") 프로그래밍 언어

JVM 을 이용(운영체제에 독립적). 

자바에서 컴파일 시 바이트코드(.class)로 출력되며 그 바이트코드는 기계코드로 변경되어 실행된다.

자동으로 [메모리 관리(Garbage collector)]("")를 해준다.

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



#### 객체지향 프로그래밍(Object Oriented Programming)

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



### 2. 자료형(Data type)

#### 기본 자료형

사용전 선언되어야한다.

생성한 변수에는 하나의 값을 저장한다.

* 종류 

  byte, char, short, int, double, long, float, boolean

* [WrapperClass]("")  = 기본 데이터타입을 Class 화 한것

  

#### 참조 자료형(Reference Data Type)

주소값을 저장한다.

* 종류

   class, interface, array, enum

* 명명 규칙

  알파벳 대소문자, 숫자, 한글가능.

  특수문자 사용 X (예외 : _ $ 가능)

  숫자로 시작 불가능하다.

  클래스는 대문자로, 메소드와 변수는 소문자로 시작.

  합성어의 경우 첫 문자는 대문자로

  예약어는 사용 불가능하다.

  

### 3. 접근제어자(Access modifire)

접근 영역을 제한시 사용한다 선언 생략시 default로 setting

* 종류

  public         :    제한없이 사용 가능

  default        :    private + 같은 패키지 내에서 사용가능

  protected   :    default  + 상속이면 사용가능

  private        :    자신의 클래서 내 에서만 사용 가능



### 4. FrameWork 

소프트웨어 설계와 구현을 재사용 가능하도록 해주는 뼈대

구체적, 확장 가능한 기반코드를 가지고 설계자의 의도에 따르는 여러 디자인 패턴 집합으로 구성



### 5. Collection

* 종류

  List 계열 : AbstractList, ArrayList, LinkedList, Vector 
  Map 계열 : AbstractMap, Attributes, HashMap, Hashtable, IdentityHashMap, RenderingHints, TreeMap, WeakHashMap 
  Set계열 : AbstractSet, HashSet, LinkedHashSet, TreeSet

* List

  순서가 있다. 동일 데이터 중복 가능

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

#### 6. 쓰레드(Thread)



##### 참고 

[JongMin Kim님 repository]("https://github.com/devetude/Java-Interview-QnA")

[HanjaeYeop님 reposiroty]("<https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Development_common_sense ")

