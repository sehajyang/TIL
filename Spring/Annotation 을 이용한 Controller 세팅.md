### Annotation 을 이용한 Controller 세팅

##### 1. XML 세팅

<context:component-scan base-package="" />

##### 2. 종류

* @Controller : 대상 컨트롤러 클래스의 위에 선언

* @RequestMapping : 처리할 주소(value) 및 HTTP METHOD 지정(method)

  ex) @RequestMapping(value="/index.spring", method=RequestMethod.GET)

* @RequestParam("parameterName") : 요청 파라미터를 인자값으로 선언시 사용

* @ModelAttribute("commandName") : 인자값에 선언시 요청 파라미터들을 받는 커맨드 객체로 사용, 메소드 위에 선언시 뷰에 세팅될 커맨드객체로 사용

* @SessionAttributes("commandName") : 클래스 위에 선언하여 세션에 커맨드 객체 저장SessionStatus 를 메소드에 인자값으로 선언하여 sessionStatus.setComplete() 를 통해

  세션에서 최종적으로 객체 삭제가 가능

##### 3.Controller 클래스의 메소드 선언

* 인자타입(parameter type)으로 사용 가능한 타입
  * HttpServletRequest, HttpServletResponse, HttpSession
  *  java.util.Locale : 현재 지역정보
  *  InputStream, Reader : 요청 컨텐츠에 직접 접근
  *  OutputStream, Writer : 응답 컨텐츠로 사용
  *  @RequestParam 을 이용한 파라미터 명시
  *  Map, ModelMap : 뷰에 전달할 데이터 저장용
  * Command Class : @ModelAttribute 를 사용시 이름이 지정되고, 지정하지 않으면 클래스명이 지정됨(앞글자 소문자)
  * Errors, BindingResult : 커맨드 클래스 바로 뒤에 위치해야함. 유효성 체크 위해 사용
  * SessionStatus : 폼 처리 완료시 호출하기 위해 사용 @SessionAttributes 와 같이 사용

* 리턴타입(return type)으로 사용 가능한 타입
  * ModelAndView : 일반적인 컨트롤러 메소드의 리턴객체
  * Map : 뷰에 전달할 데이터의 집합체, view 이름은 요청 URL로 결정(RequestToViewNameTranslator)
  * String : view 이름으로 처리
  * void : 직접 응답 처리시

 
