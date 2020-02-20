package org.fabux.discordbotframework.util.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebAccess {
    public static BufferedReader getWebContent(String url)
    {
        BufferedReader reader = null;
        String output = null;
        URL ourURL = null;
        HttpURLConnection huc = null;
        try {
            ourURL = new URL(url);
            huc = (HttpURLConnection)ourURL.openConnection();
            huc.setRequestMethod("GET");
            try{
                huc.connect();
            }catch(Exception es){
                es.printStackTrace();
                System.out.println("Exception " + es.getMessage());
                System.out.println("RESPONSE CODE" + huc.getResponseCode());
                Thread.sleep(2000);
                huc.connect();
            }
            reader = new BufferedReader(new InputStreamReader(huc.getInputStream()));


            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        }
        catch(IOException ioe)
        {
            //ioe.printStackTrace();
        }
        catch(Exception e)
        {
            System.err.println("General Exception " + e);
            e.printStackTrace();
        }
        return reader;
    }
}
