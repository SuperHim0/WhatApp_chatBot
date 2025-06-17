package com.whatsappChatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class ChatResponse {
    private String to;
    private String interactiveType;
    private String headerType;
    private String headerText;
    private String bodyText;
    private String footerText;

}
