package wf.key.discordbotframework.rewrite.datahandler.filehandler;

import wf.key.discordbotframework.rewrite.util.logs.Logger;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReadFile {

    @Nullable
    public static List<String> read(String path, String filename, String ending){
        ArrayList<String> content = new ArrayList<>();
        try {
            File fileDir = new File(String.format("%s/%s.%s",path, filename, ending));

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), StandardCharsets.UTF_8));

            String str;

            while ((str = in.readLine()) != null) {
                System.out.println(str);
                Objects.requireNonNull(content).add(str);
            }
            in.close();
            return content;
        }
        catch (UnsupportedEncodingException | FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            Logger.logger(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
