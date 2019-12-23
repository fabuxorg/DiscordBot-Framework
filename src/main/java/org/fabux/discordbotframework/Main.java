package org.fabux.discordbotframework;


import org.fabux.discordbotframework.util.logs.Logger;
import org.fabux.discordbotframework.util.setup.Setup;

public class Main {
    public static void main (String [] args){
        //Print "test" in log file
        Logger.logger("test");

        Setup.setup();

        //Test version
        //VersionHandler.version("fabuxorg", "DiscordBot-Framework");

    }
}
