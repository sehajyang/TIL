# 16. public 클래스에선 public 필드가 아닌 접근자 메서드를 사용하라

Created: 2021년 3월 25일
Created by: Seha Jyang

public 클래스는 절대 가변 필드를 직접 노출해선 안 된다.

불변 필드라면 노출해도 덜 위험하지만 완전히 안심할 순 없다.

하지만 Pakage-private 클래스나 Private 중첩 클래스에선 종종 필드를 노출하는게 나을 때도 있다.