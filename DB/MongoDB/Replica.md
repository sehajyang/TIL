# Replica

Created: 2021년 6월 27일
Created by: Seha Jyang

## replica 작동 방식

replica set은 oplog와 heartbeat 의 기본적인 메커니즘에 의존한다. oplog로 데이터 복제를 하며, heartbeat로 health check를 한다.

### oplog

oplog는 capped 컬렉션으로 모든 복제 노드에서 local라는 db내에 있고 데이터에 대한 모든 수정사항을 기록한다. 각 오피로그 항목은 BSON 타임스탬프로 인식하고 모든 세컨더리는 그 타임스탬프를 이용해 적용할 최신 항목을 추적한다.

## 커밋과 롤백

프라이머리 노드에 대해 쓰기시 과반수의 노드에 복제되기 전까진 uncommit 으로 여겨진다.

uncommit 데이터는 롤백시 과반수의 노드에 복제된 적 없는 쓰기는 모두 취소된다. oplog에서 삭제되며 데이터 파일 컬렉션도 이전 상태로 되돌아간다. 취소된 쓰기는 해당 노드 데이터 경로의 rollback 서브디렉터리에 저장된다. 복구해야 할 경우 bsondump 로 BSON파일을 검사하고 mongorestore로 복구할 수 있다.