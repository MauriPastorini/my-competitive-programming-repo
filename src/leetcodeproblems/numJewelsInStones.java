/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Mauri-Laptop
 */
public class numJewelsInStones {

    public int numJewelsInStones(String J, String S) {
        Set<Character> elems = new HashSet<>();
        char[] jewels = J.toCharArray();
        char[] stones = S.toCharArray();

        for (int i = 0; i < jewels.length; i++) {
            elems.add(jewels[i]);
        }

        int cont = 0;
        for (int j = 0; j < stones.length; j++) {
            if (elems.contains(stones[j])) {
                cont++;
            }
        }
        return cont;
    }
}
