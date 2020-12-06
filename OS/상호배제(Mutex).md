# 상호배제(Mutex)

Created: 2020년 11월 22일

## 뮤텍스란?

“Mutual Exclusion 으로 상호배제라고도 한다. Critical Section을 가진 쓰레드들의 Runnig Time이 서로 겹치지 않게 각각 단독으로 실행되게 하는 기술입니다. 다중 프로세스들의 공유 리소스에 대한 접근을 조율하기 위해 locking과 unlocking을 사용합니다.

글로발 자원공유는 다음과 같은문제가 발생할수있다

- (경쟁상태)상호배제의 필요
    - 공유될수없는 자원을 두개이상의 프로세스에서 접근하려할때 임계영역(크리티컬 섹션으로 자원을 보호)을 설정해서 해당 자원은 한 프로세스만 접근할수 있도록 하는것이(상호배제) 필요
- 데드락
    - 각각의 프로세스가 상대방의 리소스를 요청하면서 자기자신의 리소스는 릴리즈하지 않아 교착상태에 빠진것
        - 리커버 시키던지 하는 방법으로 해결
- 기아상태
    - 여러개의 프로세스가 같은 자원에 공유하려할때 자원 분배가 불균형하게 이뤄져 한 프로세스가 자원에 계속해서 무한정 접근하지 못하게 되는 상태

공유자원은 race condition 이 생긴다

- race condition
    - 협력관계에 있는 두개이상의 프로세스 혹은 쓰레드에서 발생할수있다.
    - global data에 대한 sharing 에 대한문제 → 원하지 않는 결과가 나옴(nondeterministic) → 같은 데이터를 변경하려고 경쟁해서 발생
    - 임계영역(critical section) 설정으로 해결

동시성의 해결 중 하나 : 

- atomic한 ops을 정의함

## Atomic Ops

- 어떤 function을 atomic하게 함
- multi processor에서 가능
- 하드웨어 레벨에서 지원
    - test and set, fetch and add, compare and sweep, load link store conditional
    - 두개의 ops를 하나의 명령어로 처리
    - 이걸 이용해서 semaphore를 할수있음
- 소프트웨어 솔루션
    - ciritical section
- 단점 : 사용하려는 리소스가 critical section에 있으면 사용가능할떄까지 계속 blocking 되어야함, 데드락과 기아상태 발생할수있음

### mutual exclusion 구현

compare and sweep

![%E1%84%89%E1%85%A1%E1%86%BC%E1%84%92%E1%85%A9%E1%84%87%E1%85%A2%E1%84%8C%E1%85%A6(Mutex)%200f57b18e7bbc4588a72417c4bb59f1f8/Untitled.png](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%92%E1%85%A9%E1%84%87%E1%85%A2%E1%84%8C%E1%85%A6(Mutex)%200f57b18e7bbc4588a72417c4bb59f1f8/Untitled.png)

## Semaphore

프로그래밍 환경에서 커먼 데이터에 대한 접근을 제어하기 위한 변수이다

### Ops

- V → 증가, 다쓰고 반환(signal)
- P → semaphore 감소(wait)

### 종류

- binary semaphore → 0(lock), 1
- counting semaphore

### 문제

- 만약 프로그램의 PV Ops가 흩어져있으면 전체적인 효과를 판단하기 힘들다
- 이 문제를 해결하기위해 나온게 [monitor]()

### semaphore로 critical section 구현

![%E1%84%89%E1%85%A1%E1%86%BC%E1%84%92%E1%85%A9%E1%84%87%E1%85%A2%E1%84%8C%E1%85%A6(Mutex)%200f57b18e7bbc4588a72417c4bb59f1f8/Untitled%201.png](%E1%84%89%E1%85%A1%E1%86%BC%E1%84%92%E1%85%A9%E1%84%87%E1%85%A2%E1%84%8C%E1%85%A6(Mutex)%200f57b18e7bbc4588a72417c4bb59f1f8/Untitled%201.png)

### Producer/Consumer Problem

- 하나이상의 프로듀셔, 하나의 컨슈머가 컨슘
- 하나의 프로듀서 혹은 컨슈머만이 버퍼에 접근할수있음

문제점

- 만약 버퍼가 한정적이라면 프로듀셔는 꽉찬 버퍼에 add할수없거나 empty라면 리소스를 가져올수없음 → empty인데 comsume 하려고 하면 delay혹은 데드락이 발생함
- 두 프로세스간에 synchonization 이 필요함, 상호배제도 필요함

## Monitor

- 하나이상의 프로시저로 구성되어있다
- 초기화 코드가 있다 로컬테이터가있고
- 한번에 하나의 프로세스만 모니터 안에서 실행가능하다
- 모니터 안에서 동기화를 위해 condition 변수가 있다

### Condition

- cwait(c) : process suspend
- csignal(c) : 대기하고있으면 wake up시키지만 대기하는게 없으면 아무것도 안함

## Message Passing

메세지 패싱은 다음과 같은 기능을 제공한다

- 상호배제
- 동기화
- 통신(communication)

가장 일반적인 구조

- 각자 메모리를 갖고있다 → 분산된 형태로 작업가능
- 분산시스템에서도 일반적으로 사용

### 구현

- send(destination, message)
    - 보내는 id, message
- receive(source, message)

둘 사이에 동기화가 존재한다 → 보내기전엔 받을수없다

- blocking send → response올때까지 wait
- non blocking send

일반적으로 send = nonblocking, receive = blocking 하는 조합을 많이 쓴다.

### Addressing

- direct addressing
- indirect addressing
    - mailbox → 한번에 한 프로세스만 접근 가능

**message format**

message type, destination id, source id, length, contents(body) 등으로 이뤄져있음