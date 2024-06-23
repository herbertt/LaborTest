package com.text2sql.llm.labor.langchain;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;

import java.time.Duration;

public class AiModelFactory {

    private AiModelFactory() {
        throw new IllegalStateException("Factory class shouldn't be instantiated");
    }

    public static ChatLanguageModel createOpenAIChatModel() {
        return OpenAiChatModel.builder()
                .modelName("gpt-3.5-turbo")
                .apiKey("demo")
                .logRequests(true)
                .build();
    }

}
