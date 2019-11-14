package wf.key.discordbotframework.rewrite.util.logs;

import com.johanneslosch.discordbotframework.datahandler.filehandler.WriteFile;

public class Logger {
    public static void logger(String content){
        WriteFile.writer("logs", "LOG", "log", content);
    }
}
