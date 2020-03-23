package org.fabux.discordbotframework.util.web;

import org.fabux.discordbotframework.util.logs.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;


public class WebAccess {
    private static String _url;

    private static void access(String URL, String search, int attributeLength, Optional<Boolean> addOne){
        _url = URL;
        int one = 0;
        if(addOne.isPresent()){
            if(addOne.get()){
                one = 1;
            }
        }
        try {
            searchStrings(getWebContent(URL), search, attributeLength, one);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Provides access to Content from websites, return as string
     * @param URL {String}                  website where you which you need content from
     * @param search {String}               your search quarry
     * @param attributeLength {Integer}     the length of the attribute you want to get
     * @param addOne {boolean}              if there is a symbol between search quarry and attribute
     */
    public static void get(String URL, String search, int attributeLength, boolean addOne){
        access(URL, search, attributeLength, Optional.of(addOne));
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

    private static String searchStrings(BufferedReader reader, String search, int attributeLength, int one) throws IOException {
        ArrayList <String> list = new ArrayList<>();
        while (reader.readLine() != null) {
            list.add(reader.readLine());
        }
        if(!list.toString().isEmpty()){
            if(list.toString().contains(search)){
                return list.get(1).substring(list.get(1).indexOf(search), list.get(1).indexOf(search) + search.length() + attributeLength + one);
            }else{
                Logger.logger(String.format("%s not found at %s", search, _url));
            }
        }else{
            Logger.logger(String.format("The Downloaded code from %s is empty \n Check the domain!", _url));
        }
        return null;
    }
}
