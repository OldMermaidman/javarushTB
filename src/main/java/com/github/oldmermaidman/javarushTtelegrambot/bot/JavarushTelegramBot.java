package com.github.oldmermaidman.javarushTtelegrambot.bot;

import com.github.oldmermaidman.javarushTtelegrambot.command.CommandContainer;
import com.github.oldmermaidman.javarushTtelegrambot.command.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;


import static com.github.oldmermaidman.javarushTtelegrambot.command.CommandName.NO;

/**
 * Telegrambot for Javarush Community from Javarush community.
 */
@Component
public class JavarushTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    private final CommandContainer commandContainer;

    public JavarushTelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}



