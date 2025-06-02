package com.luizgmelo.livechat.controller;

import com.luizgmelo.livechat.domain.ChatInput;
import com.luizgmelo.livechat.domain.ChatOutput;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.HtmlUtils;

@Controller
public class LiveChatController {


    @MessageMapping("new-message")
    @SendTo("/topics/livechat")
    public ChatOutput sendMessage(@RequestBody ChatInput chatInput) {
        return new ChatOutput(HtmlUtils.htmlEscape(chatInput.user() + ": " + chatInput.message()));
    }

}
