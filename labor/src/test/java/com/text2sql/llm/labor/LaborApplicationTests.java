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
class LaborApplicationTests {
	@Test
	void contextLoads() {
	}

}
