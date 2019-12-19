package org.fabux.discordbotframework.datahandler.filehandler.config;

import org.fabux.discordbotframework.datahandler.filehandler.FileHelper;
import org.fabux.discordbotframework.util.logs.Logger;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class ConfigWriter {
    /**
     * Writes Properties in a .prop(erties) file
     * @param path      path to file
     * @param filename  filename (without ending)
     * @param key       category
     * @param value     value for category
     */
    public static void writePropertiesFile(String path, String filename, String key, String value) {
        if(FileHelper.checkFile(path, filename, ".prop")){
            /**
             * init Properties and Output stream
             */

            Properties properties = new Properties();
            OutputStream outputStream = null;


            /**
             * set output- directory and file name
             */
            try {
                outputStream = new FileOutputStream(path +"/"+ filename + ".prop", true);
            } catch (FileNotFoundException e) {
                Logger.logger(e.getMessage());
                e.printStackTrace();
            }

            /**
             * set first properties to enter in file
             * like :
             * var1=example
             */
            properties.setProperty(key, value);

            /**
             * saving properties file and content
             */
            try {
                properties.store(outputStream, null);
            } catch (IOException e1) {
                Logger.logger(e1.getMessage());
                e1.printStackTrace();
            }
        }
    }




}
