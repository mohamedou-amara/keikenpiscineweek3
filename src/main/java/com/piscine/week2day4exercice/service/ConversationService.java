package com.piscine.week2day4exercice.service;


import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.piscine.week2day4exercice.entity.Conversation;
import com.piscine.week2day4exercice.repository.ConversationRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ConversationService {


    private final ConversationRepository conversationRepository;


    private final Gpt3ApiService gpt3ApiService;

    public ConversationService(ConversationRepository conversationRepository, Gpt3ApiService gpt3ApiService) {
        this.conversationRepository = conversationRepository;
        this.gpt3ApiService = gpt3ApiService;
    }

    public Conversation saveConversation(String question) {
        Conversation conversation = new Conversation();
        conversation.setTimestamp(LocalDateTime.now());
        conversation.setQuestion(question);
        String apiResponse = gpt3ApiService.getResponse(question);
        String response = extractTextFromApiResponse(apiResponse);
        conversation.setResponse(response);
        return conversationRepository.save(conversation);
    }

    private String extractTextFromApiResponse(String apiResponse) {
        System.out.println(apiResponse);
        JSONObject jsonObject = new JSONObject(apiResponse);
        JSONArray choices = jsonObject.getJSONArray("choices");
        JSONObject choice = choices.getJSONObject(0);
        return choice.getString("text");
    }


    public List<Conversation> getAllConversations() {
        return conversationRepository.findAll();
    }
}
