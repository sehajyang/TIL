# 14. Comparable 을 구현할지 고려하라

Created: 2021년 3월 21일
Created by: Seha Jyang

**알파벳, 숫자 같이 순서를 고려해야하는 값 클래스를 작성한다면 반드시 Comparable 인터페이스를 구현하자.**

- compareTo 는 단순 동치성 비교에 더해 순서까지 비교할 수 있으며 제네릭 하다.
- Comparable 을 구현했다는 것은 그 클래스의 인스턴스들에는 자연적인 순서가 있고 `Arrays.sort(a)` 로 손쉽게 정렬할 수 있다.

```java
public interface Comparable<T> {
	int compareTo(T t);
}
```

### compareTo 규약

1. 매개변수 인스턴스와 자신의 인스턴스를 비교하도록 해야 한다.

2. 모든 x,y에 대해 sgn(x.compareTo(y)) == -sgn(y.compareTo(x))여야 한다.

3. x.compareTo(y) > 0 && y.compareTo(z) > 0 이면 x.compareTo(z) > 0이다. 추이성을 보장해야 한다.

4. x.compareTo(y) == 0 이면 모든 z에 대해 sgn(x.compareTo(z)) == sgn(y.compareTo(z)) 이다.

5. (x.compareTo(y) == 0) == (x.equals(y))여야 한다. 이 규약을 지키지 않는 모든 클래스는 그 사실을 명시해야 한다.

### 객체 참조 필드가 하나뿐인 비교자

```java
public final class InsensitiveString implements Comparable<InsensitiveString> {
	public int compareTo(InsensitiveString is) {
		return String.CASE_INSENSITIVE_ORDER.compare(s, is.s);
	}
}
```

박싱된 기본 타입 클래스에는 새로 추가된 static method 인 `compare` 가 있으므로 `<, >` 같은걸 쓰지말자.

### 기본 타입 필드가 여럿일 때의 비교자

```java
public int compareTo(PhoneNumber pn) {
	int result = Short.compare(areaCode, pn.areaCode);
	if (result == 0) {
		result = Short.compare(prefix, pn.prefix);
		if (result == 0) {
			result = Short.compare(lineNum, pn.lineNum);
		}
		return result;
	}
}
```

자바 8 에선 Comparator 인터페이스가 comparator 생성자 메서드와 팀을 꾸려 메서드 연쇄 방식으로 비교자를 생성할 수 있게 되었다. 하지만 약간 성능저하가 있다.

### 비교자 생성 메서드를 활용한 비교자

```java
private static final Comparator<PhoneNumber> COMPARATOR = comparingInt(
(PhoneNumber pn) -> pn.areaCode).thenComparingInt(pn -> pn.prefix)
																.thenComparingInt(pn -> pn.lineNum);

public int compareTo(PhoneNumber pn) {
	return COMPARATOR.compare(this, pn);
}
```

가장 좋은 방법