package spectacle.specto.ai.controller;

/**
 * Controller does 3 API tests
 * 1. View available models lists
 * 2. Check whether the model is valid
 * 3. Call prompt using the model
 */


<<<<<<< HEAD
=======
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> master
import spectacle.specto.ai.dto.CompletionRequestDto;
import spectacle.specto.ai.service.GPTService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======
import spectacle.specto.ai.service.impl.GPTServiceImpl;
>>>>>>> master

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/chatGpt")
public class GPTController {
<<<<<<< HEAD

=======
>>>>>>> master
	private final GPTService gptService;
	
	public GPTController(GPTService gptService) {
		this.gptService = gptService;
	}
<<<<<<< HEAD
	
=======

>>>>>>> master
	/**
	 * [API] 1. View available model lists
	 */
	@GetMapping("/modelList")
	public ResponseEntity<List<Map<String, Object>>> selectModelList() {
		List<Map<String, Object>> result = gptService.modelList();
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * [API] 2. Check whether the model is valid
	 *
	 * @param modelName
	 * @return
	 */
	@GetMapping("/model")
	public ResponseEntity<Map<String, Object>> isValidModel(@RequestParam(name = "modelName") String modelName) {
		Map<String, Object> result = gptService.isValidModel(modelName);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/**
	 * [API] 3. Call prompt using the model
	 */
	@PostMapping("/prompt")
	public ResponseEntity<Map<String, Object>> selectPrompt(@RequestBody CompletionRequestDto completionRequestDto) {
		Map<String, Object> result = gptService.prompt(completionRequestDto);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
