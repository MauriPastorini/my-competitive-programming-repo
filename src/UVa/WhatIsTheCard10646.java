/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UVa;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mauri-Laptop
 */
public class WhatIsTheCard10646 {

    private static int value(String s) {
        int val;
        try {
            val = Integer.parseInt(s.charAt(0) + "");
        } catch (Exception ex) {
            return 10;
        }
        if (val >= 2 && val <= 9) {
            return val;
        }
        return 10;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cant = Integer.parseInt(in.nextLine());
        int total = cant;
        while (cant-- != 0) {
            //String line1 = in.nextLine();
            String[] cards = in.nextLine().split(" ");
//            if (line1.split(" ").length < 52) {
//                String line2 = in.nextLine();
//                cards = (line1 + " " + line2).split(" ");
//            } else {
//                cards = line1.split(" ");
//            }
            int n = cards.length;
            boolean[] discarted = new boolean[n];
            int pos;
            pos = n - 25 - 1;
            int Y = 0;
            for (int i = 0; i < 3; i++) {
                int value = value(cards[pos]);
                Y += value;
                for (int j = 0; j < 10 - value + 1; j++) {
                    discarted[pos] = true;
                    pos--;
                }
            }
            int i = 0;
            while (Y != 0) {
                if (!discarted[i]) {
                    Y--;
                }
                i++;
            }
            System.out.println("Case " + (total - cant) + ": " + cards[i - 1]);
        }
    }
}
