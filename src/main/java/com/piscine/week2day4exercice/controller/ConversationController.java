package com.piscine.week2day4exercice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.piscine.week2day4exercice.entity.Conversation;
import com.piscine.week2day4exercice.service.ConversationService;

@RestController
@RequestMapping("/api")
public class ConversationController {

    private final ConversationService conversationService;
    
    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }


    @PostMapping("/prompts")
    public String saveConversation(@RequestParam String question) {
        Conversation conversation = conversationService.saveConversation(question);
        return conversation.getResponse();
    }

    @GetMapping("/conversations")
    public List<Conversation> getAllConversations() {
        return conversationService.getAllConversations();
    }

}
