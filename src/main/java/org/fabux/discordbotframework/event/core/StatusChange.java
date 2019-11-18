package org.fabux.discordbotframework.event.core;

import net.dv8tion.jda.api.events.StatusChangeEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class StatusChange extends ListenerAdapter {
    @Override
    public void onStatusChange(@Nonnull StatusChangeEvent event) {}
}
