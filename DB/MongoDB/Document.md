# Document

Created: 2021년 6월 26일
Created by: Seha Jyang

## serialization

[BSON](https://www.notion.so/BSON-76afb9eb4584499291a2a63b07f57381)으로 역/직렬화 

키의 이름이 도큐먼트에 매번 저장된다.

## 크기 제한

- 16MB
- 최대 중첩깊이 100
- 대량 삽입시 100만건 이상일 경우 여러개의 대량 삽입 도큐먼트 그룹으로 나눠야 한다.
    - 이 연산의 크기도 16MB 보다 크면 안됨