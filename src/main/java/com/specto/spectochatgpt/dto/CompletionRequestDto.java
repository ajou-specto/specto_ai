package com.specto.spectochatgpt.dto;

import lombok.AccesLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * prompt request Dto
 * 
 * @author : syp
 * @fileName : CompletionRequestDto
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompletionRequestDto {

    private String model;

    private String prompt;
    
    private float temperature;

    @Builder
    CompletionRequestDto(String model, String prompt, float temperature) {
        this.model = model;
        this.prompt = prompt;
        this.temperature = temperature;
    }
    
}
