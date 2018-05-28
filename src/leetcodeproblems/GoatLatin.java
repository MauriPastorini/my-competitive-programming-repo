/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

/**
 *
 * @author Mauri-Laptop
 */
public class GoatLatin {

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        StringBuilder strBuild = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (words[i].startsWith("a") || words[i].startsWith("e") || words[i].startsWith("i") || words[i].startsWith("o") || words[i].startsWith("u") || words[i].startsWith("A") || words[i].startsWith("E") || words[i].startsWith("I") || words[i].startsWith("O") || words[i].startsWith("U")) {
                strBuild.append(w);
                strBuild.append("ma");
            } else {
                char c = w.charAt(0);
                String sub = w.substring(1, w.length());
                strBuild.append(sub);
                strBuild.append(c);
                strBuild.append("ma");
            }
            for (int j = 0; j < i + 1; j++) {
                strBuild.append("a");
            }
            strBuild.append(" ");
        }
        return strBuild.toString().trim();
    }
}
