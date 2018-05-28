package leetcodeproblems;

import domain.TreeNode;

public class BinaryTreePruning {
    
    public void test(){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(1);
        root.right.left = new TreeNode(2);
        
        pruneTree(root);
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        int val = root.val;
        TreeNode decIzq = pruneTree(root.left);
        TreeNode decDer = pruneTree(root.right);
        if (decIzq == null && decDer == null && val != 1) {
            return null;
        }
        root.left = decIzq;
        root.right = decDer;
        return root;
    }
}
