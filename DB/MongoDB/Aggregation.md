# Aggregation

Created: 2021년 6월 26일
Created by: Seha Jyang

집계에 대한 호출은 집계 파이프라인(aggregation pipeline)이 정의한다.

## 집계 파이프라인

각 작업의 출력이 다음 작업의 입력이 된다.

집계 파이프라인 작업엔 다음이 포함된다.

- $project
    - 출력 도큐먼트 상에 배치할 필드를 지정한다.(select)
- $match
    - 처리될 도큐먼트를 선택, find()와 비슷한 역할을 한다.(where, having)
- $limit
    - 다음 단계에 전달될 도큐먼트의 수를 제한한다.
- $skip
    - 지정된 수의 도큐먼트를 건너뛴다.
- $unwind
    - 배열을 확장해 각 배열 항목에 대해 하나의 출력 도큐먼트를 생성한다.(join)
- $group
    - 지정된 키로 도큐먼트를 그룹화한다.(group by)
- $sort
    - 도큐먼트를 정렬한다.
- $geoNear
    - 지리 공간위치 근처의 도큐먼트를 선택한다.
- $out
    - 파이프라인의 결과를 컬렉션에 쓴다.
- $redact
    - 특정 데이터에 대한 접근을 제어한다.

예제

```json
db.products.aggregate([{$match: ...}],[$group: ...],[$sort: ...])
```

### 컬렉션 조인

```json
db.mainCategorySummary.remove({});

db.products.aggregate([
	{$group : {_id:$main_category_id,
							count:{$sum:1}}}
]).forEach(function(doc){
	var category=db.categories.findOne({_id:doc._id});
	if(category != null) {
		doc.category_name = category.name;
	}else {
		doc.category_name = 'not_found'
	}
	db.mainCategorySummary.insert(doc);
})
```

### $out, $project

- `$out`
    - 파이프라인 출력을 자동적으로 컬렉션에 저장할 수 있다

    ```json
    // 파이프라인 결과를 mainCategorySummary컬렉션에 저장
    db.products.aggregate([
    	{$group : { _id : $main_category_id,
    							count = {$sum:1}}},
    	{$out : mainCategorySummary }
    ])
    ```

- `$project`
    - 파이프라인 다음 단계로 전달할 필드를 필터링 할 수 있다.
    - $match는 다음 단계로 전달할 양을 제한할 수 있지만 $project는 다음단계로 전달되는 각 도큐먼트의 크기를제한하는데에 사용할 수 있다.

### $unwind 로 더 빨라진 조인

배열을 확장해 모든 입력 도큐먼트 배열 항목에 대해 하나의 출력 도큐먼트를 생성할 수 있음

서브 쿼리 테이블 as a 같은거

### $group

여러 도큐먼트를 그룹핑함.

다음과 같은 함수가 있다.

- addToSet
    - 고유한 값의 배열을 만든다
- first, last
    - 첫번째, 마지막 값, $sort 를 선행해야 의미가있음
- max, min
    - 그룹의 필드 최대/최소 값
- avg
    - 그룹의 평균 값
- push
    - 그룹의 모든 값의 배열을 리턴, 중복 값 제거 안함
- sum
    - 그룹의 모든 값의 합계

### $match, $sort, $skip, $limit

[query](Query%203ad95471eec44a2aad3b1e9f0c10dd38.md) 함수에서 다룬 함수와 동일하게 동작

### $unwind

배열의 모든 항목에 대해 하나의 출력 도큐먼트를 생성해 배열을 확장한다. 각 배열 항목의 필드뿐만 아니라 주 도큐먼트의 필드도 출력 도큐먼트에 저장한다.

- examples

    ```json
    //query
    db.products.findOne({}, {category_ids : 1})

    //result
    [
      {
        "_id": {"$oid": "4c4b1476238d3b4dd5003982"},
        "category_ids": [
          {"$oid": "6a5b1476238d3b4dd5000048"},
          {"$oid": "6a5b1476238d3b4dd5000049"}
        ]
      }
    ]

    // query
    db.products.aggregate([
    	{$project : {category_ids : 1}},
    	{$unwind : '$category_ids'},
    	{$limit : 2}
    ])

    // result
    [
      {
        "_id": {"$oid": "4c4b1476238d3b4dd5003982"},
        "category_ids": {"$oid": "6a5b1476238d3b4dd5000048"}
      },
      {
        "_id": {"$oid": "4c4b1476238d3b4dd5003982"},
        "category_ids": {"$oid": "6a5b1476238d3b4dd5000049"}
      }
    ]
    ```

### $out

파이프라인의 결과로 새 컬렉션이 만들어지거나 컬렉션이 이미 존재하는경우 컬렉션의 내용을 대체해 기존 인덱스를 유지한다. $out 작업에 어떤 이름을 사용하는지, 실수로 기존 컬렉션을 지우는 경우에 대해 조심하자.

## 기타 집계 기능

### .count(), .distinct()

.distinct() 결과 크기는 16MB로 제한된다.

### 맵리듀스

mongodb의 유연한 집계 기능을 제공하기위한 시도

aggregate보다 훨씬 느리다.

*mongodb in action p.189에 예제가 있다.*

## 집계 파이프라인과 성능

주요 고려사항은 다음과 같다.

- 파이프라인에서 가능한 한 빨리 도큐먼트의 수와 크기를 줄인다.
- 인덱스는 $match, $sort 작업에서만 사용할 수 있고, 사용한 후엔 인덱스를 사용할 수 없다.
- $match, $sort 이외의 연산자를 파이프라인에서 사용한 후엔 인덱스를 사용할 수 없다.
- 샤딩을 사용하는 경우 $match, $project 연산자는 개별 샤드에서 실행된다. 다른 연산자를 사용하면 남아있는 파이프라인이 프라이머리 샤드에서 실행된다.

### 집계 파이프라인 옵션

`aggregatate()` 에 전달가능한 두번째 함수

- `explain()`
    - 파이프라인 실행하고 파이프라인 프로세스 세부 정보를 리턴
- `allowDiskUse`
    - 중간 결과를 위해 디스크 사용
    - 대형 파이프라인 가동중인 경우 만약의 경우에 사용할 수 있도록 하는게 좋음
- `cursor`
    - 초기 배치 크기 지정
    - 많은 양의 데이터를 스트리밍 할 수 있게 해준다