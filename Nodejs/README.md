## Node.js 란 

공식 홈페이지의 설명은 이렇다.
```
Node.js® is a JavaScript runtime built on Chrome's V8 JavaScript engine.
```
Node.js는 Chrome의 V8 자바 스크립트 엔진에 기반한 자바 스크립트 런타임 이다.

###  Node.js 특징

* 브라우저 밖에서 자바스크립트 코드를 실행할 수 있다.
* 크롬에서 쓰는 V8 엔진을 사용한다.
* 이벤트 기반의 비동기  I/O 프레임워크
  * 발생된 이벤트는 Event Loop(single thread)가 처리한다.
  * 간단한 이벤트는 EventLoop가 아닌 다른 Non-blocking-Worker에게 처리
  * 일 다하면(완료된 이벤트) EventLoop에게 리턴 => 이벤트 기반의 framework기 때문
  * Worker는 콜백함수를 호출함으로써 EventLoop에게 알려줌

속도가 빠른 대신 SingleThread므로 코어를 1개만 쓴다.

##### 요약하자면
```
 Node의 콜백함수는 비동기로 돌아가며, 서버가 동작될 때 까지 기다리는게 아니고

함수보다 다른 코드가 먼저 실행된다.

동기적인거 먼저 실행되고 그 뒤에 비 동기적인 콜백함수가 실행된다!
```




##### Blocking, Non-Blocking 차이? 

* Blocking

   ```
   Read/Write 이벤트 발생시 이벤트 끝날 때 까지 해당 모듈을 점유 및 메모리 소비
   요청한 I/O가 완료 될 때 까지 해당 쓰레드를 대기모드로 전환
   요청한 I/O가 완료되면 유저코드를 실행한다.
   ```
   
* Non-Blocking
	```
	Blocking의 비효율을 극복하고자 만들었다.
	Read/Write 이벤트 시작하자마자 다른 작업 하도록 준비상태가 된다. 
	주체는 커널이 되며, 유저 프로세스는 통지가 오면 그 때 I/O 처리를 한다.
	```



##### 비동기, 동기 차이?
```
비동기 => 여러개 이벤트를 동시에 병렬 진행 (다중 쓰레드)
동기 => 이벤트 들어왔을 때 바로 응답
```



### Express.js

Node.js 에서 가장 많이 사용하는 웹 어플리케이션 프레임워크



##### 특징

* 어플리케이션
* 미들웨어
* 라우팅
* 요청/응답 객체






<hr>
위 글은 아래의 강의 를 정리 한 것 입니다.

[Node.js 기반의 REST API 서버 개발](https://tacademy.sktechx.com/live/player/onlineLectureDetail.action?seq=134)

[Node.js 웹개발로 알아보는 백엔드 자바스크립트의 이해](https://www.inflearn.com/course/node-js-%EC%9B%B9%EA%B0%9C%EB%B0%9C/)

=> [실습 repo](https://github.com/sehajyang/Node.js-Study)



