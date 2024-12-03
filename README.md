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
### eslint, prettier

- 정해진 규칙에 따라 자동적으로 코드 스타일을 정리해 코드의 일관성을 유지하고자 했습니다.
- 코드 품질 관리는 eslint에, 코드 포맷팅은 prettier에 일임해 사용했습니다.
- airbnb의 코딩 컨벤션을 참고해 사용했고, 예외 규칙은 팀원들과 협의했습니다.
- 협업 시 매번 컨벤션을 신경 쓸 필요 없이 빠르게 개발하는 데에 목적을 두었습니다.

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
    - 커스터마이징 페이지: 3D 인터랙션 UI 배치 및 조작 편의성 설계.
    - 반응형 웹 디자인 고려하여 다양한 화면 크기에 적합한 레이아웃 구성.
- 세부 작업 목록:
    - 페이지 레이아웃 설계
        - 메인 페이지: 카테고리 섹션(의류, 커스터마이징, 쇼룸) 및 배너 구성.
        - 커스터마이징 페이지: 티셔츠 모델, 색상·질감 변경 메뉴, 이미지 업로드 영역 배치.
        - 쇼룸 페이지: 브랜드 제품의 3D 디스플레이 영역 설계.
    - 네비게이션 및 헤더/푸터 구성:
        - 주요 메뉴(홈, 장바구니, 마이페이지 등) 및 검색 기능 UI 설계.

- **CSS 작업**
- 업무 내용:
    - HTML 구조에 스타일링 적용하여 웹 페이지의 시각적 완성도를 높임.
    - CSS 스타일시트 작성: 색상 테마, 글꼴, 버튼 스타일, 카드형 레이아웃 등 정의.
    - Three.js와 연동되는 커스터마이징 인터페이스의 스타일 조정.
    - 반응형 디자인: Media Query를 활용해 다양한 기기에서의 사용자 경험 최적화.
- 세부 작업 목록:
    - 스타일시트 작성
        - index.css: 메인 페이지 공통 스타일 정의(글꼴, 배경, 카드 레이아웃 등).
        - register.css, signin.css: 회원가입 및 로그인 폼 스타일링.
        - Product_D_style.css: 제품 상세 페이지의 UI 스타일링.
        - Join_style.css, Notice_M_style.css: 커뮤니티 관련 페이지 스타일링.
        - 모바일, 태블릿, 데스크탑 화면에서 일관된 사용자 경험 제공.
<br>

### 😎부승언

- **UI**
    - 페이지 : splash 페이지, sns 로그인 페이지, 로그인, 회원가입
    - 공통 컴포넌트 : 상품 카드, 사용자 배너
- **기능**
    - splash 페이지, sns로그인 페이지, 로그인 유효성 및 중복 검사, 회원가입 유효성 및 중복 검사, 이메일 검증, 프로필 설정, 접근제한 설정

<br>

### 🐬전성현

- **UI**
    - 페이지 : 사용자 프로필 페이지
    - 공통 컴포넌트 : 탑배너, 하단 모달창
- **기능**
    - 팔로우 & 언팔로우, 로그아웃, 하단 모달창, 댓글 삭제, 게시글 삭제, 상품 삭제, 사용자 게시글 앨범형 이미지, 탑 배너 뒤로가기 버튼, Alert 모달
    
<br>

## 5. 개발 기간 및 작업 관리

### 개발 기간

- 전체 개발 기간 : 2022-12-09 ~ 2022-12-31
- UI 구현 : 2022-12-09 ~ 2022-12-16
- 기능 구현 : 2022-12-17 ~ 2022-12-31

<br>

### 작업 관리

- GitHub Projects와 Issues를 사용하여 진행 상황을 공유했습니다.
- 주간회의를 진행하며 작업 순서와 방향성에 대한 고민을 나누고 GitHub Wiki에 회의 내용을 기록했습니다.

<br>

## 6. 신경 쓴 부분

- [접근제한 설정](https://github.com/likelion-project-README/README/wiki/README-6.%EC%8B%A0%EA%B2%BD-%EC%93%B4-%EB%B6%80%EB%B6%84_%EC%A0%91%EA%B7%BC%EC%A0%9C%ED%95%9C-%EC%84%A4%EC%A0%95)

- [Recoil을 통한 상태관리 및 유지](https://github.com/likelion-project-README/README/wiki/README-6.%EC%8B%A0%EA%B2%BD-%EC%93%B4-%EB%B6%80%EB%B6%84_Recoil%EC%9D%84-%ED%86%B5%ED%95%9C-%EC%83%81%ED%83%9C%EA%B4%80%EB%A6%AC-%EB%B0%8F-%EC%9C%A0%EC%A7%80)

<br>

## 7. 페이지별 기능

### [초기화면]


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

## 8. 트러블 슈팅


<br>

## 9. 개선 목표


- **23-01-17 성능 개선 내용**
    

<br>

## 10. 프로젝트 후기

### 🍊 고지연

<br>

### 👻 김민제


<br>

### 😎 양희지


<br>

### 🐬 지창언


