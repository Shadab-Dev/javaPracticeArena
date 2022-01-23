package com.java.Trees;

import com.java.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InorderIterative c = new InorderIterative();
        System.out.println(c.inorderTraversal(root));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !st.isEmpty()) {
            if(curr != null) {
                result.add(curr.val);
                st.push(curr);
                curr = curr.left;
            } else {
                curr = st.pop();
                curr = curr.right;
            }
        }
        return result;
    }
}
