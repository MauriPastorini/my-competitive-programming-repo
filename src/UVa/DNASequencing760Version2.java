/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UVa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Mauri-Laptop
 */
public class DNASequencing760Version2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String line1 = in.nextLine();
            String line2 = in.nextLine();
            if (in.hasNextLine()) {
                in.nextLine();
            }

            Set<String> set1 = new HashSet<>();

            for (int i = 0; i < line1.length(); i++) {
                for (int j = i; j < line1.length(); j++) {
                    set1.add(line1.substring(i, j + 1));
                }
            }

            Set<String> lst = new TreeSet<>();
            int max = 0;
            for (String string : set1) {
                String line2Aux = new String(line2);
                int cant = 0;
                while (line2Aux.indexOf(string) != -1) {
                    cant++;
                    line2Aux = line2Aux.substring(line2Aux.indexOf(string) + 1);
                }
                if (cant > 0 && max <= string.length()) {
                    if (max != string.length()) {
                        lst = new TreeSet<>();
                    }
                    if (!lst.contains(string)) {
                        lst.add(string);
                    }
                    max = string.length();
                }
            }

            if (lst.isEmpty()) {
                System.out.println("No common sequence.");
            } else {
                for (String string : lst) {
                    System.out.println(string);
                }
            }
            if (in.hasNextLine()) {
                System.out.println("");
            }
        }
    }
}
