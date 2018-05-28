/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Mauri-Laptop
 */
public class EncodeAndDecodeTinyURL {

    public void test() {
        System.out.println(decode(encode("https://leetcode.com/problems/design-tinyurl")));
        System.out.println(decode(encode("https://google.com")));

    }
    Map<String, String> shortLongUrlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int h1 = "hola".hashCode();
        int h2 = "hola".hashCode();
        int h3 = "https://leetcode.com/problems/design-tinyurl".hashCode();
        char[] baseChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        String output = generateShortUrl(baseChar, baseChar.length, longUrl.hashCode());
        shortLongUrlMap.put(output, longUrl);
        return output;
    }

    public String generateShortUrl(char[] baseChars, int base, int hashCode) {

        StringBuilder url = new StringBuilder();
        while (hashCode > 0) {
            int no = hashCode % 62;
            url.append(baseChars[no]);
            hashCode = hashCode / base;
        }

        return url.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return shortLongUrlMap.get(shortUrl);
    }
}
