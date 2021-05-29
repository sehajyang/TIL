# 24. 멤버 클래스는 되도록 static 으로 만들라

Created: 2021년 4월 4일
Created by: Seha Jyang

- non static 멤버 클래스의 인스턴스는 바깥 클래스의 인스턴스와 연결되고 this를 사용해 바깥 인스턴스의 메서드나 필드를 호출한다.
    - 따라서 바깥 인스턴스와 독립적으로 존재할 수 있다면 static 멤버 클래스로 만들어야한다.
    - non static 멤버 클래스는 바깥 인스턴스 없이 생성할 수 없기 때문이다.
    - 직접 `바깥 인스턴스클래스.new MemverClass()` 를 호출할 경우 non static 멤버 클래스의 인스턴스 안에 만들어져 메모리공간을 차지하고 생성시간도 더 걸린다.
- non static 멤버 클래스는 어뎁터를 정의할 때 자주 쓰인다.
    - 어떤 클래스의 인스턴스를 감싸 마치 다른 클래스의 인스턴스처럼 보이게 하는 뷰로 사용

    ```java
    public class MySet<E> extends AbastractSet<E> {

    	@Override
    	public Iterator<E> iterator() {
    		return new MyIterator();
    	}

    	private class MyIterator implements Iterator<E> {
    		...
    	}
    }
    ```

    **멤버 클래스에서 바깥 인스턴스에 접근할 일이 없다면 무조건 static을 붙여서 정적 멤버 클래스로 만들자**

    - gc가 바깥 클래스의 인스턴스를 수거하지 못하는 메모리 누수가 생길수도 있음

## 정리

nested 클래스는 네가지가 있으며 쓰임이 모두 다르다.

메서드 밖에서도 사용해야하거나, 메서드 안에 정의하기엔 너무 길다면 멤버 클래스로 만든다.

멤버 클래스의 인스턴스 각각이 바깥 인스턴스를 참조한다면 non static으로, 그렇지 않다면 static 으로 만들자.

중첩 클래스가 한 메서드 안에서만 쓰이면서 그 인스턴스를 생성하는 지점이 단 한 곳이고 해당 타입으로 쓰기에 적합한 클래스나 인터페이스가 이미 있다면 익명 클래스로 만들고 그렇지 않으면 지역 클래스로 만들자.