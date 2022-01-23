package com.java.Trees;

import com.java.TreeNode;

public class DeleteNodeBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        DeleteNodeBST c = new DeleteNodeBST();
        root = c.deleteNode(root, 3);
        System.out.println(root);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key < root.val) root.left =  deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                TreeNode temp = findSucc(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }

    public TreeNode findSucc(TreeNode root) {
        TreeNode temp = root;
        while(temp.left != null) temp = temp.left;
        return temp;
    }
}
