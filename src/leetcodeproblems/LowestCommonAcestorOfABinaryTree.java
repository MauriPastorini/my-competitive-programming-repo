/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import domain.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Mauri-Laptop
 */
public class LowestCommonAcestorOfABinaryTree {

    void test() {
        TreeNode tr = new TreeNode(6);
        tr.left = new TreeNode(2);
        tr.left.left = new TreeNode(0);
        tr.left.right = new TreeNode(4);
        tr.left.right.left = new TreeNode(3);
        tr.left.right.right = new TreeNode(5);

        tr.right = new TreeNode(8);
        tr.right.left = new TreeNode(7);
        tr.right.right = new TreeNode(9);

        System.out.println(lowestCommonAncestor_Largo(tr, tr.right.right, tr.right).val);
    }
    
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left != null && right != null)return root;
        else return left == null ?right:left;
    }

    public TreeNode lowestCommonAncestor_Largo(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Queue<TreeNode> queuep = new LinkedList<>();
        Queue<TreeNode> queueq = new LinkedList<>();

        loadNodes(root, p, queuep);
        loadNodes(root, q, queueq);

        TreeNode t1 = null;
        TreeNode t2 = null;
        while (!queuep.isEmpty() && !queueq.isEmpty() && queuep.peek().val == queueq.peek().val) {
            t1 = queuep.poll();
            t2 = queueq.poll();
        }
        return t1;
    }

    private boolean loadNodes(TreeNode root, TreeNode t, Queue<TreeNode> queue) {
        if (root == null) {
            return false;
        }
        if (t == root) {
            queue.add(root);
            return true;
        }
        queue.add(root);
        if (loadNodes(root.left, t, queue)) {
            return true;
        }
        if (loadNodes(root.right, t, queue)) {
            return true;
        }
        queue.remove(root);
        return false;
    }
}
