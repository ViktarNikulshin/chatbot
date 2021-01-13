package com.pst.chatbot.telegram;


import com.pst.chatbot.dto.CityDto;
import com.pst.chatbot.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@RequiredArgsConstructor
public class Bot extends TelegramLongPollingBot {
    @Value("${bot.name}")
    private String botName;
    @Value("${bot.token}")
    private String botToken;

    private final CityService cityService;

    @Override
    public void onUpdateReceived(Update update) {
        System.out.println(update.getMessage().getText());
        CityDto cityDto = cityService.getCityByName(update.getMessage().getText());
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(update.getMessage().getChatId()));
        if(cityDto.getCityName() == null){
            message.setText("Про этот город я ничего не знаю");
        } else {
            message.setText(cityDto.getDescription());
        }
        try {
            execute(message);
        } catch (TelegramApiException e) {

            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botName;
    }
}
