<<<<<<< HEAD
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
    
  + <u>example_code1 ; simple computation</u>
  ```
  {
    "model": "gpt-3.5-turbo-0125",
    "messages": [
        {
            "role": "user",
            "content": "what is 2+1=?"
        }
    ]
  }
  ```
  + <u>example_code2 ; short summary</u>
  ```
    {
    "model": "gpt-3.5-turbo-0125",
    "messages": [
        {
            "role": "system",
            "content": "당신의 업무는 활동 내역과 소감을 간략하게 요약하는 것입니다."
        },
        {
            "role": "user",
            "content": "세 개의 역따옴표로 구분된 텍스트를 최대 50 단어로 요약해 주세요. ```나는 이번 2023년 가을 학기에 학교 코딩 프로그래밍 대회에 참가했다. 비록 수상에는 실패했지만 java, python 등의 프로그래밍 언어를 사용하는 경험을 했으며 팀원들과 협력하는 방법에 대해 배웠다. 다음 번에 참가할 때는 수상을 목표로 준비를 해야겠다. ``` "
        }
    ]
  }
  ```
  - 정상적으로 동작할 경우 status code로 "200 OK"와 Response가 반환됨
  + <u>response_of_example1</u>
  ```
  {
    "id": "chatcmpl-92YbIG481NevTY0BMT0mYbbvv7mpu",
    "object": "chat.completion",
    "created": 1710396688,
    "model": "gpt-3.5-turbo-0125",
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "2+1 equals 3."
            },
            "logprobs": null,
            "finish_reason": "stop"
        }
    ],
    "usage": {
        "prompt_tokens": 14,
        "completion_tokens": 7,
        "total_tokens": 21
    },
    "system_fingerprint": "fp_4f0b692a78"
  }
  ```
  + <u>response_of_example2</u>
  ```
  {
    "id": "chatcmpl-954ZbjjGjWQIJGBPodw8ufRm46DMI",
    "object": "chat.completion",
    "created": 1710996247,
    "model": "gpt-3.5-turbo-0125",
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "2023년 가을, 학교 코딩 대회에 참가했지만 수상은 실패. Java, Python 사용해보고 팀원과 협력하는 법을 배웠다. 다음 대회에서는 수상을 목표로 더 열심히 준비할 예정."
            },
            "logprobs": null,
            "finish_reason": "stop"
        }
    ],
    "usage": {
        "prompt_tokens": 207,
        "completion_tokens": 86,
        "total_tokens": 293
    },
    "system_fingerprint": "fp_fa89f7a861"
  }
  ```

##### C. Cusomize GPT model

  - B에 성공한 경우 이제 completions를 엔드포인트로 사용하여 모델을 호출하는 대신,
  
=======
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
    
  + <u>example_code1 ; simple computation</u>
  ```
  {
    "model": "gpt-3.5-turbo-0125",
    "messages": [
        {
            "role": "user",
            "content": "what is 2+1=?"
        }
    ]
  }
  ```
  + <u>example_code2 ; short summary</u>
  ```
    {
    "model": "gpt-3.5-turbo-0125",
    "messages": [
        {
            "role": "system",
            "content": "당신의 업무는 활동 내역과 소감을 간략하게 요약하는 것입니다."
        },
        {
            "role": "user",
            "content": "세 개의 역따옴표로 구분된 텍스트를 최대 50 단어로 요약해 주세요. ```나는 이번 2023년 가을 학기에 학교 코딩 프로그래밍 대회에 참가했다. 비록 수상에는 실패했지만 java, python 등의 프로그래밍 언어를 사용하는 경험을 했으며 팀원들과 협력하는 방법에 대해 배웠다. 다음 번에 참가할 때는 수상을 목표로 준비를 해야겠다. ``` "
        }
    ]
  }
  ```
  - 정상적으로 동작할 경우 status code로 "200 OK"와 Response가 반환됨
  + <u>response_of_example1</u>
  ```
  {
    "id": "chatcmpl-92YbIG481NevTY0BMT0mYbbvv7mpu",
    "object": "chat.completion",
    "created": 1710396688,
    "model": "gpt-3.5-turbo-0125",
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "2+1 equals 3."
            },
            "logprobs": null,
            "finish_reason": "stop"
        }
    ],
    "usage": {
        "prompt_tokens": 14,
        "completion_tokens": 7,
        "total_tokens": 21
    },
    "system_fingerprint": "fp_4f0b692a78"
  }
  ```
  + <u>response_of_example2</u>
  ```
  {
    "id": "chatcmpl-954ZbjjGjWQIJGBPodw8ufRm46DMI",
    "object": "chat.completion",
    "created": 1710996247,
    "model": "gpt-3.5-turbo-0125",
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "2023년 가을, 학교 코딩 대회에 참가했지만 수상은 실패. Java, Python 사용해보고 팀원과 협력하는 법을 배웠다. 다음 대회에서는 수상을 목표로 더 열심히 준비할 예정."
            },
            "logprobs": null,
            "finish_reason": "stop"
        }
    ],
    "usage": {
        "prompt_tokens": 207,
        "completion_tokens": 86,
        "total_tokens": 293
    },
    "system_fingerprint": "fp_fa89f7a861"
  }
  ```

##### C. Cusomize GPT model

  - B에 성공한 경우 이제 completions를 엔드포인트로 사용하여 모델을 호출하는 대신,
  
>>>>>>> master
