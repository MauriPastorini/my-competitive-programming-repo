/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import domain.TreeNode;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Mauri-Laptop
 */
public class KthSmalletsTree {

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> elems = new PriorityQueue<>();
        loadHeap(elems, root);
        for (int i = 0; i < k; i++) {
            elems.poll();
        }        
        return elems.poll();

    }

    private void loadHeap(PriorityQueue<Integer> elems, TreeNode root) {
        if (root == null) {
            return;
        }
        elems.add(root.val);
        loadHeap(elems, root.left);
        loadHeap(elems, root.right);
    }
}
