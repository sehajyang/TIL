# 11. equals를 재정의 하려면 HashCode도 재정의 하라

Created: 2021년 3월 21일
Created by: Seha Jyang

equals를 재정의한 클래스 모두에서 HashCode도 재정의 해야한다.

그렇지 않으면 HashMap이나 HashSet 같은 컬렉션의 원소로 사용할때 문제가 될 것이다.

논리적으로 같은 객체는 같은 해시코드를 반환해야 한다.