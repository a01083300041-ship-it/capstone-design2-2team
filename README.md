# My Safe Guard (재해 안전 관리 시스템)

캡스톤디자인2 팀 프로젝트(졸업 프로젝트) — 강우·침수 정보와 심박수 모니터링을 통합한 Web / Android 재해 안전 관리 시스템입니다.

## 1. 프로젝트 배경 및 개요

부산 지역은 여름철 집중 호우로 인한 도심 침수, 하천 급류 사고가 반복적으로 발생합니다. 이 프로젝트는 두 가지 위험 신호(외부 재난 정보 + 사용자 신체 신호)를 하나의 앱에서 동시에 다루자는 아이디어에서 시작했습니다.

- 공공데이터포털 API로 부산 지역의 실시간 강우량·침수 정보를 수집
- 사용자의 위치를 기준으로 위험 지역 접근 시 경보를 전송
- 웨어러블이 아닌 자체 제작 심박 센서 기기로 사용자의 이상 심박(부정맥·심정지 위험 신호)을 감지해 알림

**기간**: 2024.03 – 2024.06 (약 4개월, 졸업 프로젝트)
**팀 구성**: 4명
**담당 역할**: 심박수 계측 기능 구현 (임베디드 + Android 양쪽)

## 2. 폴더 구조

```
app/    # Android 애플리케이션
web/    # Spring Boot 서버 (Firebase 연동)
```

## 3. 내가 담당한 부분 — 심박수 계측 기능

프로젝트 전체 중 "심박 센서 → 블루투스 전송 → 앱 수신 → 이상 감지 알림"까지 한 사이클을 처음부터 끝까지 직접 구현했습니다. 시중 스마트워치는 SDK를 공개하지 않아 심박 데이터를 가져올 수 없었기 때문에, ESP32-S와 심박 센서로 계측 장치를 직접 만들었습니다.

### 3-1. 임베디드 (Arduino / ESP32-S)

- `PulseSensorPlayground` 라이브러리로 심박 센서 초기화 (입력 핀 34, 임계값 550)
- Bluetooth Serial 기기명을 `"HeartBeat"`로 설정해 대기
- 1박(pulse)마다 BPM을 누적하고, 60초가 지나면 평균 BPM을 계산해 시리얼 + Bluetooth로 전송
- **예외 처리 2종**
  - 10초간 무응답 시 → 에러로 판단하고 계측 정지
  - 평균 BPM이 정상 범위(60~100)를 벗어나면 → `"WARNING"` 문자열을 Bluetooth로 전송

### 3-2. Android (`HeartActivity.java`, 약 376줄)

- `BroadcastReceiver`와 SPP UUID를 이용한 `BluetoothSocket` 연결
- `ConnectedThread`로 백그라운드에서 지속적으로 데이터 수신
- `Handler`를 통해 수신한 BPM 값을 UI 스레드로 넘겨 화면에 반영
- `"WARNING"` 수신 시 다이얼로그로 사용자에게 즉시 경고

## 4. 겪었던 문제와 해결

| 문제 | 해결 |
|---|---|
| 상용 스마트워치가 심박 데이터 접근 SDK를 제공하지 않음 | ESP32-S + 심박 센서로 계측 장치를 직접 제작 |
| Android 에뮬레이터가 Bluetooth를 지원하지 않아 테스트 불가 | 실제 기기로 검증 환경 전환 |
| 센서 통신 불량 및 측정값 편차가 큼 | 임계값과 계측 간격을 조정해 안정화 |

## 5. 성과

- 1분 계측 → 평균 BPM 산출 → Android 단말 표시까지 전체 흐름 완성
- 무응답·이상값 2계열 예외 처리 구현
- 팀 프로젝트의 핵심 기능 중 하나로 정상 동작까지 완료

## 6. 기술 스택

| 영역 | 기술 |
|---|---|
| 임베디드 | ESP32-S, Pulse/Heart Rate Sensor, Arduino(C++), PulseSensorPlayground, BluetoothSerial |
| Android | Java, BluetoothAdapter/BluetoothSocket(SPP), Handler, BroadcastReceiver |
| 서버(web) | Spring Boot, Firebase Firestore/Admin SDK |
| 팀 전체 | 공공데이터 API, Python, GitHub Actions |

## 7. 실행 전 준비

`web` 서버는 Firebase 서비스 계정 키가 필요합니다. `web/src/main/resources/firebaseKey.json.example`을 참고해 실제 키 파일(`firebaseKey.json`)을 직접 생성하세요. Android 쪽은 자신의 Firebase 프로젝트에서 발급한 `google-services.json`을 `app/app/`에 추가해야 합니다.

## 8. 실행 방법

```bash
# web
cd web && ./gradlew bootRun

# app
Android Studio로 app/ 폴더를 열어 실행
```
