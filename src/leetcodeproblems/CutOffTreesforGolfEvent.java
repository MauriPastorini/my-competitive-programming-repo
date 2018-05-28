/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import java.util.List;
import java.util.Queue;

/**
 *
 * @author Mauri-Laptop
 */
public class CutOffTreesforGolfEvent {

    private List<TreeValue> getAllTrees(int[][] mat) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class TreeValue {

        public int i;
        public int j;
        public int value;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) {
            return -1;
        }
        int[][] mat = new int[forest.size()][forest.get(0).size()];

        List<TreeValue> treesToCut = getAllTrees(mat);

        int steps = 0;
//        Queue<TreeValue> queue = new Queue<>();
//        TreeValue pos = new TreeValue();
//        pos.i = 0;
//        pos.j = 0;
//        queue.add(pos);
//        while (queue.isEmpty()) {
//            
//        }
        return steps;
    }
}
