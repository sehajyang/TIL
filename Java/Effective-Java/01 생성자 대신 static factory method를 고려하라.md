# 1. 생성자 대신 static factory method를 고려하라

Created: 2021년 2월 28일
Created by: Seha Jyang

## 생성자 대신 정적 팩토리 메서드를 고려하라

### 장점

- 이름을 가질 수 있다.
- 호출될 때 마다 인스턴스를 새로 생성하지 않아도 된다.
    - 인스턴스의 라이프사이클을 통제할 수 있다.
- 리턴 타입의 하위 타입 객체로 리턴할 수 있다.
    - 자바8 부턴 인터페이스가 static method를 가질 수 있다.
    - 하지만 내부 메서드나 멤버는 public 이어야 한다.
- 입력 파라미터에 따라 매번 다른 클래스의 객체를 리턴할 수 있다.
- static factory method를 작성하는 시점에는 리턴할 객체의 클래스가 존재하지 않아도 된다.

### 단점

- 상속하려면 public, protected 생성자가 필요한데, static factory method만 제공하면 하위 클래스를 만들 수 없다.
    - 상속보단 컴포지션을 사용해야됨
- 프로그래머가 찾기 힘들다.  공통규약을 알고 있어야 한다.

    ```java
    - from
    	- 파라미터를 하나 받아서 해당 타입의 인스턴스를 리턴하는 형변환 메서드

    - of
    	- 여러 파라미터를 받아 적합한 타입의 인스턴스를 반환하는 집계 메서드

    - valueOf
    	- from과 of의 더 자세한 버전

    - instance or getInstance
    	- 파라미터로 명시한 인스턴스를 리턴하지만 같은 인스턴스임을 보장하진 않음
    	- StackWalker luke = StackWalker.getInstance(options)

    - create or newInstance
    	- instance or getInstance 와 같지만, 매번 새로운 인스턴스를 생성해 리턴한다

    - get{Type}
    	- getInstance와 같으나, 생성할 클래스가 아닌 다른 클래스에 펙터리 메서드 정의할때 쓴다
    	- FileStore fs = Files.getFileStore(path)

    - newType
    	- bufferedreader br = Files.newBufferedReader(path)
    ```