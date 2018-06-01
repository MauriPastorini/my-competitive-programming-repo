package UVa;

import java.io.IOException;
import java.util.Scanner;

public class ILoveStrings2 {

    public static void main(String[] args) throws IOException {
        Scanner br = new Scanner(System.in);
        int len = Integer.parseInt(br.nextLine());
        for (int i = 0; i < len; i++) {
            String test = br.nextLine();
            int q = Integer.parseInt(br.nextLine());
            for (int j = 0; j < q; j++) {
                String get = br.nextLine();
                Searcher search = new Searcher();
                if (!search.findPattern(get, test)) {
                    System.out.println("n");
                } else {
                    System.out.println("y");
                }
            }
        }
    }

    static class Searcher {

        boolean findPattern(String Pattern, String str) {
            int count = 0;
            for (int i = 0, j = 0; i < str.length(); i++) {
                if (Pattern.charAt(j) == str.charAt(i)) {
                    count++;
                    j++;
                } else {
                    j = 0;
                    count = 0;
                }
                if (count == Pattern.length()) {
                    return true;
                }
            }
            return false;
        }
    }

}
