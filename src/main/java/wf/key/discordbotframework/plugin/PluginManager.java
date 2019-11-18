package wf.key.discordbotframework.plugin;

import java.io.IOException;
import java.net.URL;
import java.security.CodeSource;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class PluginManager {
    /*
    see for jar input https://stackoverflow.com/questions/1429172/how-to-list-the-files-inside-a-jar-file
     */
    public static void manager(){
        CodeSource src = PluginManager.class.getProtectionDomain().getCodeSource();
        if (src != null) {
            URL jar = src.getLocation();
            ZipInputStream zip = null;
            try {
                zip = new ZipInputStream(jar.openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(true) {
                ZipEntry e = null;
                try {
                    assert zip != null;
                    e = zip.getNextEntry();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                if (e == null)
                    break;
                String name = e.getName();
                if (name.startsWith("path/to/your/dir/")) {

                }
            }
        }
        else {
            System.err.println("Got an error in PluginManager - try to fix that or look for an other way, good luck (or try without plugins)");
        }
    }
}
