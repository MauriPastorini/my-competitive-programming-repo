package UVa;

import java.util.Scanner;

public class ILoveStrings10679 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while (testCases-- != 0) {
            String original = in.nextLine();
            int cant = Integer.parseInt(in.nextLine());
            for (int i = 0; i < cant; i++) {
                String word = in.nextLine();
                if (original.startsWith(word)) {
                    System.out.println("y");
                } else {
                    System.out.println("n");
                }
            }
        }
    }
}
