package com.whatsappChatbot.Services;

import com.whatsappChatbot.API.SendWhatsAppMessages;
import com.whatsappChatbot.dto.ChatRequest;
import com.whatsappChatbot.dto.WhatAppMessageDefaultResponse;
import com.whatsappChatbot.dto.WhatsAppListMessageResponse;
import com.whatsappChatbot.dto.WhatsAppMessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SendWhatsAppReplyService {

    @Autowired
    private WhatsAppChatResponseService whatsAppChatResponseService;

    @Autowired
    private SendWhatsAppMessages sendWhatsAppMessage;


    @Value("${WHATSAPP_ACCESS_TOKEN}")
    private String accessToken;

    @Value("${WHATSAPP_PHONE_NUMBER_ID}")
    private String phoneNumberId;

    public void sendMessageToUser(ChatRequest request) {
        // Check user message
        System.out.println("your msg is :"+request.getMessage());
        System.out.println("your token is :"+accessToken);
        System.out.println("your phone is :"+phoneNumberId);

        if (request.getMessage().equalsIgnoreCase("hi")
                || request.getMessage().equalsIgnoreCase("hey") || request.getMessage().equalsIgnoreCase("hello")
                || request.getMessage().equalsIgnoreCase("hiii")) {

            //getting whatApp default messages
            WhatAppMessageDefaultResponse whatAppMessageDefaultResponse = whatsAppChatResponseService.whatAppMessageDefaultResponse(request);
            //sending via api
            sendWhatsAppMessage.sendWhatsAppDefaultMessage(whatAppMessageDefaultResponse,accessToken,phoneNumberId);
            // Get WhatsApp button message structure
            ResponseEntity<WhatsAppMessageResponse> response =
                    whatsAppChatResponseService.whatsAppChatWithButtonsService(request);
            System.out.println("getting msg done calling api");
            // Send WhatsApp message via Meta API
            sendWhatsAppMessage.sendWhatsAppButtonMessage(
                    response.getBody(), accessToken, phoneNumberId
            );
        }
        else if (request.getMessage().equalsIgnoreCase("contact me")) {
            // get msg
            String textMessage = "Thank you! for message me. you can contact me by a main himanshu2022kumar@gmail.com or can call on 7048945773 ";
            WhatAppMessageDefaultResponse whatAppMessageDefaultResponse = whatsAppChatResponseService.whatAppMessageResponse(request, textMessage);
            //send by api
            sendWhatsAppMessage.sendWhatsAppTextMessage(whatAppMessageDefaultResponse,accessToken,phoneNumberId);
        } else if (request.getMessage().equalsIgnoreCase("services") || (request.getMessage().equalsIgnoreCase("service"))) {
            //get msg
            WhatsAppListMessageResponse whatsAppListMessageResponse = whatsAppChatResponseService.whatsAppChatWithListService(request);
            //send by api
            sendWhatsAppMessage.sendWhatsAppListMessage(whatsAppListMessageResponse,accessToken,phoneNumberId);
        } else {
            String textMessage = "Hey there! \n I'm unable to understand your query. Please select one of the buttons below so I can Assist you quickly!";

            WhatAppMessageDefaultResponse whatsAppMessageResponse = whatsAppChatResponseService.whatAppMessageResponse(request, textMessage);

//            sendWhatsAppMessage.sendWhatsAppMessage( accessToken, phoneNumberId);
            sendWhatsAppMessage.sendWhatsAppTextMessage(whatsAppMessageResponse,accessToken,phoneNumberId);

            System.out.println("Only responding to message: 'hi'");
        }
    }
}
