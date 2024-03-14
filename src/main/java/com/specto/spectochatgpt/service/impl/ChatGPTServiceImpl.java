package com.specto.spectochatgpt.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.multiflex.multiflexchatgpt.config.ChatGPTConfig;
import com.multiflex.multiflexchatgpt.dto.ChatCompletionDto;
import com.multiflex.multiflexchatgpt.dto.CompletionDto;
import com.multiflex.multiflexchatgpt.service.ChatGPTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ChatGPT Service 구현체
 * 
 * @author : syp
 * @fileName : ChatGPTServiceimpl
 */
@Slf4j
@Service
public class ChatGPTServiceImpl implements com.specto.spectochatgpt.service.ChatGPTService {
    
    private final com.specto.spectochatgpt.config.ChatGPTConfig chatGPTConfig;

    public ChatGPTServiceImpl(com.specto.spectochatgpt.config.ChatGPTConfig chatGPTConfig) {
        this.chatGPTConfig = chatGPTConfig;
    }

    @Value("${openai.url.model}")
    private String modelUrl;

    @Value("${openai.url.model-list}")
    private String modelListUrl;

    @Value("${openai.url.prompt}")
    private String promptUrl;

    @Value("${openai.url.legacy-prompt}")
    private String legacyPromptUrl;

    /**
     * 사용 가능한 모델 리스트를 조회하는 business logic
     * 
     * @return List<Map < String, Object>>
     */
    @Override
    public List<Map<String, Object>> modelList() {
        log.debug("[+] 모델 리스트 조회");
        List<Map<String, Object>> resultList = null;

        // [STEP 1] 토큰 정보가 포함된 header 가져오기
        HttpHeaders headers = chatGPTConfig.httpHeaders();

        // [STEP 2] 통신을 위한 RestTemplate 구성하기
        ResponseEntity<String> response = chatGPTConfig
                .restTemplate()
                .exchange(modelUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);

        try{
            // [STEP 3] Jackson을 기반으로 응답값 가져오기
            ObjectMapper om = new ObjectMapper();
            Map<String, Object> data = om.readValue(response.getBody(), new TypeReference<>() {
            });

            // [STEP 4] 응답값을 결과값에 넣고 출력하기
            resultList = (List<Map<String, Object>>) data.get("data");
            for (Map<String, Object> object : resultList) {
                log.debug("ID : " + object.get("id"));
                log.debug("Obejct : " + object.get("object"));
                log.debug("Created : " + object.get("created"));
                log.debug("Owned By : " + object.get("owned_by"));
            }
        } catch (JsonMappingException e) {
            log.debug("JsonMappingException :: " + e.getMassage());
        } catch (JsonProcessingException e) {
            log.debug("JsonProcessingException :: " + e.getMassage());
        }
        return resultList;
    }


}
