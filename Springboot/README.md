# [스프링부트 개념과 활용](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8/)

본 문서는 위의 강좌를 공부하며 정리한 것 입니다.

목차

* 스프링부트 프로젝트 구조

* 스프링부트 원리
  * 의존성 관리 이해 및 응용
  * 자동설정 이해 및 응용
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

### 자동설정 이해 및 응용

* @EnableAutoConfiguration => @SpringBootconfiguration + @ComponentScan + @EnableAutoConfiguration
* @ComponentScan 으로 읽어온 Bean을 @EnableAutoConfiguration로 추가적인 Bean을 더 읽어온다.
* @ComponentScan은 컴포넌트라는 어노테이션을 가진 클래스들을 스캔해서 Bean으로 등록하는것(SpringbootApplication.java에서 자세히 볼 수 있다)
* lib > springframework > spring-boot-autoconfiguration > META-INF > spring.factories 의 Configure => 이것이 전부 auto configuration이다 
* 결국 @autoConfiguarion도 @Configuration 이다.

강의자료
* @EnableAutoConfiguration (@SpringBootApplication 안에 숨어 있음)
* 빈은 사실 두 단계로 나눠서 읽힘
    * 1단계: @ComponentScan
    * 2단계: @EnableAutoConfiguration
* @ComponentScan
    * @Component
    * @Configuration @Repository @Service @Controller @RestController
* @EnableAutoConfiguration
    * spring.factories
      * org.springframework.boot.autoconfigure.EnableAutoConfiguration
      * @Configuration
      * @ConditionalOnXxxYyyZzz

#### 자동설정 만들기
 * Starter와 AutoConfigure
    * Xxx-Spring-Boot-Autoconfigure로 끝나는 모듈: 자동 설정
    * Xxx-Spring-Boot-Starter 모듈: 필요한 의존성 정의 (하나로 만들고 싶을 때)
    * 구현방법
        * spring-boot-starter xml파일에 필요한 의존성을 추가한다
        * 최상위 패키지 아래에 @Configuration 어노테이션을 사용해 configuration 파일을 작성한다.
        * resource/META-INF/spring.factories에 EnableAutoContiguration옵션을 사용한다 선언하고 읽어들일 옵션을 추가한다.
        ```
        org.springframework.boot.autoconfigure.EnableAutoContiguration=\
        me.sehajyang.SehaCustomContiguration
        ```
        * maven install
    * spirngboot가 bean을 등록하는 페이스는 두가지가 있다
    * component scan 으로 bean을 등록하는게 먼저! 두번째는 autoconfiguration이다
    * 따라서 빈이 중복될 경우 autoconfiguration으로 등록된 빈이 앞의 빈을 덮어씌워버린다(2.1.1이후 버전에선 해결)



 * @ConfigurationProperties



*문제시 삭제하겠습니다*
  
