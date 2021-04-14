package com.github.oldmermaidman.javarushTtelegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.github.oldmermaidman.javarushTtelegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;

@DisplayName("Unit-level testing for UnknownCommand")
public class UnknownCommandTest extends AbstractCommandTest {

    @Override
    String getCommandName() {
        return "/lsfjso";
    }

    @Override
    String getCommandMessage() {
        return UNKNOWN_MESSAGE;
    }

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }
}
