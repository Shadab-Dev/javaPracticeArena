package com.java.Trees;

import com.java.TreeNode;

public class TreeToDLL {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(12);
        root.left.left = new TreeNode(25);
        root.left.right = new TreeNode(30);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(36);
        TreeToDLL c = new TreeToDLL();
        TreeNode ll = c.bToDLL(root);
        TreeNode temp = ll;
        TreeNode prev = temp;
        while (temp != null) {
            prev = temp;
            System.out.print(temp.val + " ");
            temp = temp.right;
        }
        System.out.println(" ");
        while (prev != null) {
            System.out.print(prev.val + " ");
            prev = prev.left;
        }
    }

    TreeNode prev = null;
    public TreeNode bToDLL(TreeNode root) {
        if(root==null) return null;
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if(root == null) return null;
        // STEP 1: FIND THE HEAD OF THE LINKED LIST
        TreeNode head = helper(root.left);
        // STEP 2: UPDATE THE HEAD TO THE LEFTMOST NODE
        // Once the recursive call to the left ends at leaf node, we update the head to the left most node of the tree
        // This if condition will only be triggered once as we will update prev after visiting the left most node
        if(prev == null) head = root;
        // If we have prev set, then by property of linkedList we should set the current node's left to prev
        // and prev's next to current
        // STEP 3: UPDATE THE PREV TO CURRENT AFTER UPDATING THE LEFT AND RIGHT
        else {
            root.left = prev;
            prev.right = root;
        }
        // After updating we move prev to the current node
        prev = root;
        // We do the above same methods exactly for the right node
        // STEP 4: DO THE EXACT SAME STEPS FOR RIGHT
        helper(root.right);
        // STEP 5: RETURN HEAD
        // We return the head as that will be the starting point of the list
        return head;
    }
}
