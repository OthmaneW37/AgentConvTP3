package ma.emsi.othmanemoussawi.tp3othmanemoussawi.llm;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.Dependent;

import java.io.Serializable;

/**
 * Gère l'interface avec le LLM (Gemini) pour le guide touristique.
 */
@Dependent
public class LlmClientForGuideTouristique implements Serializable {

    private GuideTouristique guideTouristique;

    public LlmClientForGuideTouristique() {
        String llmKey = System.getenv("GEMINI_KEY");

        ChatModel model = GoogleGenAiChatModel.builder()
                .apiKey(llmKey)
                .modelName("gemini-3.5-flash-lite")
                .responseFormat(ResponseFormat.JSON)
                .build();

        this.guideTouristique = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }

    /**
     * Demande au LLM des informations touristiques sur une ville ou un pays.
     *
     * @param villeOuPays nom de la ville ou du pays.
     * @return la réponse du LLM au format JSON.
     */
    public String envoyerRequete(String villeOuPays) {
        return this.guideTouristique.chat(villeOuPays);
    }
}