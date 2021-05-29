# 9. try-finally 보단 try-with-resource 를 사용하라

Created: 2021년 3월 21일
Created by: Seha Jyang

```java
static String firstLineOfFile(String path, String defaultVal) {
	try(BufferedReader br = new BufferedReader(new FileReader(path)) {
		return br.readLine();
	}catch (IOException e) {
		return defaultVal;
	}
}
```

꼭 회수해야 하는 자원을 다룰 땐 try with resources 를 사용하자. 정확하고 쉽게 자원을 회수할 수 있다.

코드가 더 짧고 분명해지며 예외정보도 훨씬 유용하다.