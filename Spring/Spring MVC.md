## Spring MVC

 구성요소

1. DispatcherServlet : 클라이언트 요청을 받아서, 컨트롤러에 요청을 전달하고 컨트롤  러가 리턴한 결과 값을  View 에 전달하여 응답을 생성한다. (Struts 의 ActionServlet)
2. HandlerMapping : 클라이언트 요청 URL 을 어떤 컨트롤러가 처리할지를 결정한다. (struts-config.xml 의 역할)
3. Controller : 요청을 처리하고 결과를 리턴한다 (Struts 의 Action)
4. ModelAndView : 컨트롤러가 처리한 결과 정보 및 뷰에 관련한 정보를 담는 객체 (struts의 forward 기능 포함)
5. ViewResolver : 컨트롤러 처리 결과를 생성할 뷰를 결정
6. View : 컨트롤러 처리 결과 화면을 생성하는 객체