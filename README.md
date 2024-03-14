# specto_ai

Specto AI 기능 명세서

### 기능 요약

  - 회고록에 작성한 텍스트 정보 __요약__

  - 스펙 활동 유형별로 템플릿 __추천 및 자동생성__


### 평가 요소

##### A. ChatGPT model execution

  - 효과적인 프롬프트 테스트 및 선정을 위한 과정

  - 요약 기능의 매커니즘과 키워드 선별 기준 판별하기

  - 적절한 요약을 위한 최소한의 텍스트 정보 분량 평가하기

##### B. ChatGPT - Server(BE) interlock test
 
  - ChatGPT API가 백엔드 환경에서 정상적으로 실행되는지 평가
  - POSTMAN과 openaiAPI를 사용
  - <u>검사 방법</u>
    - openai API key 생성
    - POSTMAN을 POST로 설정 후 end-point로 _'https://api.openai.com/v1/chat/completions'_ 입력
    - POSTMAN에 생성한 API Key를 인증키로 등록 또는 헤더로 입력 (_값으로 Bearer+Key value 전달_)
    - 헤더에 Content Type으로 application/json 추가
    - json으로 body에 model, message(role, content) 작성하여 전송
    - 정상적으로 동작할 경우 model parameter들이 반환됨

##### C. Cusomize GPT model

  - B에 성공한 경우 
