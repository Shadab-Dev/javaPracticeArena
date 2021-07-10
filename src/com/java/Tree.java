package com.java;

import java.util.*;

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
}

public class Tree {
    TreeNode root;
    private List<Boolean> left;
    private List<Boolean> right;
    private List<Integer> output;

    public void insert(TreeNode node) {
        if(root == null) {
            root = node;
            root.left = null;
            root.right = null;
            return;
        }

        TreeNode pointer = root;
        insertBelowNode(pointer, node);
    }

    private void insertBelowNode(TreeNode pointer, TreeNode node) {
    }

    public void inorderTraverse() {
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new LinkedList<>();
        List<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            queue.forEach(node -> tempList.add(node.val));
            output.add(tempList);

            List<TreeNode> tempQueue = new LinkedList<>(queue);
            queue.clear();
            tempQueue.forEach(node -> {
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            });
        }
        return output;
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer low, Integer high) {
        if(root == null) return true;

        if((low != null && root.val <= low) || (high != null && root.val >= high)) return false;

        return validate(root.right , root.val, high) && validate(root.left, low, root.val);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root==null) return Collections.EMPTY_LIST;

        List<Integer> output = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode popped = stack.pop();
            output.add(popped.val);
            if(popped.right!=null) stack.push(popped.right);
            if(popped.left!=null) stack.push(popped.left);
        }
        return output;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        output = new ArrayList<>();
        traverse(root);
        return output;
    }

    public void traverse(TreeNode root) {
        if (root==null) return;
        traverse(root.left);
        output.add(root.val);
        traverse(root.right);
    }

    public boolean isSymmetric(TreeNode root) {
        left = new LinkedList<>();
        right = new LinkedList<>();
        traverseLeft(root.left, left);
        traverseRight(root.right, right);
        return left.equals(right);
    }

    private void traverseLeft(TreeNode root, List<Boolean> output){
        if(root==null) return;
        output.add(true);
        output.add(root.left!=null);
        output.add(root.right!=null);
        traverseLeft(root.left, output);
        traverseLeft(root.right, output);
    }

    private void traverseRight(TreeNode root, List<Integer> output){
        if(root==null) return;
        output.add(true);
        output.add(root.right!=null);
        output.add(root.left!=null);
        traverseRight(root.right, output);
        traverseRight(root.left, output);
        if(root.left!=null) output.add(root.left.val) else output.add(null);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 1 || postorder.length == 1) return new TreeNode(postorder[0]);
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int pivot = 0;
        // find the root node in the inorder array, then divide the array into left and right
        for(int i=0; i<inorder.length; i++) {
            if(inorder[i] == root.val) {
                pivot = i; break;
            }
        }
        // recurse for creating the left and right subtree
        root.left = recurse(inorder, 0, pivot-1);
        root.right = recurse(inorder, pivot+1, inorder.length-1);
        return root;
    }

    private TreeNode recurse(int[] arr, int start, int end) {
        if(start==end) return new TreeNode(arr[start]);
        int pivot = (start+end)/2;
        TreeNode root = new TreeNode(arr[pivot]);
        root.left = recurse(arr, start, pivot-1);
        root.right = recurse(arr, pivot+1, end);
        return root;
    }

}