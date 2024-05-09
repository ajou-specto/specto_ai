package spectacle.specto.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GPTResponse {

    private List<Choice> choices;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {
        /*GPT chat index number*/ 
        private int index;

        /* 
        * Messages from GPT
        * Content equales to response of GPT 
        */
        private Message message;
    }
}