package org.fabux.discordbotframework.event.core;

import net.dv8tion.jda.api.events.ExceptionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Exception extends ListenerAdapter {
    @Override
    public void onException(@Nonnull ExceptionEvent event) {}

}
