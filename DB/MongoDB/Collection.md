# Collection

Created: 2021년 6월 27일
Created by: Seha Jyang

**목차**

---

## Capped Collection

높은 성능 로깅 기능을 위해 설계되었다.

고정된 크기를 갖는다. 

- 도큐먼트 최대 갯수 지정 할 수 있다.

공간이 없으면 가장 오래된 기존 데이터에 새로운 데이터를 덮어씌움

컬렉션 생성시 capped true 옵션으로 생성할 수 있음

도큐먼트 삭제 업데이트 불가능. 오직 추가만 가능

## TTL Collection

- 특정 시간이 경과한 도큐먼트를 expire 시킴
- 생성법

```java
db.reviews.createIndex({time_field:1}, {expireAfterSeconds:3600})
```

이 경우 `time_field` 타입은 `timestamp` 여야 하고 생성 시간이 들어가게 될 것임

현재시간과 `expireAfterSecond` 를 주기적으로 비교해서 동작함

### 제약사항

- `_id` 필드나 이미 다른 인덱스에 사용하고 있는 필드는 TTL인덱스를 가질 수 없다.
- `capped` 컬렉션도 TTL index 못가짐
    - 캡드 컬렉션은 개별 도큐먼트 삭제 x
- 인덱스 필드에 타임스탬프 배열을 갖더라도 복합 TTL 인덱스를 가질 수 없다. 가장 빠를 시점의 타임스탬프에 적용됨

## System Collection

mongo db 내부에서 부분적으로 사용하는 컬렉션

- system.namespace
- system.indexes

replication 에선 캡드 컬렉션을 시스템 컬렉션으로 사용