# Query

Created: 2021년 6월 26일
Created by: Seha Jyang

## 목차

## find, findOne

### find

도큐먼트 리턴, `findOne().limit(1)` 과 같음.

### findOne

조회 결과가 배열이라면 도큐먼트 자연 정렬상(삽입순서) 가장 첫번째 아이템 리턴

## skip, limit

skip과 limit를 함께 사용, 쿼리와 같이 사용할 시 mongo db 가 서버에서 쿼리와 함께 처리(method channig)

데이터가 대량인 경우 skip에 큰 값을 넘겨주면 skip값 만큼 도큐먼트를 스캔해야 하므로 비효율적일수도 있다.

그러니 skip을 생략하고 대신 쿼리에 다음 결괏값이 시작되는 것을 나타내는 범위조건을 추가하는게 더 좋을수도있다.

```json
// using skip
db.docs.find({}).skip(500000).limit(10).sort({date:-1})

// using range context
prev_page_date = new Date(2021,06,26)
db.docs.find({date : {$gt : prev_page_date}}).limit(10).sort({date : -1})
```

## projection

결과에 대해 리턴되는 필드를 제한할 수 있다.

```json
db.product.findOne({"name":"test"}, {_id:1})
```

## 부분 매칭

정규 표현식 사용 가능

```json
db.product.findOne({"name":/^te/})
```

## 특점 범위 질의

`$gt` : ~ 초과

`$lt` : ~ 미만

`$gte` : ~이상

`$lte` : ~이하

```json
db.product.find({'sku': {$gt:9090, $lt:9092}})
```

long, int, double 과 같은 숫자 타입은 범위 쿼리에 대해 타입 동등성(type equivalence)를 가진다.

## 집합 연산자

`$in` 하나라도 있는 경우 리턴

`$all`  모든 아이템이 집합에 있고 배열이 포함된 도큐먼트에서 사용되는 경우 리턴

`$nin` 어떤 아이템도 집합에 없는걸 리턴

in, all은 인덱스를 이용하지만 nin은 못하므로 컬렉션을 스캔해야 한다.

## 부울 연산자

- `$ne`
    - not equal to
    - 키 값이 단일하거나 배열인경우 모두 수행
- `$not`
    - 다른 연산이나 정규 표현식 쿼리로부터 얻은 결과의 여집합을 리턴
- `$or`
    - 두개의 서로 다른 키에 대한 논리합을 리턴
    - 쿼리 셀렉터의 배열을 취하는데, 각 셀렉터는 애드혹 쿼리가 될 수 있고 다른 연산자를 포함할 수도 있다.
- `$and`
    - 질의 셀렉터의 배열을 취한다
    - 하나이상의 키를 갖는 질의 셀렉터는 각 조건을 AND로 붂는 것으로 해석한다.

    ```json
    // a나 b중 하나로 태그되고 c, d중 하나로 태그된 모든 상품을 검색
    db.product.find({
    	$and : [
    		{
    			tag: {$in:['a', 'b']}
    		},
    		{
    			tag: {$in:['c', 'd']}
    		}
    	]
    })
    ```

- `$nor`
- `$exists`
    - 도큐먼트가 특정 키를 가지고 있는지 질의할때 사용

    ```json
    // 리뷰가 있는 상품 모두 조회
    db.products.find({'review': {$exists, true}}
    ```

## 서브 도큐먼트 매칭

관련된 키를 `.` 로 구분한다.

```json
db.products.find({'details.manufacturer.id':432})
```

객체 전체에 대해도 질의할 수 있다.

하지만 이런 형식의 질의는 엄격하게 비교되므로 키의 순서가 중요하다. 만약 키의 순서가 바뀌면 찾지 못한다.

```json
db.products.find({'details': {'color':'blue', 'size': 'm'}}) => o
db.products.find({'details': {'size': 'm', 'color':'blue'}}) => x
```

## array

- `**$elemMatch**`

    제공된 모든 조건이 동일한 하위 도큐먼트에 있는 경우 일치

    **여러개의 조건을 하나의 서브 도큐먼트에 대해 제한할때 사용**

    서브 도큐먼트에서 두개 이상의 속성이 매치되는 것을 찾는 경우 사용

- `$size`

배열 하위 도큐먼트의 크기가 제공된 리터럴 값과 같으면 일치

## 정규 표현식

- `$regex`
- `$options`

    ```json
    db.review.find(
    	{
    		id : ObjectId('asdf'),
    		text {
    			$regex : 'best|werst',
    			$options: 'i'
    		}
    	})
    ```

    위와 같이 하면 대소문자를 구분하지 않겠지만 인덱스를 사용할 수 없게 된다. 따라서 대소문자를 구분하지 않는 검색을 하고싶다면 별도의 필드에 명시적으로 값을 저장하거나 다른 쿼리와 결합해 mongo db의 텍스트 검색 기능 사용을 고려하는게 좋다.

## 그 외의 쿼리 연산자

- `$mod[몫, 결과]`
- `$type`
    - 어떤 BSON타입인지 확인
- `$text`
    - 텍스트 인덱스로 인덱싱된 필드의 내용에 대해 텍스트 검색을 수행할 수 있게 해줌

## 쿼리 옵션

### 프로젝션(projections)

결괏괎 도큐먼트에 대해 리턴할 필드를 지정하는데 사용한다.

- `$slice`
    - 리턴되는 도큐먼트의 부분집합을 선택한다. 결과로 _id는 항상 포함된다.

    ```json
    db.users.find({}, {'username':1})
    ```

    - 데이터를 배제하기 위해선 필드 이름에 0을 지정한다. _id도 제외할 수 있다.

    ```json
    db.users.find({}, {'gender':0})
    ```

    - `$slice` 를 사용하면 배열의 값을 어떤 범위 내에서 정할 수도 있다.

    ```json
    //처음 리뷰 10개를 가져온다
    db.products.find({reviews : {$slice:10}})
    //마지막 5개를 가져온다
    db.products.find({reviews : {$slice:-5}})
    // 10부터 24까지 가져오고 평점 포함
    db.products.find({reviews : {$slice:[10, 24]}, reviews.rating : 1})
    ```

### 정렬

```json
db.reviews.find({}).sort({'rating': -1})
```

## 쿼리 최적화(WIP)

### 느린 쿼리 탐지

p.268

### 프로파일러 사용

### 느린 쿼리 분석