/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.Stack;
import javafx.util.Pair;

/**
 *
 * @author Mauri-Laptop
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        stack.push(new Pair(temperatures[0],0));
        for (int i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > stack.peek().getKey()) {
                int pos = stack.pop().getValue();
                days[pos] = i - pos;
                stack.pop();
            }
            stack.push(new Pair(temperatures[i],i));
        }
        return days;
    }
}
