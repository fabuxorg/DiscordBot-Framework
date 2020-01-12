package org.fabux.discordbotframework.util.setup;

import org.fabux.discordbotframework.datahandler.filehandler.FileHelper;
import org.fabux.discordbotframework.datahandler.filehandler.ReadFile;
import org.fabux.discordbotframework.datahandler.filehandler.WriteFile;
import org.fabux.discordbotframework.util.logs.Logger;

import java.io.IOException;
import java.util.Objects;

public class Setup {
    private static boolean isFirstStartup(){
        return !FileHelper.checkFile("data", "firstRun", "dat") || !Objects.requireNonNull(ReadFile.read("data", "firstRun", "dat")).contains("false");
    }
    public static void setup() throws IOException {
        if(isFirstStartup()){
            Logger.logger("Init first Startup ...");
            //run python file to create files and folders
            String command = "python /c start python install.py";
            Process p = Runtime.getRuntime().exec(command);
            WriteFile.writer("data", "firstRun", "dat", "false");
        }
    }
}
