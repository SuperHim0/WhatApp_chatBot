package com.whatsappChatbot.API;


import com.whatsappChatbot.dto.ChatRequest;
import com.whatsappChatbot.dto.WhatsAppListMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Component
public class SendWhatsAppMessage {

    public void sendWhatsAppMessage( String accessToken, String phoneNumberId) {
        String url = "https://graph.facebook.com/v22.0/" + phoneNumberId + "/messages";

        // Prepare headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        // Prepare the request body
        Map<String, Object> template = new HashMap<>();
        template.put("name", "hello_world");

        Map<String, String> language = new HashMap<>();
        language.put("code", "en_US");

        template.put("language", language);
        ChatRequest req = new ChatRequest();
        Map<String, Object> body = new HashMap<>();
        body.put("messaging_product", "whatsapp");
        body.put("to", req.getPhone());  // e.g., "917048945773"
        body.put("type", "template");
        body.put("template", template);

        // Create HTTP Entity
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

        // Send request
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);

        // Output response
        System.out.println("Response Status: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody());
    }

}
