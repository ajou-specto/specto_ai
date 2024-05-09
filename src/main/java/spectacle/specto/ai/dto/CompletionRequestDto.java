package spectacle.specto.ai.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CompletionRequestDto {

	private String model;
	private String prompt;
	private float temperature;
	//private int maxTokens;
	//private int topP;
	//private int frequencyPenalty;
	//private int presencePenalty;
	
	@Builder
	CompletionRequestDto(String model, String prompt, float temperature) {
		this.model = model;
		this.prompt = prompt;
		this.temperature = temperature;
	}
	
}
