package com.whatsappChatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class WhatAppMessageDefaultResponse {
    private String messaging_product = "whatsapp";
    private String recipient_type="individual";
    private String to;
    private String type= "text";
    private Text text;
}
