package com.whatsappChatbot.API;


import com.whatsappChatbot.dto.WhatAppMessageDefaultResponse;
import com.whatsappChatbot.dto.WhatsAppListMessageResponse;
import com.whatsappChatbot.dto.WhatsAppMessageResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;


@Component
public class SendWhatsAppMessages {
    public void sendWhatsAppListMessage(WhatsAppListMessageResponse requestBody, String accessToken, String phoneNumberId) {
        System.out.println("sending msg to url");
        String url = "https://graph.facebook.com/v22.0/"+phoneNumberId+"/messages";
        System.out.println("ph :"+phoneNumberId);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<WhatsAppListMessageResponse> request = new HttpEntity<>(requestBody, headers);
        System.out.println(request);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            System.out.println("Response: " + response.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("Error from api : " + e.getResponseBodyAsString());
            e.printStackTrace();

        }
    }

    public void sendWhatsAppButtonMessage(WhatsAppMessageResponse requestBody, String accessToken, String phoneNumberId) {
        System.out.println("sending msg to url");
        String url = "https://graph.facebook.com/v22.0/"+phoneNumberId+"/messages";
        System.out.println("ph :"+phoneNumberId);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<WhatsAppMessageResponse> request = new HttpEntity<>(requestBody, headers);
        System.out.println(request);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            System.out.println("Response: " + response.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("Error from api : " + e.getResponseBodyAsString());
            e.printStackTrace();

        }
    }

    public void sendWhatsAppDefaultMessage(Map<String,Object> requestBody, String accessToken, String phoneNumberId) {
        System.out.println("sending msg to url");
        String url = "https://graph.facebook.com/v22.0/"+phoneNumberId+"/messages";
        System.out.println("ph :"+phoneNumberId);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<Map<String,Object>> request = new HttpEntity<>(requestBody, headers);
        System.out.println(request);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            System.out.println("Response: " + response.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("Error from api : " + e.getResponseBodyAsString());
            e.printStackTrace();

        }
    }

    public void sendWhatsAppTextMessage(Map<String,Object> requestBody, String accessToken, String phoneNumberId) {
        System.out.println("sending msg to url");
        String url = "https://graph.facebook.com/v22.0/"+phoneNumberId+"/messages";
        System.out.println("ph :"+phoneNumberId);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<Map<String,Object>> request = new HttpEntity<>(requestBody, headers);
        System.out.println(request);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            System.out.println("Response: " + response.getBody());
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.err.println("Error from api : " + e.getResponseBodyAsString());
            e.printStackTrace();

        }
    }

}
