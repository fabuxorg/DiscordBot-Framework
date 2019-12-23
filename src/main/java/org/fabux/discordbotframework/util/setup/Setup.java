package org.fabux.discordbotframework.util.setup;

import org.fabux.discordbotframework.datahandler.filehandler.FileHelper;
import org.fabux.discordbotframework.datahandler.filehandler.ReadFile;
import org.fabux.discordbotframework.datahandler.filehandler.WriteFile;
import org.fabux.discordbotframework.util.logs.Logger;

import java.util.Objects;

public class Setup {
    private static boolean isFirstStartup(){
        return !FileHelper.checkFile("data", "firstRun", "dat") || !Objects.requireNonNull(ReadFile.read("data", "firstRun", "dat")).contains("false");
    }
    public static void setup(){
        if(isFirstStartup()){
            Logger.logger("Init first Startup ...");
            WriteFile.writer("data", "firstRun", "dat", "false");
        }
    }
}
