package spectacle.specto.ai.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
>>>>>>> master
import spectacle.specto.ai.config.GPTConfig;
import spectacle.specto.ai.dto.CompletionRequestDto;
import spectacle.specto.ai.service.GPTService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.HashMap;
=======
>>>>>>> master
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GPTServiceImpl implements GPTService {
<<<<<<< HEAD
	
=======
>>>>>>> master
	private final GPTConfig gptConfig;
	
	public GPTServiceImpl(GPTConfig gptConfig) {
		this.gptConfig = gptConfig;
	}
	
<<<<<<< HEAD
	@Value("${openai.model}")
=======
	@Value("${gpt.model}")
>>>>>>> master
	private String model;
	
	/**
	 * Business logic to view available model list
	 * @return
	 */	
	@Override
	public List<Map<String, Object>> modelList() {
		log.debug("[+] View model lists ");
		List<Map<String, Object>> resultList = null;
		
		// [STEP1] Get header including token information
		HttpHeaders headers = gptConfig.httpHeaders();
		
<<<<<<< HEAD
		// [STEP2] Construct RestTemplate for communication
		ResponseEntity<String> response = gptConfig.restTemplate()
				.exchange(
						"<https://api.openai.com/v1/models>",
						HttpMethod.GET,
						new HttpEntity<>(headers),
						String.class);
		
		try {
			// [STEP3] Get response based on jackson
			ObjectMapper om = new ObjectMapper();
			List<Map<String, Object>> data = om.readValue(response.getBody(), new TypeReference<>() {
			});
			
			// [STEP4] Pass response to result and print it
			resultList = (List<Map<String, Object>>)data.get("data");
			for (List<Map<String, Object>> object : resultList) {
				log.debug("ID: " + object.get("id"));
				log.debug("Object: " + object.get("object"));
				log.debug("Created: " + object.get("created"));
				log.debug("Owend by: " + object.get("owned_by"));
			}
		} catch (JsonMappingException e) {
			log.debug("JsonMappingException :: " + e.getMessage());
		} catch (JsonProcessingException e) {
			log.debug("RuntimeException :: " + e.getMessage());
		}
		return resultList;
		
	}
	
	@Override
	public List<Map<String, Object>> isValidModel(String modelName) {
		log.debug("[+] Check whether the model is valid. Model : "+modelName);
		List<Map<String, Object>> result;
	
		// [STEP1] Get header including token information
		HttpHeaders headers = gptConfig.httpHeaders();
		
		// [STEP2] Construct RestTemplate for communication
		ResponseEntity response = gptConfig.restTemplate()
				.exchange(
						"<https://api.openai.com/v1/models/>" + modelName,
						HttpMethod.GET,
						new HttpEntity<>(headers),
						String.class);
		try {
			// [STEP3] Get response based on jackson
			ObjectMapper om = new ObjectMapper();
			result = om.readValue(response.getBody(), new TypeReference<>() {
			});
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>> prompt(CompletionRequestDto completionRequestDto) {
		log.debug("[+] Run prompt ");
		
		List<Map<String, Object>> result = new HashMap<>();
=======
		try {
			// [STEP2] Construct RestTemplate for communication
			ResponseEntity<String> response = gptConfig.restTemplate()
					.exchange(
							"https://api.openai.com/v1/models",
							HttpMethod.GET,
							new HttpEntity<>(headers),
							String.class);
			// [STEP3] Get response based on jackson
			log.info(response.getBody());
			ObjectMapper om = new ObjectMapper();  // Json parser or builder = jackson
			Map<String, Object> resp = om.readValue(response.getBody(), new TypeReference<>() {});

			// [STEP4] Pass response to result and print it
			resultList = (List<Map<String, Object>>)resp.get("data");
			for (Map<String, Object> object : resultList) {
				log.info("ID: " + object.get("id"));
				log.info("Object: " + object.get("object"));
				log.info("Created: " + object.get("created"));
				log.info("Owend by: " + object.get("owned_by"));
			}

			return resultList;
		} catch (JsonMappingException e) {
			log.info("JsonMappingException :: " + e.getMessage());
		} catch (JsonProcessingException e) {
			log.info("RuntimeException :: " + e.getMessage());
		}
		return null;
	}
	
	@Override
	public Map<String, Object> isValidModel(String modelName) {
		log.debug("[+] Check whether the model is valid. Model : "+modelName);
		Map<String, Object> result;
	
		// [STEP1] Get header including token information
		HttpHeaders headers = gptConfig.httpHeaders();

		try {
			// [STEP2] Construct RestTemplate for communication
			ResponseEntity<String> response = gptConfig.restTemplate()
					.exchange(
							"https://api.openai.com/v1/models/" + modelName,
							HttpMethod.GET,
							new HttpEntity<>(headers),
							String.class);
			// [STEP3] Get response based on jackson
			ObjectMapper om = new ObjectMapper();
			result = om.readValue(response.getBody(), new TypeReference<>() {});
			return result;
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Map<String, Object> prompt(CompletionRequestDto completionRequestDto) {
		log.debug("[+] Run prompt ");
		
		Map<String, Object> result;
>>>>>>> master
		
		// [STEP1] Get headers including token information
		HttpHeaders headers = gptConfig.httpHeaders();
		
		String requestBody = "";
		ObjectMapper om = new ObjectMapper();
		
		// [STEP2] Get model from application.properties and insert into object
<<<<<<< HEAD
		completionRequestDto = completionRequestDto.builder()
=======
		// ObjectMapper로 JSON 만들기
		ObjectNode rootNode = om.createObjectNode();
		rootNode.put("model", model);
		ArrayNode messages = om.createArrayNode();
		ObjectNode msg1 = om.createObjectNode();
		msg1.put("role", "user");
		msg1.put("content", completionRequestDto.getPrompt());
		messages.add(msg1);
		rootNode.set("messages", messages);

		/*
		completionRequestDto = CompletionRequestDto.builder()
>>>>>>> master
				.model(model)
				.prompt(completionRequestDto.getPrompt())
				.temperature(0.8f)
				.build();
<<<<<<< HEAD
		
		try {
			// [STEP3] Serialize Object -> String
			requestBody = om.writeValueAsString(completionRequestDto);
=======
		*/
		try {
			// [STEP3] Serialize Object -> String
			requestBody = om.writeValueAsString(rootNode);
>>>>>>> master
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		
		// [STEP4] Construct RestTemplate for communication
<<<<<<< HEAD
		HttpEntity requestEntity = new HttpEntity<>(completionRequestDto, headers);
		ReponseEntity response = gptConfig.restTemplate()
				.exchange(
						"<https://api.openai.com/v1/completions>",
						HttpMethod.POST,
						requestEntity,
						String.class);
			try {
				// [STEP5] Construct String -> HashMap linear connection
				result = om.readValue(response.getBody(), new TypeReference<>() {
				});
			} catch (JsonProcessingException e) {
				throw new RuntimeException(e);
			}
			return result;
=======
		HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);
		ResponseEntity<String> response = gptConfig.restTemplate()
				.exchange(
						"https://api.openai.com/v1/chat/completions",
						HttpMethod.POST,
						requestEntity,
						String.class);
		try {
			// [STEP5] Construct String -> HashMap linear connection
			result = om.readValue(response.getBody(), new TypeReference<>() {});

			List choices = (List)result.get("choices");
			if (choices != null && !choices.isEmpty()) {
				Map<String, Object> choice = (Map<String, Object>)choices.get(0);
				Map<String, Object> message = (Map<String, Object>)choice.get("message");
				return message;
				//return list;
			}
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
		return null;
>>>>>>> master
	}	
}
