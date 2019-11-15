package wf.key.discordbotframework.util.logs;

import wf.key.discordbotframework.datahandler.filehandler.WriteFile;

public class Logger {
    public static void logger(String content){
        WriteFile.writer("logs", "LOG", "log", content);
    }
}
