package com.specto.spectochatgpt.service;

import com.specto.spectochatgpt.dto.ChatCompletionDto;
import com.specto.spectochatgpt.dto.CompletionDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ChatGPT service interface
 * 
 * @author : syp
 * @fileName : ChatGPTService
 */

@Service
public interface ChatGPTService {

    List<Map<String, Object>> modelList();

    Map<String, Object> isValidModel(String modelName);
    
    Map<String, Object> legacyPrompt(CompletionDto completionDto);

    Map<String, Object> prompt(ChatCompletionDto chatCompletionDto);
    
}
