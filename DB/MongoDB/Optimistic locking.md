# Optimistic locking

Created: 2021년 5월 21일
Created by: Seha Jyang

## 낙관적 잠금

수정한 후에 업데이트 하려 할때 업데이트에 타임스탬프(버전)이 포함되며 그 타임스탬프(버전)가 페이지의 최종 저장 버전보다 더 이전이면 업데이트를 할 수 없다.

이 전략은 여러 사용자가 동시에 페이지를 수정하는것을 가능하게 하며, 사용자가 페이지를 수정하기 위해 lock을 해야하는 다른 동시성 제어보다 낫다.

비관적 잠금을 사용하면 레코드가 트랜잭션에서 처음 액세스 할 때 부터 트랜잭션이 완료될 때 까지 레코드가 잠기므로 그 시간동안 다른 트랜잭션은 액세스 할 수 없게 된다.

### 참고

In order to use optimistic locking, **we need to have an entity including a property with *@Version* annotation**. While using it, each transaction that reads data holds the value of the version property.

Before the transaction wants to make an update, it checks the version property again.

If the value has changed in the meantime an *OptimisticLockException* is thrown. Otherwise, the transaction commits the update and increments a value version propert