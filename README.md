#  3D 커스터마이징 쇼핑몰
![image](https://github.com/user-attachments/assets/7edccd23-4043-48d7-bc88-66506f1e9633)

<br>

## 프로젝트 소개

MZ 세대의 자기 표현 욕구와 재미를 반영한 3D 커스터마이징 쇼핑몰을 설계했습니다. 기존 2D 출력 결과물의 한계를 개선하여 실물과 차이를 줄이고, 사용자 경험을 향상시켰습니다.
<br>
- 메인 페이지 구성: 의류 쇼핑몰, 커스터마이징 서비스, 쇼룸
- 커스터마이징 서비스: 티셔츠 색상·질감 변경, 이미지 적용, 임시 저장/불러오기, 워터마크 처리
- 쇼룸 페이지: 입점 브랜드 제품을 3D로 시각화하여 홍보 및 고객 흥미 유발
- 사용 기술: HTML, CSS, JavaScript, Three.js, Spring Boot, H2
- 3D 기술과 사용자 친화적 서비스를 통해 기존 쇼핑몰과 차별화된 경험을 제공합니다.

<br>

## 팀원 구성

### 🍊 윤형식 https://github.com/hs010304

### 👻 김서연 https://github.com/tjdus0817

### 😎 부승언 https://github.com/seb980423

### 🐬 전성현 https://github.com/ard1019


</div>

<br>

## 1. 개발 환경

- Front : HTML, Three.js, style sheet, photoshop, CSS, JavaScript
- Back-end : Springboot, H2
- 버전 및 이슈관리 : Github
- 협업 툴 : Discord, Github

<br>

## 2. 채택한 개발 기술

### Front-End

- HTML: 웹 페이지의 구조와 콘텐츠를 설계하는 데 사용.
- CSS/Style Sheet: 웹 페이지의 디자인 및 스타일링을 담당.
- JavaScript: 사용자 인터랙션과 동적인 콘텐츠를 처리.
- Three.js: 3D 렌더링과 인터랙션을 가능하게 하여 커스터마이징 서비스와 쇼룸의 3D 시각화를 구현.
- Photoshop: UI 디자인 및 이미지 작업에 활용.
    
### Back-End

- Spring Boot: 서버 개발 및 API 설계, 데이터 처리, 비즈니스 로직 구현에 사용.
- H2 Database: 경량형 데이터베이스로 로컬 환경에서 데이터 저장 및 테스트에 활용.

<br>

## 3. 프로젝트 구조

```
/3D_Project  
├── src  
│   ├── main  
│   │   ├── java  
│   │   │   └── com.example.demo  
│   │   │       ├── Application.java  
│   │   │       ├── config  
│   │   │       │   ├── ErrorHd.java  
│   │   │       │   ├── PortOneConfig.java  
│   │   │       │   └── WebConfig.java  
│   │   │       ├── controller  
│   │   │       │   ├── BuyController.java  
│   │   │       │   ├── CartController.java  
│   │   │       │   ├── logincheck.java  
│   │   │       │   ├── Main_Controller.java  
│   │   │       │   ├── MemberController.java  
│   │   │       │   └── ProductController.java  
│   │   │       ├── dto  
│   │   │       │   ├── MemberFormDTO.java  
│   │   │       │   ├── OrderDto.java  
│   │   │       │   ├── PortOneDto.java  
│   │   │       │   ├── ProductFormDTO.java  
│   │   │       │   └── ProductServiceDTO.java  
│   │   │       ├── entity  
│   │   │       │   ├── Cart.java  
│   │   │       │   ├── CartItem.java  
│   │   │       │   ├── Member.java  
│   │   │       │   ├── Order.java  
│   │   │       │   ├── OrderDetail.java  
│   │   │       │   ├── PaymentStatus.java  
│   │   │       │   ├── Product.java  
│   │   │       │   └── Role.java  
│   │   │       ├── repository  
│   │   │       │   ├── CartItemRepository.java  
│   │   │       │   ├── CartRepository.java  
│   │   │       │   ├── MemberRepository.java  
│   │   │       │   ├── OrderDetailRepository.java  
│   │   │       │   ├── OrderRepository.java  
│   │   │       │   └── ProductRepository.java  
│   │   │       └── service  
│   │   │           ├── CartService.java  
│   │   │           ├── MemberService.java  
│   │   │           ├── OrderService.java  
│   │   │           └── ProductService.java  
│   │   ├── resources  
│   │   │   ├── META-INF  
│   │   │   ├── static  
│   │   │   │   ├── images  
│   │   │   │   ├── t_shirt  
│   │   │   │   ├── Find_style.css  
│   │   │   │   ├── index.css  
│   │   │   │   ├── Inquiry_M_style.css  
│   │   │   │   ├── Join_style.css  
│   │   │   │   ├── Notice_M_style.css  
│   │   │   │   ├── Product_D_style.css  
│   │   │   │   ├── register.css  
│   │   │   │   ├── signin.css  
│   │   │   │   └── User_M_style.css  
│   │   │   ├── templates  
│   │   │   │   ├── a_index.html  
│   │   │   │   ├── best.html  
│   │   │   │   ├── buy.html  
│   │   │   │   ├── buy2.html  
│   │   │   │   ├── cart.html  
│   │   │   │   ├── carttest.html  
│   │   │   │   ├── CREATE_GLB.html  
│   │   │   │   ├── delete-success.html  
│   │   │   │   ├── detail.html  
│   │   │   │   ├── Errorpg.html  
│   │   │   │   ├── hello.html  
│   │   │   │   ├── index.html  
│   │   │   │   ├── member-detail.html  
│   │   │   │   ├── memberList.html  
│   │   │   │   ├── mypage.html  
│   │   │   │   ├── new.html  
│   │   │   │   ├── notice.html  
│   │   │   │   ├── order_form.html  
│   │   │   │   ├── order_success.html  
│   │   │   │   ├── outer.html  
│   │   │   │   ├── P_detail.html  
│   │   │   │   ├── pants.html  
│   │   │   │   ├── payment.html  
│   │   │   │   ├── product_detail.html  
│   │   │   │   ├── product_form.html  
│   │   │   │   ├── product_list.html  
│   │   │   │   ├── register.html  
│   │   │   │   ├── shopnow.html  
│   │   │   │   ├── shoptest.html  
│   │   │   │   ├── showroom.html  
│   │   │   │   ├── signin.html  
│   │   │   │   ├── t_2(ShowRoom).html  
│   │   │   │   ├── t_4(BSR).html  
│   │   │   │   ├── test.html  
│   │   │   │   ├── top.html  
│   │   │   │   └── wishlist.html  
│   │   │   └── application.properties  

```

<br>

## 4. 역할 분담

### 🍊윤형식

- **DB 설계 및 구축**
- 업무 내용
    - 요구사항 분석을 기반으로 ERD 설계 및 데이터베이스 모델링 수행.
    - Member, Product, Order, Cart 등의 주요 엔티티 정의 및 관계 설정.
    - 엔티티 필드 최적화 및 제약조건 설정(Primary Key, Foreign Key, Unique, Index 등).
    - H2 데이터베이스를 사용하여 테스트 환경 구축.
    - 초기 데이터(seed 데이터) 작성 및 DB 스키마 생성.
- 세부 작업 목록
- ERD 설계
    - 주요 엔티티: Member, Product, Order, OrderDetail, Cart, CartItem.
    - 관계: 1:N (Member ↔ Order), N:M (Product ↔ Cart).
- 테이블 생성
    - SQL 스크립트 작성 및 H2 데이터베이스에 반영.
- CRUD 작업 확인
    - Repository 테스트를 통해 데이터 삽입, 수정, 삭제, 조회 동작 확인.

- **로직 설계**
- 업무 내용
    - 주요 기능 흐름 설계 및 비즈니스 로직 구현.
    - 서비스 계층 설계를 통해 Controller와 Repository 간 역할 분리.
    - 커스터마이징 서비스 로직: 티셔츠 색상/질감 변경, 이미지 업로드 및 저장, 임시 저장 및 불러오기 로직 구현.
    - 쇼핑몰 로직: 제품 등록, 수정, 삭제 및 구매 로직 설계.
    - 주문 로직:
        - 장바구니 상품 선택 → 주문 생성 → 결제 상태 업데이트.
    - 에러 처리 설계: 유효성 검사 실패, 데이터베이스 예외 등 예외 상황 처리.
-  세부 작업 목록:
    - CartService
        - 장바구니에 상품 추가/삭제 로직 구현.
        - 사용자별 장바구니 조회 기능 구현.
    - OrderService
        - 주문 생성 및 상태 변경 로직 설계.
        - 사용자 주문 이력 조회 기능 설계.
    - ProductService
        - 제품 등록, 수정, 삭제 및 목록 조회 로직 구현.

- **결과물**
- DB 설계 산출물: ERD, 스키마 생성 SQL 스크립트, H2 데이터베이스 초기화 스크립트.
- 로직 설계 산출물: Java 기반 서비스 클래스 구현 파일, 주요 기능별 유닛 테스트 코드.
<br>
    
### 👻김서연

- **UI**
- 업무 내용:
    - 웹 페이지의 전체적인 구조 및 사용자 경험(UX) 디자인 설계.
    - 메인 페이지와 하위 페이지(의류 쇼핑몰, 커스터마이징, 쇼룸)의 레이아웃 정의.
    - 사용자 흐름 설계: 메인 페이지 → 상품 상세 페이지 → 장바구니 → 주문/결제 과정.
    - 반응형 웹 디자인 고려하여 다양한 화면 크기에 적합한 레이아웃 구성.
- 세부 작업 목록:
    - 페이지 레이아웃 설계
        - 메인 페이지: 카테고리 섹션(의류, 커스터마이징, 쇼룸) 및 배너 구성.
    - 네비게이션 및 헤더/푸터 구성:
        - 주요 메뉴(홈, 장바구니, 마이페이지 등) 및 검색 기능 UI 설계.

- **CSS 작업**
- 업무 내용:
    - HTML 구조에 스타일링 적용하여 웹 페이지의 시각적 완성도를 높임.
    - CSS 스타일시트 작성: 색상 테마, 글꼴, 버튼 스타일, 카드형 레이아웃 등 정의.
- 세부 작업 목록:
    - 스타일시트 작성
        - index.css: 메인 페이지 공통 스타일 정의(글꼴, 배경, 카드 레이아웃 등).
        - register.css, signin.css: 회원가입 및 로그인 폼 스타일링.
        - Product_D_style.css: 제품 상세 페이지의 UI 스타일링.
        - Join_style.css, Notice_M_style.css: 커뮤니티 관련 페이지 스타일링.
        - 모바일, 태블릿, 데스크탑 화면에서 일관된 사용자 경험 제공.

- **결과물**
- UI 설계 산출물: 와이어프레임, 페이지 레이아웃 문서.
- CSS 작업 산출물: 각 페이지별 CSS 파일(index.css, product_detail.css 등), 반응형 디자인 적용
<br>

### 😎부승언

- **3D 커스터마이징 기능 개발**
- 업무 내용:
    - Three.js를 사용하여 3D 커스터마이징 기능 구현.
    - 티셔츠 3D 모델 로딩 및 사용자 인터랙션 기능 개발.
    - 색상, 질감 변경 기능 및 이미지 업로드 후 적용 기능 구현.
    - 3D 환경의 사용자 조작(UI)과 물리적 렌더링 최적화.
    - 임시 저장 및 불러오기 기능 구현.
    - 커스터마이징 완료 파일의 워터마크 자동 처리 기능 개발.
- 세부 작업 목록:
    - Three.js 설정
        - 3D 씬, 카메라, 조명 구성.
        - 티셔츠 3D 모델(scene5.gltf)을 불러와 렌더링.
    - 색상 및 질감 변경
        - 사용자 입력값을 받아 티셔츠의 색상(Material Color) 변경 기능 구현.
        - 텍스처 이미지 적용으로 질감 변경 처리.
    - 이미지 업로드 및 배치
        - 사용자가 업로드한 이미지를 3D 모델의 특정 위치에 매핑.
        - 드래그 앤 드롭 인터페이스 제공.
    - 임시 저장 및 불러오기 기능
        - 커스터마이징 데이터를 JSON 형식으로 저장.
        - 불러오기 시 저장된 데이터를 적용하여 이전 상태 복원.
    - 워터마크 처리
        - 커스터마이징 완료 후 이미지 저장 시 워터마크 자동 삽입.
        - 캔버스 기반으로 최종 출력물 생성 및 다운로드.

- **3D 쇼룸 기능 개발**
- 업무 내용:
    - 쇼룸 페이지에 3D 브랜드 제품 디스플레이 구현.
    - 입점 쇼핑몰 제품을 3D 씬에 배치하여 사용자와의 인터랙션 제공.
    - 애니메이션 및 클릭 이벤트로 제품 상세 정보 확인 기능 구현.
- 세부 작업 목록:
    - 쇼룸 환경 구성
        - 브랜드 제품을 3D 공간에 배치하고 회전, 확대/축소 인터랙션 추가.
    - 제품 정보 연동
        - 3D 모델과 제품 정보(Product Entity)를 연동하여 클릭 시 상세 페이지 이동.
    - 애니메이션 효과
        - 부드러운 회전, 조명 변경, 강조 애니메이션 추가로 시각적 흥미 제공.

- **결과물**
- 3D 커스터마이징
    - 색상 및 텍스처 변경 기능, 이미지 매핑 및 저장 기능.
- 3D 쇼룸
    - 입점 브랜드 제품의 3D 디스플레이 및 애니메이션.
- 사용된 기술: Three.js, HTML5 Canvas, JavaScript.
<br>

### 🐬전성현

- **3D 커스터마이징 기능 개발**
- 업무 내용:
    - Three.js를 사용하여 3D 커스터마이징 기능 구현.
    - 티셔츠 3D 모델 로딩 및 사용자 인터랙션 기능 개발.
    - 색상, 질감 변경 기능 및 이미지 업로드 후 적용 기능 구현.
    - 3D 환경의 사용자 조작(UI)과 물리적 렌더링 최적화.
    - 임시 저장 및 불러오기 기능 구현.
    - 커스터마이징 완료 파일의 워터마크 자동 처리 기능 개발.
- 세부 작업 목록:
    - Three.js 설정
        - 3D 씬, 카메라, 조명 구성.
        - 티셔츠 3D 모델(scene5.gltf)을 불러와 렌더링.
    - 색상 및 질감 변경
        - 사용자 입력값을 받아 티셔츠의 색상(Material Color) 변경 기능 구현.
        - 텍스처 이미지 적용으로 질감 변경 처리.
    - 이미지 업로드 및 배치
        - 사용자가 업로드한 이미지를 3D 모델의 특정 위치에 매핑.
        - 드래그 앤 드롭 인터페이스 제공.
    - 임시 저장 및 불러오기 기능
        - 커스터마이징 데이터를 JSON 형식으로 저장.
        - 불러오기 시 저장된 데이터를 적용하여 이전 상태 복원.
    - 워터마크 처리
        - 커스터마이징 완료 후 이미지 저장 시 워터마크 자동 삽입.
        - 캔버스 기반으로 최종 출력물 생성 및 다운로드.

- **3D 쇼룸 기능 개발**
- 업무 내용:
    - 쇼룸 페이지에 3D 브랜드 제품 디스플레이 구현.
    - 입점 쇼핑몰 제품을 3D 씬에 배치하여 사용자와의 인터랙션 제공.
    - 애니메이션 및 클릭 이벤트로 제품 상세 정보 확인 기능 구현.
- 세부 작업 목록:
    - 쇼룸 환경 구성
        - 브랜드 제품을 3D 공간에 배치하고 회전, 확대/축소 인터랙션 추가.
    - 제품 정보 연동
        - 3D 모델과 제품 정보(Product Entity)를 연동하여 클릭 시 상세 페이지 이동.
    - 애니메이션 효과
        - 부드러운 회전, 조명 변경, 강조 애니메이션 추가로 시각적 흥미 제공.

- **결과물**
- 3D 커스터마이징
    - 색상 및 텍스처 변경 기능, 이미지 매핑 및 저장 기능.
- 3D 쇼룸
    - 입점 브랜드 제품의 3D 디스플레이 및 애니메이션.
- 사용된 기술: Three.js, HTML5 Canvas, JavaScript.
    
<br>

## 5. 개발 기간 및 작업 관리

### 개발 기간

- 전체 개발 기간 : 2024-05-01 ~ 2024-10-20
- UI 구현 : 2024-06-01 ~ 2024-07-11
- 기능 구현 : 2024-07-20 ~ 2024-10-11

<br>

### 작업 관리

- GitHub Projects와 notion을 사용하여 진행 상황을 공유.
- 작업 순서와 방향성에 대한 주간회의를 진행

<br>

## 6. 페이지별 기능

### [초기화면]
![image](https://github.com/user-attachments/assets/dedfadd0-292d-4225-8fdf-f25c595d8a48)

- 처음 메인 페이지로 3가지 카테고리로 구성되어 있으며, shop now 아이콘 클릭 시 쇼핑몰 메인 페이지로 넘어가고 
- 차례대로 커스터마이징 서비스를 이용할 수 있으며 마지막 쇼룸 페이지까지 구성되어 있다.

<br>

### [회원가입]


<br>

### [프로필 설정]


<br>

### [로그인]


<br>

### [로그아웃]

<br>

### [상하단 배너]

| 상하단 배너 |


### [홈 피드]


<br>

### [검색]


| 검색 |

<br>

### [프로필]

#### 1. 내 프로필

| 리스트형 & 앨범형 게시글 | 팔로잉 & 팔로워 리스트 |

<br>

#### 2. 타 유저의 프로필


| 팔로우 & 언팔로우 |


<br>

#### 3. 프로필 수정


<br>

### [게시글]

#### 1. 게시글 작성

| 게시글 작성 |

<br>

#### 2. 게시글 수정 및 삭제


| 게시글 수정 & 삭제 |


<br>

#### 3. 좋아요와 댓글


| 좋아요 & 댓글 |


<br>

### [상품]

#### 1. 상품 등록

| 상품 등록 |

<br>

#### 2. 상품 수정 및 삭제


| 상품 수정 & 삭제 |


<br>

### [채팅]


| 채팅 |


<br>




<br>

## 7. 개선 목표


<br>

## 8. 프로젝트 후기

### 🍊 윤형식

<br>

### 👻 김서연연


<br>

### 😎 부승언


<br>

### 🐬 전성현


