# WhatsApp ChatBot 🤖📱

A Java + Spring Boot based chatbot for WhatsApp using the Meta WhatsApp Business Cloud API. This bot can send, receive, and respond to user messages intelligently. It is deployed on [Render](https://render.com) and integrated with Firebase for logging or data storage.

## 🚀 Features

- Send and receive messages via WhatsApp using Meta Cloud API
- Interactive replies (buttons, quick replies)
- Webhook to handle incoming messages
- Uses permanent access token and WhatsApp Business ID
- Firebase integration for data persistence (optional)
- Spring Boot RESTful API for external triggers
- Deployed on Render (or any preferred cloud platform)

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Meta WhatsApp Business Cloud API
- Firebase (optional)
- Render (deployment)
- Maven

## 🧾 Setup & Installation

### 1. Clone the Repository
git clone https://github.com/your-username/whatsapp-chatbot.git
cd whatsapp-chatbot

### 2. Set Environment Variables
Create a .env or use application.properties:

WHATSAPP_TOKEN=YOUR_PERMANENT_ACCESS_TOKEN
PHONE_NUMBER_ID=YOUR_PHONE_NUMBER_ID

## 3. Build & Run the Project
deploy on render or use ngrok http 8080 after run on localhost to expose to internet so it can send messagae

## Live Link of chat bot :-
https://api.whatsapp.com/send/?phone=%2B917701892011&text&type=phone_number&app_absent=0.

## 📹 Demo

[Click here to watch the demo video](WhatsAppChatbotWroking.mp4)
