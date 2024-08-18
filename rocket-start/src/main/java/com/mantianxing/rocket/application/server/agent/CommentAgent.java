package com.mantianxing.rocket.application.server.agent;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface CommentAgent {

    @UserMessage("this is a test:{{content}}")
    String chat(@V("content") String content);
}
