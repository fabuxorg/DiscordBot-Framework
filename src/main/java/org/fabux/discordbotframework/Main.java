package org.fabux.discordbotframework;


import org.fabux.discordbotframework.datahandler.filehandler.FileHelper;
import org.fabux.discordbotframework.util.logs.Logger;
import org.fabux.discordbotframework.util.time.Time;

public class Main {
    public static void main (String [] args){
        //FileHelper.checkFile("logs", String.format("LOG_1"), "log");
        //Print "test" in log file
        Logger.logger("test");

        //Test version
        //VersionHandler.version();



    }
}
