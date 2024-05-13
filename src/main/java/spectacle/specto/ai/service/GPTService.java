package spectacle.specto.ai.service;

import spectacle.specto.ai.dto.CompletionRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface GPTService {

	List<Map<String, Object>> modelList();
	
	Map<String, Object> prompt(CompletionRequestDto completionRequestDto);
	
	Map<String, Object> isValidModel(String modelName);
	
}
