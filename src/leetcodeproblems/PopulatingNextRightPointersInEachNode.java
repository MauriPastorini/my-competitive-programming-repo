/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeproblems;

import domain.TreeLinkNode;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Mauri-Laptop
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        while (root != null && root.left != null) {
            root.left.next = root.right;
            TreeLinkNode parent = root.right;
            TreeLinkNode aux = root.next;
            while (aux != null) {
                parent.next = aux.left;
                aux.left.next = aux.right;
                parent = aux.right;
                aux = aux.next;
            }
            root = root.left;
        }
    }

    public void connect_With_memory(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        Stack<TreeLinkNode> stack = new Stack<>();

        queue.add(root);
        stack.add(root);
        while (!queue.isEmpty()) {
            TreeLinkNode elem = queue.poll();
            if (elem.left != null) {
                queue.add(elem.left);
                queue.add(elem.right);

                stack.add(elem.left);
                stack.add(elem.right);
            }
        }

        while (!stack.isEmpty()) {
            TreeLinkNode elemComparator = stack.peek();
            if (elemComparator == root) {
                return;
            }
            TreeLinkNode son = stack.pop();
            TreeLinkNode parent = stack.peek();
            while (parent.right != elemComparator) {
                parent.next = son;
                son = parent;
                stack.pop();
                parent = stack.peek();
            }
        }
    }
}
