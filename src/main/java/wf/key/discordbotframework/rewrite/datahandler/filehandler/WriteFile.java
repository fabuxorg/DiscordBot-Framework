package wf.key.discordbotframework.rewrite.datahandler.filehandler;

import wf.key.discordbotframework.rewrite.util.logs.Logger;

import java.io.FileWriter;

public class WriteFile {
    /*
    Reference https://www.journaldev.com/20891/java-filewriter-example
     */
    public static void writer(String path, String filename, String ending, String content){
        try(FileWriter fileWriter = new FileWriter(String.format("%s/%s.%s",path, filename, ending),true)) {
            fileWriter.write(content);
        } catch (Exception e) {
            Logger.logger(e.getMessage());
            e.printStackTrace();
        }
    }
}
