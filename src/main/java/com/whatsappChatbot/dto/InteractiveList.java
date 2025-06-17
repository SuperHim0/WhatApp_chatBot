package com.whatsappChatbot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class InteractiveList {
    private String type = "list";
    private Header header;
    private Body body;
    private Footer footer;
    private ListAction action;
}
