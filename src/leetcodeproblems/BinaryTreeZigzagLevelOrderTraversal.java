package leetcodeproblems;

import domain.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        root.left.right = new TreeNode(3);
        root.left.left = new TreeNode(2);

        root.left.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        root.right.left.right = new TreeNode(5);
        root.right.left.left = new TreeNode(4);
        root.right.right.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        zigzagLevelOrder(root);
    }

    //BFS Quicker, more beautiful 
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean order = true;
        int size = 1;

        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode n = q.poll();
                if (order) {
                    tmp.add(n.val);
                } else {
                    tmp.add(0, n.val);
                }
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            res.add(tmp);
            size = q.size();
            order = order ? false : true;
        }
        return res;
    }
    
    //BFS Mio, slower
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> lst = new ArrayList<>();
        if (root == null) {
            return lst;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> lstElem = new ArrayList<>();
        lstElem.add(root.val);
        lst.add(lstElem);
        boolean right = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            lstElem = new ArrayList<>();
            while (size != 0) {
                size--;
                TreeNode elem = queue.get(size);
                queue.remove(size);
                if (!right) {
                    if (elem.left != null) {
                        queue.add(elem.left);
                        lstElem.add(elem.left.val);
                    }
                    if (elem.right != null) {
                        queue.add(elem.right);
                        lstElem.add(elem.right.val);
                    }
                } else {
                    if (elem.right != null) {
                        queue.add(elem.right);
                        lstElem.add(elem.right.val);
                    }
                    if (elem.left != null) {
                        queue.add(elem.left);
                        lstElem.add(elem.left.val);
                    }
                }
            }
            if (!lstElem.isEmpty()) {
                lst.add(lstElem);
            }
            right = !right;
        }
        return lst;
    }
}
