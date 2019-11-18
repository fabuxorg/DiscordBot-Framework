package com.johanneslosch.discordbotframework.util;

import com.johanneslosch.discordbotframework.datahandler.filehandler.config.ConfigReader;
import com.johanneslosch.discordbotframework.datahandler.filehandler.config.ConfigWriter;

class DocumentationExamples {
    private void writeProp(){
        ConfigWriter.writePropertiesFile("path", "filename", "key-to-safe", "value-for-key");
    }
    private void readProp(){
        String config = ConfigReader.read("path", "filename", "key-to-safe");
    }
}
