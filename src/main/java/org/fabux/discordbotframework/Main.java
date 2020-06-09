package org.fabux.discordbotframework;


import org.fabux.discordbotframework.util.gui.webserver.HTTPServer;
import org.fabux.discordbotframework.util.logs.Logger;
import org.fabux.discordbotframework.util.setup.Setup;
import org.fabux.discordbotframework.util.versionhandler.VersionHandler;

import java.io.IOException;

public class Main {
    public static void main (String [] args) throws IOException {
        //Print "test" in log file
        Logger.logger("started");

        Setup.setup();

        VersionHandler.version("fabuxorg", "DiscordBot-Framework");

        //starting Web server for gui
        HTTPServer.start();

    }
}
