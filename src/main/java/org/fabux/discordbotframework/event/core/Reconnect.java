package org.fabux.discordbotframework.event.core;

import net.dv8tion.jda.api.events.ReconnectedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Reconnect extends ListenerAdapter {
    @Override
    public void onReconnect(@Nonnull ReconnectedEvent event) {}
}