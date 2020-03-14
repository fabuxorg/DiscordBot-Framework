package org.fabux.discordbotframework.util.web;

import org.fabux.discordbotframework.util.logs.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class WebAccess {
    private static String _url, _search;
    private static void access(String URL, String search){
        _url = URL;
        _search = search;
        try {
            searchStrings(getWebContent(URL), search);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args){
        access("https://google.com",  "google");
    }

    private static BufferedReader getWebContent(String url) {
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
        }
        catch(IOException ignored)
        {

        }
        catch(Exception e)
        {
            System.err.println("General Exception " + e);
            e.printStackTrace();
        }
        return reader;
    }

    private static void searchStrings(BufferedReader reader, String search) throws IOException {
        ArrayList <String> list = new ArrayList<>();
        while (reader.readLine() != null) {
            list.add(reader.readLine());
        }
        if(!list.toString().isEmpty()){
            System.out.println(list);
            if(list.toString().contains(search)){
                //TODO: get search content
                //TODO: give the result to another method
            }else{
                Logger.logger(String.format("%s not found at %s", search, _url));
            }
        }else{
            Logger.logger(String.format("The Downloaded code from %s is empty \n Check the domain!", _url));
        }
    }
}
