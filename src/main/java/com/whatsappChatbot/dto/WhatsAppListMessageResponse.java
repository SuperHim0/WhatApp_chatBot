package com.whatsappChatbot.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter

public class WhatsAppListMessageResponse {
    private String messaging_product = "whatsapp";
    private String recipient_type = "individual";
    private String to;
    private String type = "interactive";
    private InteractiveList interactive;
}
