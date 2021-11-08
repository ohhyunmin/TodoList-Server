# Todo list API 만들기 프로젝트

## 요구기능

1) Todo List 에 Item 추가<br>
   Method : POST<br>
   EndPoint : /<br>
   request : title<br>
   
2) Todo List 중 특정 Item 조회<br>
   Method : GET<br>
   EndPoint : /{:id}<br>
   
3) Todo List 전체 목록 조회<br>
   Method : GET<br>
   EndPoint : /<br>

   
4) Todo List 중 특정 Item 수정<br>
   Method : PATCH<br>
   EndPoint : /{:id}<br>
   request : title<br>

5) Todo List 중 특정 Item 삭제<br>
   Method : DELETE<br>
   EndPoint : /{:id}<br>

6) Todo List 전체 목록 삭제<br>
   Method : DELETE<br>
   EndPoint : /<br>
   
## Todo List API 만들기 프로젝트 설정

1) IntelliJ Open -> New Project -> Gradle<br>
2) build.gradle 에 프로젝트에 사용할 의존성을 추가한다.<br>
   ![image](https://user-images.githubusercontent.com/66984443/140600328-715ec9b3-b022-4e31-82d1-b8572a992c2d.png)<br>
   2-1) springBoot 와 restAPI, InMemory 형태의 h2 DB, JPA, lombok<Br>
   ![image](https://user-images.githubusercontent.com/66984443/140600318-a20a8593-4a73-49f8-a829-a7bd940d1f40.png)<br>
   2-2) lombok 의 경우 IntelliJ 에서 Plugin 을 열고 lombok 을 설치 후 IntelliJ를 재실행한다.<br>
   2-3) Enable annotation processing 을 적용시킨다.<br>
  ![image](https://user-images.githubusercontent.com/66984443/140600439-b480c4f8-219d-4f7f-9ea3-1025db08497c.png)<br>

3) src-main-java 에 페키지 및 application class 를 생성한다.<br>
   ![image](https://user-images.githubusercontent.com/66984443/140604276-62007d6a-768b-4027-a016-b146ec35a890.png)<br>
   
4) Model 을 구현한다.<br>
   4-1) DB 와 데이터를 주고받기 위한 TodoList 의 Entity Class<br>
        TodoListEntity Class 에서 @Id 어노테이션을 이용해 키값을 정의해준다. ( Long id; )
   4-2) 요청/응답을 하기 위한 TodoListRequest, TodoListResponse<br>
![image](https://user-images.githubusercontent.com/66984443/140601369-d5470482-1a5f-4410-b93a-103ebbf1925d.png)<br>

5) Repository 를 구현한다.<br>
   5-1) Repository 구현 시 Interface 로 생성하고 JpaRepository를 상속받는다.<br>
        ( DB Table 과 연결될 객체인 TodoListEntity 와 키값의 타입은 Long 을 입력한다. )<br>
        ![image](https://user-images.githubusercontent.com/66984443/140603448-3f5c1999-656f-4775-b13f-7ee1b4e8165c.png)<br>
        
6) Service 를 구현한다.<br>

7) Controller 를 구현한다.<br> 

8) postman 을 다운로드 받는다. Test 를 postman 으로 할 예정이기 때문이다.<br>
   https://www.postman.com/downloads/<br>
   
9) postman 을 활용하여 테스트 데이터 보내 저장하고 응답을 확인한다.<br>
   ![image](https://user-images.githubusercontent.com/66984443/140604744-7e9ad744-8c7a-450f-ab48-60a775a6fb91.png)<br>

10) 저장한 데이터를 조회한다. 목록을 조회하는 개념으로 List 형태로 응답을 받는다.<br>
![image](https://user-images.githubusercontent.com/66984443/140604804-ced73c13-e364-40bc-8434-21da8e3f6922.png)<br>

11) 저장된 데이터를 수정한다.<br>
![image](https://user-images.githubusercontent.com/66984443/140604875-dad148e4-49fa-4d1e-8e36-2583bbbbb42d.png)<br>

12) 저장된 데이터를 조회하여, 수정이 되었는지 확인해본다.<br>
![image](https://user-images.githubusercontent.com/66984443/140604903-3798d007-7beb-429b-bfd5-db8d8d58b164.png)<br>

13) MVC 형태로 프로젝트를 구성하고, RestAPI 와 lombok, jpa 대해 구체적으로 다루어 보았고 jpa 를 이용함으로써 DB 연동에 필요한 코드들이 굉장히 많으 줄어든 것을 다시 한번 느끼는데 좋은 경험이 되었습니다. <Br>


