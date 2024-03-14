package com.specto.spectochatgpt.dto;

import lombok.*;

/**
 * Explaining the class
 * 
 * @author : syp
 * @fileName : ChatRequestMsgDto
 */
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class ChatRequestMsgDto {

    private String role;

    private String content;

    @Builder
    public ChatRequestMsgDto(String role, String content) {
        this.role = role;
        this.content = content;
    }
    
}
