package com.github.oldmermaidman.javarushTtelegrambot.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.util.Assert;

import java.util.Arrays;

public class CommandContainerTest {
    private CommandContainer commandContainer;

    public void init(){
        SendBotMessageServiceImpl sendBotMessageService = Mockito.mock(SendBotMessageServiceImpl.class);
        this.commandContainer = new CommandContainer(sendBotMessageService);
    }

    @Test
    public void shouldGetAllExistingCommand(){
        Arrays.stream(CommandName.values())
                .forEach(commandName -> {
                    Command command = commandContainer.retrieveCommand(commandName.getCommandName());
                    Assertions.assertNotEquals(command.getClass(), UnknownCommand.class);
                });
    }

    @Test
    public void shouldGetUnknownCommand(){
        String commandName = "/tufta";
        Command command = commandContainer.retrieveCommand(commandName);
        Assertions.assertEquals(UnknownCommand.class, command.getClass());
    }
}
