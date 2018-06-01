//TLE: Ver big O
package UVa;

import java.util.Scanner;

public class Gattaca11512 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tests = Integer.parseInt(in.nextLine());
        while (tests-- != 0) {
            String line = in.nextLine();
            String maxSub = "";
            int cantRepMax = 0;
            for (int i = 0; i < line.length(); i++) {
                for (int j = i + 1; j <= line.length(); j++) {
                    String subString = line.substring(i, j);
                    int cantRep = countRepetitions(subString, line, i);
                    if (cantRep > 1 && subString.length() >= maxSub.length()) {
                        if (maxSub.isEmpty() || subString.length() > maxSub.length() || subString.compareTo(maxSub) < 0) {
                            maxSub = subString;
                            cantRepMax = cantRep;
                        }
                    }
                }
            }
            if (maxSub.isEmpty()) {
                System.out.println("No repetitions found!");
            } else {
                System.out.println(maxSub + " " + cantRepMax);
            }
        }
    }

    private static int countRepetitions(String subString, String line, int j) {
        int cant = 0;
        int start = j;
        int index = line.indexOf(subString, start);
        while (index != -1) {
            cant++;
            start = index + 1;
            index = line.indexOf(subString, start);
        }
        return cant;
    }
}
