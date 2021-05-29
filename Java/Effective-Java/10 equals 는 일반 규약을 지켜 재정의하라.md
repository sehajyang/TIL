# 10. equals 는 일반 규약을 지켜 재정의하라

Created: 2021년 3월 21일
Created by: Seha Jyang

다음의 상황중 하나에 해당한다면 재정의하지 않는게 좋다.

- 값을 표현하는 것이 아니라 **동작하는 개체를 표현하는 클래스인 경우**ㅔ
    - 예를 들어 Thread 클래스가 있을 때, Object의 equals 메서드로도 충분하다.
    - 인스턴스가 가지는 값보다 동작하는 개체임을 나타내는 것이 더 중요하다.
- **논리적 동치성(logical equality)을 검사할 필요가 없는 경우**
    - 예를 들어서 두 개의 Random 객체가 같은 난수열을 만드는지 확인하는 것은 의미가 없다.
- **private이나 패키지 전용 클래스**라서 클래스의 equals 메서드가 절대 호출되지 않아야하는 경우
    - 이런 경우에는 equals 메서드를 반드시 오버라이딩해서 호출되지 않도록 막아야 한다. [[출처]](https://madplay.github.io/post/obey-the-general-contract-when-overriding-equals)

재정의 해야 할때

- 객체 아이덴티티가 아니라 논리적 동치성을 확인해야 할때

equals 메서드를 재정의 할 때는 반드시 일반규약을 따라야 한다.

- 반사성(reflexivity)
    - 객체는 자기 자신과 같아야 한다.
    - null 이 아닌 모든 참조값 x 에 대해 x.equals(x) 는 true 다
- 대칭성(symmetry)
    - 두 객체는 서로에 대한 동치 여부에 똑같이 답해야 한다.
    - null이 아닌 모든 참조 값 x, y에 대해 x.equals(y)가 true면, y.equals(x)도 true다.
- 추이성(transitivity)
    - 1객체= 2객체 이며 2객체=3객체 면 1객체 =3객체 임
    - null이 아닌 모든 참조 값 x, y, z에 대해 x.equals(y)가 true이고, y.equals(z)가 true 이면, x.equals(z)도 true다.
- 일관성(consistency)
    - null이 아닌 모든 참조 값 x, y에 대해 x.equals(y)를 반복해서 호출하면 항상 true를 반환하거나 항상 false를 반환한다.
- null 이 아닏.
    - null 이 아닌 모든 참조값 x 에 대해 x.equals(null) 은 false 다.

*WIP*