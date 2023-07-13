package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

         // System.out.println("Hello world!");
        // test case - 1
        Map<Integer, String> urlMap = new HashMap<>();
        String longUrl = "testcase.com";
        int id = 0;
        for(int i = 0; i < longUrl.length(); i++) {
            id += (int)(longUrl.charAt(i));
        }
        urlMap.put(id, longUrl);
        String shortUrl = idToShortUrl(id);
        System.out.println("the generated short url is " + shortUrl);
        System.out.println("the id of the short url is " + shortUrlToId(shortUrl));
        System.out.println("the long url is " + urlMap.get(shortUrlToId(shortUrl)));
    }


    public static String idToShortUrl(int id) {
        char[] map  = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuffer shortUrl = new StringBuffer();
        while(id > 0) {
            shortUrl.append(map[id%62]);
            id /=62;
        }
        return shortUrl.reverse().toString();
    }

    public static int shortUrlToId(String shortUrl) {
        int id = 0;
        for(int i = 0; i<shortUrl.length(); i++) {
            if ('a' <= shortUrl.charAt(i) &&
                    shortUrl.charAt(i) <= 'z')
                id = id * 62 + shortUrl.charAt(i) - 'a';
            if ('A' <= shortUrl.charAt(i) &&
                    shortUrl.charAt(i) <= 'Z')
                id = id * 62 + shortUrl.charAt(i) - 'A' + 26;
            if ('0' <= shortUrl.charAt(i) &&
                    shortUrl.charAt(i) <= '9')
                id = id * 62 + shortUrl.charAt(i) - '0' + 52;
        }
        return id;
    }
}