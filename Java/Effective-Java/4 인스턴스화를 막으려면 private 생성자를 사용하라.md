# 4. 인스턴스화를 막으려면 private 생성자를 사용하라

Created: 2021년 3월 1일
Created by: Seha Jyang

```java
public class UtlityClass {
  // 기본 생성자가 만들어지는것을 막는다.
  private UtilityClass() {
    throw new Exception();
  }
}
```

- 이 방법은 상속도 막는다.
    - 모든 생성자는 상위 클래스의 생성자를 호출하게 되는데, 이를 private으로 선언했으니 상위 클래스의 생성자에 접근할 길이 막혀버린다.