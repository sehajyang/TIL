# 60. 정확한 답이 필요하다면 float와 double은 피하라

Created: 2021년 5월 23일
Created by: Seha Jyang

float와 double은 근사치로 계산하도록 설계되었으므로 정확한 결과가 필요할 땐 사용하면 안되며 **float와 double 타입은 특히 금융 관련 계산과는 맞지 않는다.**

```java
print(1.03-0.42) // expect: 0.61, actual: 0.61000000000001
print(1.00 - 9 * 0.10) // expect : 0.1, actual: 0.099999999998
```

**금융 계산엔 `BigDecimal`, int혹은 long을 사용해야 한다**

하지만 BigDecimal 는 기본 타입보다 쓰기가 불편하고 느리다는 단점이 있다.

BigDecimal의 대안으로 Int, long을 쓸 수도 있지만 다룰수 있는 값의 크기가 제한되고 소수점을 직접 관리해야 한다.

## 정리

정확한 답이 필요한 계산엔 float나 double을 피하라. 코딩시의 불편함이나 성능저하를 신경쓰지 않겠다면BigDecimal을 사용하고 여덟가지 반올림 모드를 사용해서 반올림을 완벽히 제어하라.

반면, 성능이 중요하고 소수점을 직접 추적할수있고 숫자가 크지 않다면 int, long을 사용하라. 숫자를 아홉자리 십진수로 표현할 수 있다면 int를 사용하고 열여덟자리 십진수로 표현할 수 있다면 long을 사용하라 열여덟자리를 넘어가면 BigDecimal을 사용해야 한다.