# wanted-pre-onboarding-backend
10월 백엔드 인턴십 - 사전 과제

# 프로젝트 개요
이 프로젝트는 기업의 채용을 위한 웹 서비스를 제공하는 백엔드 API 서버를 구현하는 것을 목표로 합니다.<br><br>
사용자는 채용공고를 등록, 수정, 삭제하고 채용공고 목록을 확인할 수 있으며, <br>
채용공고 검색 및 채용 상세 정보를 조회할 수 있습니다.<br>
사용자는 또한 채용공고에 지원할 수 있습니다.

# 1. 요구사항 분석
## 1-1. 채용공고를 등록합니다.
### [POST] /recruitment-announcement
### [request body(JSON)]
company_id/정수/회사 아이디<br>
position_name/문자열/포지션 이름<br>
reward_amount/정수/채용 보상금<br>
content/문자열/채용 공고의 내용<br>
nation/문자열/국가명<br>
region/문자열/지역명<br>
### [response body(JSON)]
(성공) - 201<br>
(실패) - 400<br>
message 문자열 응답메시지<br>
### 구현 내용
- [ ] request body에 대한 유효성 검사<br>
    - [ ] position_name : 한 글자 이상이 아니면 IllegalArgumentException을 발생시킨다
    - [ ] reward_amount : 양의 정수가 아니면 IllegalArgumentException을 발생시킨다
- [ ] DB에 채용 공고 추가<br>
## 1-2. 채용공고를 수정합니다.
### [PUT] /recruitment-announcement/{id}
### [request body(JSON)]
position_name/문자열/포지션 이름<br>
reward_amount/정수/채용 보상금<br>
content/문자열/채용 공고의 내용<br>
nation/문자열/국가명<br>
region/문자열/지역명<br>
### [response body(JSON)]
(성공) - 200<br>
(실패) - 400<br>
message 문자열 응답메시지<br>
### 구현 내용
- [ ] id에 대한 유효성 검사
  - [ ] id : 해당 id가 존재하지 않으면 IllegalArgumentException을 발생시킨다
- [ ] request body에 대한 유효성 검사<br>
    - [ ] position_name : 한 글자 이상이 아니면 IllegalArgumentException을 발생시킨다
    - [ ] reward_amount : 양의 정수가 아니면 IllegalArgumentException을 발생시킨다
- [ ] DB의 채용 공고 수정
## 1-3. 채용공고를 삭제합니다.
### [DELETE] /recruitment-announcement/{id}
### [response body(JSON)]
(성공) - 200<br>
(실패) - 400<br>
message 문자열 응답메시지<br>
### 구현 내용
- [ ] id에 대한 유효성 검사
  - [ ] id : 해당 id가 존재하지 않으면 IllegalArgumentException을 발생시킨다
- [ ] DB의 채용 공고 삭제
## 1-4. 채용공고 목록을 가져옵니다.
### [GET] /recruitment-announcement/page/{pageNum}
### [request body(JSON)]
page_range/정수/한 페이지의 크기(선택/기본 10/최대 20)<br>
### [response body(JSON)]
(성공) - 200<br>
company_id/정수/회사 아이디<br>
company_name/문자열/회사 이름<br>
position_name/문자열/포지션 이름<br>
reward_amount/정수/채용 보상금<br>
content/문자열/채용 공고의 내용<br>
nation/문자열/국가명<br>
region/문자열/지역명<br>
(실패) - 400<br>
message 문자열 응답메시지<br>
### 구현 내용
- [ ] pageNum과 page_range에 대한 유효성 검사
    - [ ] pageNum : 양의 정수가 아니면 IllegalArgumentException을 발생시킨다
    - [ ] page_range : 1~20의 숫자가 아니면 IllegalArgumentException을 발생시킨다
- [ ] DB의 채용 공고를 조회 후 응답
## 1-5. 채용 상세 페이지를 가져옵니다.
### [GET] /recruitment-announcement/{id}
### [response body(JSON)]
(성공) - 200<br>
company_id/정수/회사 아이디<br>
company_name/문자열/회사 이름<br>
position_name/문자열/포지션 이름<br>
reward_amount/정수/채용 보상금<br>
content/문자열/채용 공고의 내용<br>
nation/문자열/국가명<br>
region/문자열/지역명<br>
(실패) - 400<br>
message 문자열 응답메시지<br>
### 구현 내용
- [ ] id에 대한 유효성 검사
  - [ ] id : 해당 id가 존재하지 않으면 IllegalArgumentException을 발생시킨다
- [ ] DB에서 채용 상세 정보를 조회하여 응답한다
## 1-6. 사용자는 채용공고에 지원합니다.
### [POST] /job-application
### [request body(JSON)]
resume_id/정수/이력서 아이디<br>
recruitment_announcement_id/정수/채용 공고 아이디<br>
### [response body(JSON)]
(성공) - 200<br>
(실패) - 400<br>
message 문자열 응답메시지<br>
### 구현 내용
- [ ] resume_id에 대한 유효성 검사
  - [ ] 존재하지 않으면 IllegalArgumentException을 발생시킨다
    - [ ] 사용자가 작성한 이력서가 아니면 IllegalArgumentException을 발생시킨다
- [ ] recruitment_announcement_id에 대한 유효성 검사
  - [ ] 존재하지 않으면 IllegalArgumentException을 발생시킨다
- [ ] DB에 채용 지원 항목을 추가한다

# 2. 구현 과정
## 프로젝트 구성
<img src="https://github.com/Young37/wanted-pre-onboarding-backend/assets/80738298/c37034bc-5f2d-46e1-b82f-be59c5885f04" />

## 데이터 베이스 모델링
<img src="https://github.com/Young37/wanted-pre-onboarding-backend/assets/80738298/e40c4f51-b8b4-44da-95f2-53384a181d53"/>