/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import domain.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Mauri-Laptop
 */
public class inorderTraversal {

    void test() {
        TreeNode tr1 = new TreeNode(1);
        TreeNode tr2 = new TreeNode(2);
        TreeNode tr3 = new TreeNode(4);
        TreeNode tr4 = new TreeNode(5);
        TreeNode tr5 = new TreeNode(3);
        TreeNode tr6 = new TreeNode(7);
        TreeNode tr7 = new TreeNode(6);
        TreeNode tr8 = new TreeNode(9);

        tr1.left = tr2;
        tr2.left = tr3;
        tr1.right = tr4;
        tr4.left = tr5;
        tr4.right = tr6;
        tr6.left = tr7;
        tr6.right = tr8;
        
        List<Integer> res = inorderTraversal(tr1);
        for(Integer i : res){
            System.out.println(i);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        root = root.left;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode elem = stack.pop();
            res.add(elem.val);
            root = elem.right;
        }
        return res;
    }

}
