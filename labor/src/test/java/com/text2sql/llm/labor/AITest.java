package com.text2sql.llm.labor;


import com.text2sql.llm.labor.business.concretes.OrderManager;
import com.text2sql.llm.labor.langchain.AiModelFactory;
import com.text2sql.llm.labor.langchain.CustomerServiceAgent;
import com.text2sql.llm.labor.langchain.Lang4jTools;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AITest {

    @Mock
    StreamingChatLanguageModel model;
    @Mock
    OrderManager order;

    @Test
    public void myTestOK() {

        ChatLanguageModel model = AiModelFactory.createOpenAIChatModel();
       // ChatLanguageModel model = AiModelFactory.createLocalChatModel();

        CustomerServiceAgent assistant = AiServices.builder(CustomerServiceAgent.class)
                .chatLanguageModel(model)
                .tools(new Lang4jTools(order))
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
        String token = assistant.chat("give the day of order most registered","1", "Order");
        System.out.println(token);

    }





}
