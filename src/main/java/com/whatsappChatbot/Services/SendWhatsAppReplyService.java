package com.whatsappChatbot.Services;

import com.whatsappChatbot.API.SendWhatsAppButtonMessage;
import com.whatsappChatbot.dto.ChatRequest;
import com.whatsappChatbot.dto.WhatsAppListMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SendWhatsAppReplyService {

    @Autowired
    private WhatsAppChatResponseService whatsAppChatResponseService;

    @Autowired
    private SendWhatsAppButtonMessage sendWhatsAppButtonMessage;

    @Value("${WHATSAPP_ACCESS_TOKEN}")
    private String accessToken;

    @Value("${WHATSAPP_PHONE_NUMBER_ID}")
    private String phoneNumberId;

    public void sendMessageToUser(ChatRequest request) {
        // Check user message
        if (request.getMessage().equalsIgnoreCase("hi")) {

            // Get WhatsApp list message structure
            ResponseEntity<WhatsAppListMessageResponse> responseEntity =
                    whatsAppChatResponseService.WhatsAppChatWithListService(request);

            // Send WhatsApp message via Meta API
            sendWhatsAppButtonMessage.sendWhatsAppListMessage(
                    responseEntity.getBody(), accessToken, phoneNumberId
            );

        } else {
            System.out.println("Only responding to message: 'hi'");
        }
    }
}
