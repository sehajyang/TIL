# [스프링부트 개념과 활용](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/)

본 문서는 위의 강좌를 공부하며 정리한 것 입니다.

목차

* 스프링부트 프로젝트 구조

* 스프링부트 원리
  * 의존성 관리 이해 및 응용
  * 자동설정 이해
  * 내장 웹 이해
  * 스프링부트 원리 정리
  
* 스프링부트 활용
  * SpringApplication
  * 외부설정
  * 프로파일
  * 로깅
  * 테스트
  * SpringBoot-Devtools

* 스프링 웹 MVC

* 스프링 데이터

* 스프링 시큐리티

* 스프링 REST 클라이언트

* 스프링부트 운영
  * 스프링부트 Actuator
  
 
 <hr>

## 스프링부트 프로젝트 구조

[Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#using-boot-structuring-your-code)

* Maven Java 프로젝트의 구조와 기본적으로 동일
    * src/main/java 아래에 소스코드
    * resource(classPath root)하위 항목을 다 참조할 수 있다.
    * test/java/resource에는 테스트와 관련된 리소스를 넣을 수 있다.

* 스프링부트에서 추천하고 있는 클래스 위치 => Main Application에 SpringBootApplication을 위치시키는게 좋다.
    * 컴포넌트 스캔 때문에 최상위 패키지에 위치시키는게 좋음

 
## 스프링부트 원리

### 의존성 관리 이해 및 응용

* 스프링부트가 제공하는 의존성 관리 기능(dependency management 기능) => 버전을 명시하지 않아도 된다, 관리해야 할 의존성 수가 줄어든다.
* springboot dependencies가 있고 그 아래 springboot starter <parent> pom 가 있다.
* springboot dependencies pom엔 최상위에 버전에 대한 명시가 되어있다.
* 최상위엔 springboot starter 말고도 다른 설정(java version)이 많으므로 굳이 그곳에 직접 dependencies를 추가하지 않는게 좋다.

 
*문제시 삭제하겠습니다*
  
