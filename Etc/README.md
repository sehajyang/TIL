# 면접 준비하면서 정리했던 것

KimJunJin님의 면접에 나왔던 질문의 답을 찾아서 정리 했습니다. [Link](https://github.com/KimHunJin/Study-Book/tree/master/interview)

## JAVA
1. JVM 구조
    => class(method area), stack, heap, native method, pc register로 이루어져있음
    => class : 값 임시저장, 상수 풀 , static변수 저장
    => stack: 메서드 안에서 사용되어지는 값 저장, 매개변수, 지역변수, 리턴 값 등 임시저장, 수행끝나면 프레임별로 삭제
    => heap  : new로 생성된 객체와 배열 저장, gc를 통해 메모리 반환, 객체 주소값 저장
    => native method: 타 언어 메소드 저장
    => pc register: 쓰레드 생성시 생성되는 영역
    추가:http://asfirstalways.tistory.com/158

2. GC 처리방법
    => major, minor부분이 있다. 더이상 콜이 되지 않을 new로 만들어진 힙역에 할당된 아이템들을 수집해 삭제하는 작업을 한다.
    => 삭제된 객체의 메모리를 반환
        ① Minor Garbage Collection
        i) New 영역에서 일어나는 Garbage Collection
        ii) Eden영역에 객체가 가득 차게 되면 첫 번째 Garbage Collection 발생
        iii) Survivor1 영역에 값 복사
        iv) Survivor1 영역을 제외한 나머지 영역의 객체들을 삭제
        v) Eden영역과 Survivor1영역의 메모리가 기준치 이상일 경우, Eden 영역에 생성된
        객체와 Survivor1영역에 있는 객체 중 참조되고 있는 객체가 있는지 검사
        vi) 참조되고 있는 객체를 Survivor2 영역에 복사
        vii) Surviver2 영역을 제외한 영역의 객체들을 삭제
        viii) 일정시간이상 참조되고 있는 객체들을 Old영역으로 이동
        ix) 반복

        ② Major Garbage Collection (Full Garbage Collection)
        i) Old영역에 있는 모든 객체들을 검사
        ii) 참조되지 않은 객체들을 한꺼번에 삭제
        iii) Minor Garbage Collection에 비해 시간이 오래 걸리고 실행 중 프로세스가 정지

        출처: http://huelet.tistory.com/entry/JVM-메모리구조

3. HashMap HashTable concurrentHashMap
    HashMap : 동기화 지원 안함
    HashTable: 동기화 지원 함
    concurrentHashMap : Java5 부터 지원하는 동기화 지원, HashTable보다 좋다고한다.
    참고:http://odol87.tistory.com/3

4. 접근제어자
    => 접근 영역을 제한할때 사용, 생략시 default로 셋팅
    public : 제한 x
    default: 같은 패키지
    protect: 상속이면 가능
    private: 자신 클래스에서만 사용가능

5. interface, abstract의 차이
    => interface : 다중 상속 가능, class body 있으면 안됨, 일종의 약속
    => abstract : 단일 상속, class body 있어도 됨, 기능 재정의가 목적

6. StringBuilder, StringBuffer
    => StringBuilder : 동기화 미 지원, StringBuffer보다 빠르다.
    => StringBuffer : 동기화 지원

7. try with resources
    => IO 예외시 자원을 자동으로 닫아준다
    close()시 만약 예외가 발생할 경우 catch로 보내준다
    참고:https://dololak.tistory.com/67

8. Synchronize : 동기화 하기 위함

9. Synchronize 방법
    => 기본적으로는 Collections라는 util 클래스에서 제공되는 static 메소드를 통해 이를 해결할 수 있다. Collections.synchroziedList(), Collections.synchroziedSet(), Collections.synchroziedMap() 등이 존재한다. JDK 1.7 부터는 concurrent package를 통해 ConcurrentHashMap이라는 구현체를 제공한다. 
    Collections util 을 사용하는 것보다 synchronized 키워드가 적용된 범위가 좁아서 보다 좋은 성능을 낼 수 있는 자료구조이다.

10. static은 메모리 어디에 올라가는가 : 
    => JVM의 class 영역 (method area)에 올라간다.

11. 컬렉션 프레임워크에 대해 설명하시오
    => DataStructure 를 직접 구현하지 않고 사용할 수 있는 것이며, 
    배열과는 다르게 객체를 보관하기 위한 공간을 미리 정하지 않아도 되므로, 
    상황에 따라 객체의 수를 동적으로 정할 수 있음으로서 프로그램의 공간적인 효율성 또한 높여준다.

    List :  List 인터페이스를 직접 @Override를 통해 사용자가 정의하여 사용할 수도 있으며, 
            대표적인 구현체로는 ArrayList가 존재하며, 이는 기존에 있었던 Vector를 개선한 것이다. 
            이외에도 LinkedList 등의 구현체가 존재한다.
    Map :   대표적인 구현체로는 HashMap이 존재한다. 
            key-value 의 구조로 이루어져 있으며 Map 에 대한 구체적인 내용은 DataStructure 부분의 hashtable 과 일치한다. 
            key 를 기준으로 중복된 값을 저장하지 않으며 순서를 보장하지 않는다. 
            key 에 대해서 순서를 보장하기 위해서는 LinkedHashMap을 사용한다.
    Set :   대표적인 구현체로는 HashSet이 존재한다. value에 대해서 중복된 값을 저장하지 않는다. 
            사실 Set 자료구조는 Map 의 key-value 구조에서 key 대신에 value 가 들어가 value 를 key 로 하는 자료구조일 뿐이다. 
            마찬가지로 순서를 보장하지 않으며 순서를 보장해주기 위해서는 LinkedHashSet을 사용한다.
    Stack 과 Queue
    Stack 객체는 직접 new 키워드로 사용할 수 있으며, 
    Queue 인터페이스는 JDK 1.5 부터 LinkedList 객체를 통해 new 키워드를 통해 사용할 수 있다. 
    
    출처 : https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Development_common_sense

12. 제네릭에 대해 설명해주시고, 왜 쓰는지 어디서 써 봤는지 알려주세요.
    => 컴파일과정에서 타입체크, 객체의 타입안정성 높인다. collection에 특정객체만 추가될 수 있도록 한다.

13. Vector와 List 차이에 대해 설명하시오.
    => Vector: 연속적인 메모리, 미래에 들어갈 요소 위해 선할당 함, 메모리 재할당 가능
    => List : 비연속적 메모리, 선할당 안함, 추가제거 잦을시 사용

14. Overloading Overriding 차이는? 
    Overriding
        자식클래스에서 부모클래스 메소드를 재정의한다.
        super()를 쓰면 부모클래스 메소드를 사용한다.
    Overloading
        같은 이름이지만 매개변수의 종류 및 숫자가 다른 메소드
        같은 기능이지만 다른 인자를 수행하는 메소드 정의시 사용.

15. CheckedException과 UnCheckedException의 차이를 설명하시오.
    => CheckedException : 반드시 예외처리 해야함, 컴파일단계에서 에러남
        ex) IOException, SQLException
    => UnCheckedException : 예외처리 강제안함, 실행단계에서 에러남
        ex) NullPointer, ILLegarArgument, Out Of Bound Exception등등

16. OOP란 무엇인가요?
    객체지향, 크게 3가지 특징이있다. 추상화, 캡슐화, 다형성
    추상화
    => 굳이 구현할 필요없는 부분을 생략하고 필요한 부분만을 나타내는 것.
    다형성
    => 하나의 메소드나 클래스가 다양한 방법으로 동작하게하는 요소
    단순한 상속이나 인터페이스가 구현이 된 클래스
    계층적으로 다단계 상속을 이루고 있는 클래스
    여려개의 인터페이스를 한번에 구현한 클래스 등으로 표현된다.
    Overriding, Overloading 이 있다.
    캡슐화(encapsulation)
    => 메소드의 기능만 알며, 어떻게 동작하는지는 알필요 없이 사용하는 것
    외부에서 변경 불가하게 private로 선언하고 setter getter 메소드를 통해서만 접근 가능하다.
    => 무결성을 보장한다.

17. final / finally / finalize 의 차이를 설명하시오.
    final : 변경 불가능, 
        final class => 상속x, final method => overriding x, final var => 상수
    finally : 예외처리에서 무조건 실행하는것
    finalize():gc에 의해 호출되는 메소드, 이거 잘 못하면 OOME(Out of memory Exceprion) 발생하니까 건들지말것

18. new String()과 ""의 차이에 대해 설명해주세요.
    => new String()은 heap내의 spring pool에 객체 생성 뒤 그 객체의 주소를 가지게 되는것
    ""는 문자열 자체를 저장 후 그 배열의 인덱스 번호를 가리킴 
    추가 : 상수풀 https://github.com/devetude/Java-Interview-QnA

19. 스프링 IOC가 무엇인가요? (보충))
    IOC란 제어의 역전으로, 제어권을 스프링에게 위임하여 스프링이 만들어둔 객체를 주입한다
    스프링이 모든 의존성 객체를 스프링이 실행될 때 만들어두고 필요한곳에 주입시켜준다. 
    그래서 bean 들은 싱글턴 패턴의 특징을 가진다.
    그렇게 제어의 흐름을 사용자가 컨트롤하는게 아니고 스프링에게 맡겨 작업을 처리한다.
    IOC를 구현하는 방법중 DI 가 있다.
    => 내가 new로 객체만드는게 아니고 스프링이 필요할때 지가 알아서 만든다
    출처:http://cofived.tistory.com/39

20. OOP와 AOP에 대한 차이를 설명해주세요.
    OOP : 모든 데이터를 오브젝트로 취급하여 프로그래밍 하는 방법, 
    독립적으로 사용하거나 부품으로 사용하므로 재사용성 및 결합 가능
        특징
        1) 캡슐화 (Encapsulation)
        - 사용하고자하는 자료,로직,동작을 하나의 단위(함수)로 묶는 것이다.
        2) 은닉화 (Data Hiding)
        - 외부에 필요한 정보만 공개하고 나머지의 정보는 숨긴다.
        3) 다형성 (Polymorphism)
        - 호출하는 객체에 따라 다른 동작을 하는 기능이다. (가상함수 재정의)
        4) 상속성 (Inheritance)
        - 이미 만들어진 클래스를 파생시켜 새로운 클래스를 만들수 있는 기법이다.
        5) 재사용성 (Reusability)
        - 기존에 만들어진 객체를 다른 프로젝트나 필요한 부분에 그대로 가져다 재사용하는 것이다.
        출처: http://godkyu.tistory.com/11
    AOP : 관점지향, 코드 밖에서 설정 된다, ex)logger 

21. POJO가 무엇인가요?
    => setter, getter로 이루어진 Java bean
    => 별도의 API가 필요하지 않은 일반적인 자바코드를 이용해서 개발 가능하다.

22. Annotation이란?
    => 주석처럼 코드에 단다. 그러나 클래스에 의미를 부여하거나 기능을 주입 할 수 있다. 
    build-in annotation, meta annotation, custom annotation이 있다.

## JS
1. 클로저에 대해 설명해주세요.
    => Closure(클로저)는 두 개의 함수로 만들어진 환경 으로 이루어진 특별한 객체의 한 종류
    => 함수 내부에 작성된 함수
    => 사이드 이펙트(무언가를 행할때 발생) 제어하기, private 변수 생성하기 목적으로 사용
참고: https://medium.com/@khwsc1/%EB%B2%88%EC%97%AD-%EC%9E%90%EB%B0%94%EC%8A%A4%ED%81%AC%EB%A6%BD%ED%8A%B8-%EC%8A%A4%EC%BD%94%ED%94%84%EC%99%80-%ED%81%B4%EB%A1%9C%EC%A0%80-javascript-scope-and-closures-8d402c976d19

2. 변수스코프체인에 대해 아시나요?
    스코프란
    => 유효범위, 전역과 지역이 있다.
    참고 : http://www.nextree.co.kr/p7363/

3. 전역변수를 함수 내부에서 사용하면 성능상 이슈가 발생하는데 그 이유와 해결책에 대해 설명해주세요.
    => 지역변수에 먼저 접근 후 없으면 전역변수에 접근하기때문에 지역변수보다 느리다.
    또한 가비지 컬렉터가 제대로 스윕을 못해서 메모리 누수가 발생할 수 있다.
    => 해결책 : 지역변수를 쓴다.

4. 자바스크립트에서 클래스는 어떻게 사용하나요?
    => function을 class로서 사용한다.
    => 리터럴방식, 함수방식, 프로토타입 방식이 있다.
    => 클래스 인스턴스를 생성해야만 클래스에 들어있는 함수들의 내부기능을 사용할 수 있다.
5. 호이스팅이란?
    => 변수 선언문을 끌어올린다 라는 뜻
    => 함수 선언문 방식만 호이스팅 가능 

6. 자바스크립트 OOP
    => https://developer.mozilla.org/ko/docs/Web/JavaScript/Introduction_to_Object-Oriented_JavaScript

--Network

1. 데드락에 대해서 설명하시오.

2. 데드락 4대요소에 대해 설명하시오.
    => 상호배제(Mutual exclusion) : 프로세스들이 필요로 하는 자원에 대해 배타적인 통제권을 요구한다.
        점유대기(Hold and wait) : 프로세스가 할당된 자원을 가진 상태에서 다른 자원을 기다린다.
        비선점(No preemption) : 프로세스가 어떤 자원의 사용을 끝낼 때까지 그 자원을 뺏을 수 없다.
        순환대기(Circular wait) : 각 프로세스는 순환적으로 다음 프로세스가 요구하는 자원을 가지고 있다.
    출처 : https://blog.lael.be/post/1304

3. 멀티 스레드 환경에서의 주의사항을 설명해주세요.
    => 공유 자원 관리
    => 동기화 작업 필요 그러나 데드락 주의

4. 사용자 수준 스레드와 커널 수준 스레드의 차이를 설명해주세요.

## DB
1. 디비 풀은 왜 쓰나요?
    => 빠른 할당을 위해
    => 커넥션풀 : DB와 연결된 커넥션을 미리 만들어서 풀(pool)속에 저장해두고있다가 필요할 때 쓰는 것

2. 디비 실시간 통신과 디비풀 이용시의 차이가 무엇인가요?
    => 실시간 통신은 요청을 할 때마다 매번 드라이버 로드하고 커넥션 객체 생성 후 연결 종료한다
    => 커넥션풀은 동시접속자 수가 가질 수 있는 커넥션을 하나로 모아두고 관리한다. 
    => 커넥션 생성하고 닫는 시간이 소모되지 않기 때문에 어플리케이션 속도 빨라지며, 한번에 생성될 수 있는 커넥션 수를
    제어하기 때문에 동시 접속자 수가 몰려도 쉽게 웹이 다운되지 않는다.
    풀 이상으로 접속자가 많아지면 해당 클라는 대기가 되고 대기하고 있는 순서대로 커넥션이 제공된다.

3. SQL에서 left join에 대해 설명하시오.

4. RDBMS와 NoSQL의 차이는?
    RDBMS : 유연한 쿼리 가능하지만 쿼리비용 높으며 트래픽 많은 상황에선 확장성 떨어진다.
    NoSQL : 최초 테이블 생성시 데이터간의 관계를 정의하지 않는다. 대용량 가능, 분산형 구조, 데이터를 저장만 하므로 key, value 만 있고
            put, get 만 지원한다.
5. index에 대한 설명과 장/단점으로 무엇이 있나요.
    index란 : RDBMS에서 검색속도를 높이기 위해 사용하는 기술, 일종의 색인
    장단점 : https://lalwr.blogspot.com/2016/02/db-index.html (보충)

6. 몽고DB의 특성에 대해 설명해주세요.
    => http://dev.youngkyu.kr/22

7. SQL Injection은 무엇인가요?

8. ACID에 대해 설명해주세요. (Atomic, Consistency, Isolation, Durability)

9. 1차 정규화, 2차 정규화, 3차 정규화, BCNF에 대해 설명해주세요.
    => 정규화 : 논리적 데이터베이스 설계에 있어서 테이블들을 구조화하는 기법 중 하나
        자료의 손실이나 불필요한 정보의 도입 없이 데이터의 일관성 및 데이터 중복을 최소화하고 최대의 데이터 안정성 확보를 위한 안정적 자료구조로 변환하기 위해서 하나의 테이블을 둘 이상으로 분리하는 작업
        제1정규형(1NF) : 테이블의 각 셀의 값은 단일값을 가진다.
        제2정규형(2NF) : 주키가 합성키며 부분종속이 존재할 경우 2차 정규형의 대상이 된다.
        제3정규형(3NF) : 비주키 속성 간에 발생하는 함수적 종속(이전종속)이 발생하면 3차 정규형의 대상이 된다.
    출처: http://myeonguni.tistory.com/m/1496

10. DB Nomalization(정규화)의 목적은?
    저장 공간 최소화
    데이터 무결성 유지
    자료구조의 안정성 최대화
    
## ETC
1. url에 www.naver.com을 입력했다. 일어나는 현상에 대해 아는대로 설명하라.
    브라우저에서 주소창에 url 입력시 어떤일이 일어나는가
    브라우저의 주소창에 url 입력
    브라우저 캐시에서 DNS 레코드를 확인하여 IP주소를 찾음 (없다면 DNS resolver를 통해 IP주소를 알아냄)
    브라우저가 서버와 TCP 연결을 시작함
    브라우저가 웹 서버에 HTTP 요청을 보냄
    서버가 요청을 처리하고 응담을 되돌려보냄
    브라우저는 서버가 보낸 HTML 내용을 표시
    => http://owlgwang.tistory.com/1

2. Serialize와 json의 상관관계에 대해 설명하시오.

    직렬화(Serialize)
    자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용할 수 있도록 byte 형태로 데이터를 변환하는 기술.
    JVM(Java Virtual Machine 이하 JVM)의 메모리에 상주(힙 또는 스택)되어 있는 객체 데이터를 바이트 형태로 변환하는 기술

3. 스레드풀에 대해 설명. 왜 쓰는지. 무엇인지. 
    => 스레드를 사용할 때 마다 하나씩 만들기보다 미리 먼저 많이 만들어두는 것
    => 프로그램 성능저하 방지 및 다수의 사용자 요청 처리를 위해 사용
    추가: http://limkydev.tistory.com/55

4. Serialize로 데이터를 통신할 때 문제점에 대해 설명하시오.

5. call by value와 call by reference의 차이에 대해 설명하시오.
    => https://github.com/devetude/Java-Interview-QnA#q17-%EC%9E%90%EB%B0%94%EC%9D%98-call-by-value-call-by-reference%EC%97%90-%EB%8C%80%ED%95%B4%EC%84%9C-%EC%98%88%EB%A5%BC-%EB%93%A4%EC%96%B4-%EC%84%A4%EB%AA%85%ED%95%98%EC%8B%9C%EC%98%A4

6. 개방폐쇄 원칙에 대해 구체적으로 설명해보시오.

7. 해시함수 sha-1에 대해 설명하시오.

8. DI (Dependency Injection)에 대해 설명하시오.
    => 객체간의 의존관계를 개발자가 설정하는게 아니고 스프링컨테이너가 주입시켜준다. 
    (의존관계란 Animal()은 Cat()에 의존한다 뭐 그런것)
    B가 바뀌면 A도 바뀌는걸 의존관계라고 한다.

9. DAO DTO에 대해 설명하시오.

10. MVC 패턴에 대해 설명하시오.

11. 디자인 패턴 중 Factory패턴과 Templete패턴에 대해 구체적 예를 들어 설명하시오.

12. 프레임워크와 라이브러리의 차이는 무엇인가요?
    => 프레임워크 : 뼈대, 틀, 내가 맞추는 것
    => 라이브러리 : 도구, 내가 사용하는것 

13. 자바와 자바스크립트 차이를 설명해주세요.
    
14. 깊은 카피와 얕은 카피에 대해 설명해주세요.

15. 컴파일러와 인터프리터의 차이는 무엇인가요?

16. HashTable의 충돌 해결 방법을 설명해주세요.

17. 대칭키/비대칭키 암호화 차이
    => 대칭키 : 암복호화 해제 키가 같다
    비대칭키 : 암복호화 해제 키 다름
    
18. 분산락이란 무엇인가요?

## Etc2
1. Typescript 특징
    MS 에서 만든 javascript로 컴파일되는 언어, 클래스, 모듈 및 인터페이스를 제공한다. 
    대규모 응용 프로그램 적용이 가능하다.
2. React
3. Redux란?
    => 어플리케이션 클라이언트 쪽 state를 관리하기위한 거대한 이벤트 루프
    액션 = 이벤트, 리듀서 = 이벤트에 대한 반응
    출처: https://voidsatisfaction.github.io/2017/02/24/what-is-redux/