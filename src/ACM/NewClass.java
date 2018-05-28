/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACM;

import java.util.*;

/**
 *
 * @author Mauri-Laptop
 */
public class NewClass {
    
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        Map<List<String>, Integer> asciiToInteger = makeAsciiToIntMap();
        Map<Integer, List<String>> integerToAscii = makeIntToAsciiMap();
        
        List<List<String>> numbers = new ArrayList<>();
        for (int k = 0; k < 7; k++) {
            String line = in.nextLine();
            
            int i = 0;
            int num = 0;
            while (i + 5 <= line.length()) {
                String substring = line.substring(i, i + 5);
                
                i += 5;
                
                if (num >= numbers.size()) {
                    numbers.add(new ArrayList<>());
                }
                numbers.get(num).add(substring);
                
                num++;
                i++;
            }
        }
        int left = 0;
        int right = 0;
        boolean plus = false;
        
        int i = 0;
        while (i < numbers.size()) {
            if (asciiToInteger.containsKey(numbers.get(i))) {
                int number = asciiToInteger.get(numbers.get(i));
                
                if (!plus) {
                    left = left * 10 + number;
                } else {
                    right = right * 10 + number;
                }
            } else {
                plus = true;
            }
            
            i++;
        }
        
        String sum = String.valueOf(left + right);
        List<List<String>> num = new ArrayList<>();
        for (int j = 0; j < sum.length(); j++) {
            int aux = Integer.parseInt(sum.charAt(j) + "");
            
            List<String> auxInStrings = integerToAscii.get(aux);
            num.add(auxInStrings);
        }
        
        for (int k = 0; k < 7; k++) {
            for (int j = 0; j < num.size(); j++) {
                System.out.print(num.get(j).get(k));
                
                if (j + 1 < num.size()) {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
    }

    private static Map<List<String>, Integer> makeAsciiToIntMap() {
        Map<List<String>, Integer> ret = new HashMap<>();
        
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x...x", "x...x", "x...x", "x...x", "x...x", "xxxxx"})), 0);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"....x", "....x", "....x", "....x", "....x", "....x", "....x"})), 1);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "....x", "....x", "xxxxx", "x....", "x....", "xxxxx"})), 2);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "....x", "....x", "xxxxx", "....x", "....x", "xxxxx"})), 3);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"x...x", "x...x", "x...x", "xxxxx", "....x", "....x", "....x"})), 4);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x....", "x....", "xxxxx", "....x", "....x", "xxxxx"})), 5);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x....", "x....", "xxxxx", "x...x", "x...x", "xxxxx"})), 6);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "....x", "....x", "....x", "....x", "....x", "....x"})), 7);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x...x", "x...x", "xxxxx", "x...x", "x...x", "xxxxx"})), 8);
        ret.put(new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x...x", "x...x", "xxxxx", "....x", "....x", "xxxxx"})), 9);
        
        return ret;
    }

    private static Map<Integer, List<String>> makeIntToAsciiMap() {
        Map<Integer, List<String>> ret = new HashMap<>();
        
        ret.put(0, new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x...x", "x...x", "x...x", "x...x", "x...x", "xxxxx"})));
        ret.put(1, new ArrayList<>(Arrays.asList(new String[]{"....x", "....x", "....x", "....x", "....x", "....x", "....x"})));
        ret.put(2, new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "....x", "....x", "xxxxx", "x....", "x....", "xxxxx"})));
        ret.put(3, new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "....x", "....x", "xxxxx", "....x", "....x", "xxxxx"})));
        ret.put(4, new ArrayList<>(Arrays.asList(new String[]{"x...x", "x...x", "x...x", "xxxxx", "....x", "....x", "....x"})));
        ret.put(5, new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x....", "x....", "xxxxx", "....x", "....x", "xxxxx"})));
        ret.put(6, new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x....", "x....", "xxxxx", "x...x", "x...x", "xxxxx"})));
        ret.put(7, new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "....x", "....x", "....x", "....x", "....x", "....x"})));
        ret.put(8, new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x...x", "x...x", "xxxxx", "x...x", "x...x", "xxxxx"})));
        ret.put(9, new ArrayList<>(Arrays.asList(new String[]{"xxxxx", "x...x", "x...x", "xxxxx", "....x", "....x", "xxxxx"})));
        
        return ret;
    }
}
