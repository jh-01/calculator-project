# 🧮 Java 계산기

자바 문법 실습과 객체 지향 개념 적용 과제

---

## 📌 프로젝트 개요

- 자바 언어의 문법과 객체지향의 원칙(SOLID), 제네릭, 스트림 API 등의 핵심 개념을 실습하기 위한 계산기 프로젝트입니다.
- 단계별로 기능을 확장하는 방식으로 진행했습니다.

---

## ✅ 주요 기능

| 레벨 | 주요 기능 | 학습 키워드 |
|------|-----------|-------------|
| 레벨1 | 사칙연산 입력/출력 | 변수, 데이터 타입, 조건문, 반복문 |
| 레벨2 | 연산 메서드 분리, 기록 저장/삭제 | 메서드, 배열/리스트, 클래스 구조화 |
| 레벨3 | 객체지향 구조화, 제네릭 도입, 스트림 필터링 | OOP, 제네릭, 람다, 스트림 API, SOLID 설계 |

---

## 🧠 학습 목표
### <계산기 1단계>
- [x] JVM 환경 설치, JDK 버전 설정을 통해 프로젝트를 생성
- [x] 변수 선언 및 타입 변환
- [x] 표준 입력/출력 및 연산 처리
- [x] 조건문(if, else if, else)을 사용한 흐름 제어
- [x] 반복문(for, while)을 활용한 반복 작업 수행

### <계산기 2단계>
- [x] 메서드 정의와 호출
- [x] 배열 선언 및 활용
- [x] 클래스 분리 및 객체 생성

### <계산기 3단계>
- [x] 제네릭을 활용한 타입 유연성 확보
- [x] 인터페이스 또는 상속을 활용한 코드의 재사용성 확장
- [x] 람다식을 활용한 함수형 인터페이스를 구현
- [x] 스트림 API를 활용한 데이터를 필터링, 변환

---

## 🔧 디렉토리 구조
```
calculator/
├── basic/           # 1단계: 단순 연산
├── oop/             # 2단계: 클래스 분리
└── advanced/        # 3단계: 제네릭 + 스트림 + OOP 최적화
```

---

### 📁주요 클래스 (advanced 패키지 하위)
![Main](https://github.com/user-attachments/assets/d468ffc0-2aad-4d94-9999-f72726e7c672)

| 클래스 | 역할 |
|--------|------|
App | 프로그램 실행 시작점
CalculatorUI | 콘솔 UI 담당 (입력/출력/메뉴)
ArithmeticCalculator<T> | 제네릭 기반 연산 및 결과 저장
CalculateResult<T> | 연산 기록 객체
OperatorType | Enum 기반 연산자 관리
CalculatorService<T> | (선택적) 책임 분리를 위한 서비스 계층
Calculator<T> | 연산 기능의 기본 계약을 정의하는 인터페이스

---

## 🏁 실행 방법
```bash
# 컴파일
javac -d out src/calculator/advanced/*.java

# 실행
java -cp out calculator.advanced.App
```

---

## ✨ 향후 계획 (예정)
- GUI 기능 추가 (JavaFX 또는 Swing)
- 로그 파일 저장 기능
- 단위 테스트 (JUnit) 추가
