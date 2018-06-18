## Spring MVC

### 구성요소

1. DispatcherServlet : 클라이언트 요청을 받아서, 컨트롤러에 요청을 전달하고 컨트롤러가 리턴한 결과 값을  View 에 전달하여 응답을 생성한다. (Struts 의 ActionServlet)
2. HandlerMapping : 클라이언트 요청 URL 을 어떤 컨트롤러가 처리할지를 결정한다. (struts-config.xml 의 역할)
3. Hancler Adapter : Dispatcher Servlet 처리요청 변환해 컨트롤러에 전달하고, 응답결과를  Dispatcher Servlet 이 요구하는 형식으로 변환한다.
4. Controller : 요청을 처리하고 결과를 리턴한다 (Struts 의 Action)
                DispatcherServlet에 의해 호출돼 사용자 Request 전달받고 해당 요청 처리하는 서비스객체를 주입(DI) 받아, 그 서비스 객체에 
                처리 위임 후 처리 결과 및 화면에 대한 정보를 DispatcherServlet에게 반환한다

5. ModelAndView : 컨트롤러가 처리한 결과 정보 및 뷰에 관련한 정보를 담는 객체 (struts의 forward 기능 포함)
6. ViewResolver : 컨트롤러 처리 결과를 생성할 뷰를 결정
7. View : 컨트롤러 처리 결과 화면을 생성하는 객체


참고 : [Spring 4.0 프로그래밍](http://www.aladin.co.kr/shop/wproduct.aspx?ISBN=8980782713)
