package wf.key.discordbotframework.rewrite.event.core;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Ready extends ListenerAdapter {
    @Override
    public void onReady(@Nonnull ReadyEvent event) {}
}
