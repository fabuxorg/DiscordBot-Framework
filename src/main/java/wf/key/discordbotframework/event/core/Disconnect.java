package wf.key.discordbotframework.event.core;

import net.dv8tion.jda.api.events.DisconnectEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Disconnect extends ListenerAdapter {
    @Override
    public void onDisconnect(@Nonnull DisconnectEvent event) {}
}
