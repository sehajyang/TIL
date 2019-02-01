# Springboot auto build 안되는 문제

최근 Eclipse에서 Intelli J로 갈아탔는데 java 파일 수정시 auto build가 되지 않는 문제가 발생했다.

## 실행 환경
OS: win10
IDE : Intelli J 2018.3

### 해결 방법

1. build.gradle에 의존성 추가
~~~gradle
compile("org.springframework.boot:spring-boot-devtools")
~~~

2. application.properties 사용할 경우
~~~
spring.devtools.livereload.enabled=true
~~~

3. Intelli J Settings > Compiler 검색 > Buld Project automatically 체크  
4. 왼쪽 shift 두번 누름 > Registry 검색> compiler.automake.allow.when.app.running 체크  
5. Run SpringbootApplication (Gradle일 경우 bootRun인데 이거 아니고  SpringbootApplication으로 실행해야됨)

