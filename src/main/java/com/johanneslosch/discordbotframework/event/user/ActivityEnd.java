package com.johanneslosch.discordbotframework.event.user;

import net.dv8tion.jda.api.events.user.UserActivityEndEvent;

import javax.annotation.Nonnull;

public class ActivityEnd {
    public void onUserActivityEnd(@Nonnull UserActivityEndEvent event) {}
}
