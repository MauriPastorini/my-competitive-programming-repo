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
public class ShortestDistanceToACharacter {

    void test() {
        int[] res = shortestToChar("loveleetcode", 'e');
        for (int i : res) {
            System.out.println(i);
        }
    }

    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] res = new int[n];
        int pos = -n;
        for (int i = 0; i < n; ++i) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            res[i] = i - pos;
        }
        for (int i = n - 1; i >= 0; --i) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            res[i] = Math.min(res[i], Math.abs(i - pos));
        }
        return res;
    }

    public int[] shortestToCharMio(String S, char C) {
        char[] elems = S.toCharArray();
        int[] distance = new int[elems.length];
        String aux = S;
        int cont = 0;
        for (int i = 0; i < elems.length; i++) {
            int a = aux.indexOf(C);
            int steps = 0;
            while (i - steps >= 0 || i + steps < elems.length) {
                if (i - steps >= 0 && elems[i - steps] == C) {
                    distance[i] = steps;
                    break;
                }
                if (i + steps < elems.length && elems[i + steps] == C) {
                    distance[i] = steps;
                    break;
                }
                steps++;
            }
        }
        return distance;
    }
}
