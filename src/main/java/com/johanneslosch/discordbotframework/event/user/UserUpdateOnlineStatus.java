package com.johanneslosch.discordbotframework.event.user;

import net.dv8tion.jda.api.events.user.update.UserUpdateOnlineStatusEvent;

import javax.annotation.Nonnull;

public class UserUpdateOnlineStatus {
    public void onUserUpdateOnlineStatus(@Nonnull UserUpdateOnlineStatusEvent event) {}

}
