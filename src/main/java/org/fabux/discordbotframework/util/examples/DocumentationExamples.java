package org.fabux.discordbotframework.util.examples;


import org.fabux.discordbotframework.datahandler.filehandler.config.ConfigReader;
import org.fabux.discordbotframework.datahandler.filehandler.config.ConfigWriter;

class DocumentationExamples {
    private void writeProp(){
        ConfigWriter.writePropertiesFile("path", "filename", "key-to-safe", "value-for-key");
    }
    private void readProp(){
        String config = ConfigReader.read("path", "filename", "key-to-safe");
    }
}
