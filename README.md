# specto_ai
Specto AI 기능 명세서
- 회고록 작성에의 AI, 그중에서도 GPT 응용 모델 활용을 목표로 준비

## 핵심 기능
  - 회고록에 작성한 텍스트 정보를 요약
  - 스펙 활동 유형별로 템플릿 추천 및 자동생성

## 세부 기능
### 기존의 GPT model test
  - 효과적인 prompt가 무엇인지 테스트 & 선정
  - 문단의 크기별로 요약 능력이 달라지는지 검사하기

### GPT implementation
  - API key 생성
  - AI VM와 python program install
  - env와 gitignore file 설정
  - openai API import하기
  - API 정상 작동 여부 테스트
  - GPT model install
  - query 생성
  - query 정상 전달 여부 & 응답 수신 여부 검사하기
  - 올바른 응답이 수신되었는지 검토
  - 기존에 선정한 prompt에 맞추어 prompt programming 진행
  - 위의 query 생성~응답 검토 과정 반복
  - 효과적인 query 생성을 위한 키워드 추출
  - 사용자에게 추출한 키워드를 언제, 어떻게 전달할지 결정 (w.BE 개발자)
  - GPT run-time 측정 및 run-time 개선 방안 수집하기
  - 다양한 방법으로 run-time 개선 테스트하기 (러프 단계)

  - GPT의 템플릿 생성 기능 평가하기
  - 적절한 템플릿 선정
  - 해당 템플릿을 도출한 query/prompt 그대로 저장하기
  - 템플릿 추천 quest가 들어오면 저장한 query를 그대로 전달하도록 BE와 연계
  - 목표 기능 테스트 및 피드백
  - 해당 기능 포함 여부 최종 결정
