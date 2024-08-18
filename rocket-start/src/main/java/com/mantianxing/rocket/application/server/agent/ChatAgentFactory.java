package com.mantianxing.rocket.application.server.agent;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

import java.time.Duration;

public class ChatAgentFactory {
    private static final String  MODEL_GPT_3_5 = "gpt-3.5-turbo";

    public static <T> T chatAgent(Class<T> chatAgent, String apiKey) {
        ChatLanguageModel chatLanguageModel = OpenAiChatModel.builder()
                                                            .apiKey(apiKey)
                                                            .modelName(MODEL_GPT_3_5)
                                                            .maxRetries(2)
                                                            .temperature(0.5)
                                                            .topP(0.3)
                                                            .timeout(Duration.ofSeconds(3000))
                                                            .build();
        return AiServices.builder(chatAgent)
                .chatLanguageModel(chatLanguageModel)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(20))
                .build();
    }
}
