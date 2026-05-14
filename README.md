# spring_rest

Spring Boot 기반 RESTful API 실습 레포지토리입니다.

이 레포지토리는 REST API 기본 구조, Swagger 테스트, H2 DB와 JPA 연동, 레이어드 아키텍처 구조를 학습하기 위한 실습 프로젝트를 포함합니다.

실제 Spring Boot 프로젝트는 하위 폴더 `restadvance`에 위치합니다.

---

## 프로젝트 위치

```text
spring_rest
 └─ restadvance
     ├─ build.gradle
     ├─ settings.gradle
     ├─ src
     │   ├─ main
     │   └─ test
     └─ README.md
```

---

## 실습 프로젝트 개요

`restadvance` 프로젝트는 Spring Boot에서 REST API를 구현할 때 자주 사용하는 기본 구조를 학습하기 위한 실습 프로젝트입니다.

주요 학습 내용은 다음과 같습니다.

- Spring Boot 프로젝트 기본 구조 이해
- RESTful API 설계와 구현
- Swagger를 활용한 API 테스트
- ResponseEntity를 활용한 HTTP 응답 제어
- H2 Database와 JPA 연동
- Controller, Service, Repository 계층 분리
- Entity와 DTO 분리
- 전역 예외 처리
- 레이어드 아키텍처 구조 이해

---

## 사용 기술

| 구분 | 기술 |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot |
| Build Tool | Gradle |
| API 문서화 | Swagger / Springdoc OpenAPI |
| Database | H2 Database |
| ORM | Spring Data JPA |
| Utility | Lombok |

---

## 프로젝트 구조

```text
restadvance/src/main/java/com/example/restadvanced
 ├─ RestadvancedApplication.java
 ├─ controller
 │   ├─ HelloController.java
 │   ├─ ProductController.java
 │   └─ AuthController.java
 ├─ service
 │   ├─ ProductService.java
 │   └─ AuthService.java
 ├─ repository
 │   └─ ProductRepository.java
 ├─ entity
 │   └─ Product.java
 ├─ dto
 │   ├─ ProductResponse.java
 │   ├─ ProductCreateRequest.java
 │   └─ LoginRequest.java
 ├─ config
 │   ├─ CorsConfig.java
 │   └─ DataInitializer.java
 └─ exception
     ├─ ErrorResponse.java
     └─ GlobalExceptionHandler.java

restadvance/src/main/resources
 └─ application.yaml
```

---

## 레이어드 아키텍처

이 프로젝트는 다음과 같은 레이어드 아키텍처 구조를 따릅니다.

```text
Client
  ↓
Controller
  ↓
Service
  ↓
Repository
  ↓
Database
```

각 계층의 역할은 다음과 같습니다.

| 계층 | 역할 |
|---|---|
| Controller | HTTP 요청을 받고 응답을 반환 |
| Service | 비즈니스 로직 처리 |
| Repository | DB 접근 처리 |
| Entity | DB 테이블과 매핑되는 객체 |
| DTO | API 요청/응답 데이터 전달 객체 |

---

## 주요 기능

| Method | URL | 설명 |
|---|---|---|
| GET | `/api/products` | 상품 전체 조회 |
| GET | `/api/products/{id}` | 상품 단건 조회 |
| POST | `/api/products` | 상품 등록 |

---

## 실행 방법

### 1. 레포지토리 클론

```bash
git clone <repository-url>
cd spring_rest
```

### 2. Spring Boot 프로젝트 폴더로 이동

```bash
cd restadvance
```

### 3. 프로젝트 실행

IntelliJ IDEA에서 `RestadvancedApplication.java`를 실행합니다.

또는 터미널에서 실행합니다.

```bash
./gradlew bootRun
```

Windows 환경에서는 다음 명령어를 사용할 수 있습니다.

```bash
gradlew bootRun
```

---

## Swagger 접속

서버 실행 후 아래 주소로 접속합니다.

```text
http://localhost:8080/swagger-ui/index.html
```

---

## H2 Console 접속

서버 실행 후 아래 주소로 접속합니다.

```text
http://localhost:8080/h2-console
```

접속 정보는 다음과 같습니다.

| 항목 | 값 |
|---|---|
| JDBC URL | `jdbc:h2:mem:restdb` |
| User Name | `sa` |
| Password | 비워두기 |

접속 후 다음 SQL로 상품 데이터를 확인할 수 있습니다.

```sql
SELECT * FROM PRODUCT;
```

---

## 주요 의존성

`restadvance/build.gradle`에 다음 의존성이 포함되어야 합니다.

```gradle
implementation 'org.springframework.boot:spring-boot-starter-validation'
implementation 'org.springframework.boot:spring-boot-starter-webmvc'
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:'

implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.3")

implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
runtimeOnly 'com.h2database:h2'
implementation 'org.springframework.boot:spring-boot-h2console'
```

> Spring Boot 4.x 환경에서는 H2 Console 사용을 위해 `spring-boot-h2console` 의존성이 필요할 수 있습니다.

---

## 학습 포인트 정리

이 프로젝트를 통해 다음 내용을 학습할 수 있습니다.

```text
1. REST API 기본 구조
2. Swagger를 활용한 API 테스트
3. ResponseEntity를 활용한 HTTP 응답 제어
4. Controller, Service, Repository 계층 분리
5. H2 DB와 JPA 연동
6. Entity와 DTO 분리
7. @Valid를 활용한 요청 데이터 검증
8. @RestControllerAdvice를 활용한 전역 예외 처리
9. JpaRepository의 기본 메서드 사용
10. 레이어드 아키텍처 기반의 Spring Boot API 설계
```


