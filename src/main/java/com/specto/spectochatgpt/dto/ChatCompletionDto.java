package com.specto.spectochatgpt.dto;

import lombok.*;

import java.util.List;

/**
 * 새로운 모델에 대한 Request Object 관리 : gpt-4, gpt-4 turbo, gpt-3.5-turbo
 * 
 * @author : syp
 * @fileName : ChatCompletionDto
 */
@Getter
@ToString
@NoArgsConstructor(access = AccesLevel.PROTECTED)
public class ChatCompletionDto {

    //사용할 모델
    private String model;

    private List<ChatRequestMsgDto> messages;

    @Builder
    public ChatCompletionDto(String model, List<ChatRequestMsgDto> messages) {
        this.model = model;
        this.messages = messages;
    }
    
}
