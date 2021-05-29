# 36. 비트 필드 대신 EnumSet을 사용하라

Created: 2021년 5월 2일
Created by: Seha Jyang

- 비트필드
    - `A|B`
- int로 되어있었는데 long이 결과로 나올경우 타입 변경 해야됨
- 그럴바엔 `Set<enum>dl whgek.`
    - `EnumSet.of(E1, E2 ...)`
    - 자바 9엔 immuatable EnumSet이 없다.
    - 대신 `Collections.unmodifiableSet`으로 EnumSet을 감쌀 수 있다.