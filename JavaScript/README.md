# JavaScript

[러닝 자바스크립트](http://www.hanbit.co.kr/store/books/look.php?p_code=B2328850940) 를 공부하며 기록하는 문서

## Index
1. 함수
2. 스코프
3. 배열과 배열처리
4. 객체와 객체지향 프로그래밍


### 1. 함수

* 매개변수가 함수를 결정하는가?
    * 어떤 함수를 호출하든 그 함수에서 정해진 매개변수 숫자와 관계없이 몇개의 매개변수를 전달해도 된다.
    * 정해진 매개변수에 값을 제공하지 않으면 암시적으로 undefiend가 할당된다

* 매개변수 해체
~~~javascript
function getItems([name, type, state]) {
    return `${name} ${type} ${state}`;
}

const arr = ["apple","fruits","red"];
getItems(arr); //"apple fruits red"
~~~
확산연산자(...) 를 서서 남는 매개변수를 이용할 수도 있다.
~~~javascript
function addPrefix(prefix, ...words)
~~~

* 매개변수 기본값
    * 일반적으로 매개변수에 값을 제공하지 않으면 undefined 지만, ES6에서는 매개변수에 값을 지정할 수 있다
~~~javascript
function f(a,b = 'default',c='1'){
    return `${a} ${b} ${c}`;
}
f(); // 'undefined default 1'
~~~
