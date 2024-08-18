package com.mantianxing.rocket.application.controller;

import com.mantianxing.rocket.application.server.agent.ChatAgentFactory;
import com.mantianxing.rocket.application.server.agent.CommentAgent;
import com.mantianxing.rocket.application.server.dataObject.CommentsDO;
import com.mantianxing.rocket.application.server.mapper.CommentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private CommentsMapper commentsMapper;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/testMysql")
    @ResponseBody
    public CommentsDO comments() {
        List<CommentsDO> comments = commentsMapper.query(new CommentsDO());
        return Optional.ofNullable(comments).map(it ->it.get(0)).orElse(null);
    }

    @RequestMapping("/testGpt")
    @ResponseBody
    public String gpt() {
        String content = request.getParameter("content");

        String apiKey = request.getParameter("apiKey");

        return ChatAgentFactory.chatAgent(CommentAgent.class, apiKey)
                .chat(content);
    }

}
