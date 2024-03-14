package com.specto.spectochatgpt.dto;

import lombok.*;

/**
 * prompt request DTO : gpt-3.5-turbo-instruct, babbage-002, davinci-002
 * 
 * @author : syp
 * @fileName : CompletionDto
 */
@Getter
@ToString
@NoArgsConstructor(access = AccesLevel.PROTECTED)
public class CompletionDto {
    
    //사용할 모델
    private String model;

    //사용할 prompt 명령어
    private String prompt;

    //prompt_diversity setting (default = 1)
    private float temperature = 1;

    //max_token setting (default = 16)
    private int max_tokens = 16;

    @Builder
    public CompletionDto(String model, String prompt, float temperature, int max_tokens) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
        this.max_tokens = max_tokens;
    }
}
