/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.HashMap;

/**
 *
 * @author Mauri-Laptop
 */
public class TrieSimple {

    public HashMap<Character, TrieSimple> next = new HashMap<>();
    public int depth;

    public void add(Character c) {
        if (!next.containsKey(c)) {
            next.put(c, new TrieSimple());
            next.get(c).depth = depth + 1;
        }
    }
}
