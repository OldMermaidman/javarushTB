package com.github.oldmermaidman.javarushTtelegrambot.service;

import com.github.oldmermaidman.javarushTtelegrambot.bot.JavarushTelegramBot;
import com.github.oldmermaidman.javarushTtelegrambot.command.SendBotMessageServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Util-level testing for SendBotMessageService")
public class SendBotMessageServiceTest {
    private SendBotMessageServiceImpl sendBotMessageService;
    private JavarushTelegramBot javarushTelegramBot;

    @BeforeEach
    public void init(){
        javarushTelegramBot = Mockito.mock(JavarushTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(javarushTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "ChatID";
        String message = "Message";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(javarushTelegramBot).execute(sendMessage);
    }
}
