package com.johanneslosch.discordbotframework.plugin;

import org.jetbrains.annotations.NotNull;

public interface IPlugin {
    @NotNull
    static String getName(){return null;}

    @NotNull
    static Integer getVersion(){return 0;}

    @NotNull
    static String getDescription(){return null;}

    @NotNull
    void start();

    @NotNull
    void stop();

    @NotNull
    void setPluginManager(PluginManager manager);
}
