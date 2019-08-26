package com.johanneslosch.discordbotframework.command;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface ICommand {
    boolean called(String[] args, MessageReceivedEvent event);
    void action(String[] args, MessageReceivedEvent event);
    void executed(boolean sucess, MessageReceivedEvent event);
    String help();
}
