package org.fabux.discordbotframework.util.logs;

import org.fabux.discordbotframework.datahandler.filehandler.WriteFile;

public class Logger {
    public static void logger(String content){
        WriteFile.writer("logs", "LOG", "log", content);
    }
}
