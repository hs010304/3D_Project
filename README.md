#  3D 커스터마이징 쇼핑몰

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
├── README.md
├── .eslintrc.js
├── .gitignore
├── .prettierrc.json
├── package-lock.json
├── package.json
│
├── public
│    └── index.html
└── src
     ├── App.jsx
     ├── index.jsx
     ├── api
     │     └── mandarinAPI.js
     ├── asset
     │     ├── fonts
     │     ├── css_sprites.png
     │     ├── logo-404.svg
     │     └── logo-home.svg
     │          .
     │          .
     │          .
     ├── atoms
     │     ├── LoginData.js
     │     └── LoginState.js
     ├── common
     │     ├── alert
     │     │     ├── Alert.jsx
     │     │     └── Alert.Style.jsx
     │     ├── button
     │     ├── comment
     │     ├── inputBox
     │     ├── post
     │     ├── postModal
     │     ├── product
     │     ├── tabMenu
     │     ├── topBanner
     │     └── userBanner
     ├── pages
     │     ├── addProduct
     │     │     ├── AddProduct.jsx
     │     │     └── AddProduct.Style.jsx
     │     ├── chatList
     │     ├── chatRoom
     │     ├── emailLogin
     │     ├── followerList
     │     ├── followingList
     │     ├── home
     │     ├── join
     │     ├── page404
     │     ├── postDetail
     │     ├── postEdit
     │     ├── postUpload
     │     ├── productEdit
     │     ├── profile
     │     ├── profileEdit
     │     ├── profileSetting
     │     ├── search
     │     ├── snsLogin
     │     └── splash
     ├── routes
     │     ├── privateRoutes.jsx
     │     └── privateRoutesRev.jsx  
     └── styles
           └── Globalstyled.jsx
```

<br>

## 4. 역할 분담

### 🍊윤형식

- **UI**
    - 페이지 : 홈, 검색, 게시글 작성, 게시글 수정, 게시글 상세, 채팅방
    - 공통 컴포넌트 : 게시글 템플릿, 버튼
- **기능**
    - 유저 검색, 게시글 등록 및 수정, 게시글 상세 확인, 댓글 등록, 팔로워 게시글 불러오기, 좋아요 기능

<br>
    
### 👻김서연

- **UI**
    - 페이지 : 프로필 설정, 프로필 수정, 팔로잉&팔로워 리스트, 상품 등록, 상품 수정, 채팅 목록, 404 페이지
    - 공통 컴포넌트 : 탭메뉴, InputBox, Alert 모달, 댓글
- **기능**
    - 프로필 설정 및 수정 페이지 유저 아이디 유효성 및 중복 검사, 상품 등록 및 수정

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


