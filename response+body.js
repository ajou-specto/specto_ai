{
    "id": [String],
    "object": "chat.completion",
    "created": [long],
    "model": "gpt-3.5-turbo-0125" 또는 "gpt-3.5-turbo",
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