package wf.key.discordbotframework.datahandler.filehandler.config;

import wf.key.discordbotframework.util.logs.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    /**
     * reads values from .prop(erties) file
     * @param path      path to file
     * @param filename  filename (without ending)
     * @param key       category for value
     * @return          returns value
     */
    public static String read(String path, String filename, String key) {
        Properties prop = new Properties();
        InputStream input = null;
        if (ConfigHelper.checkFile(path, filename)) {
            try {

                input = new FileInputStream(new File(path + "/"+ filename + ".prop"));

                // load a properties file
                prop.load(input);

                // get the property value and print it out
                prop.getProperty(key);

            } catch (IOException ex) {
                Logger.logger(ex.getMessage());
                ex.printStackTrace();
            } finally {
                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        Logger.logger(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        return prop.getProperty(key);
    }
}
