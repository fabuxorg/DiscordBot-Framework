package com.johanneslosch.discordbotframework.datahandler.filehandler;

import java.io.FileWriter;

public class WriteFile {
    /*
    Reference https://www.journaldev.com/20891/java-filewriter-example
     */
    public static void writer(String path, String filename, String ending, String content){
        try(FileWriter fileWriter = new FileWriter(String.format("%s/%s.%s",path, filename, ending),true)) {
            fileWriter.write(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
