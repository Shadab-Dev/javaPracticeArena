package com.java;

import java.util.*;

public class SerializeDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "X,";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0) return null;
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(q);
    }

    private TreeNode deserializeHelper(Queue<String> q){
        String value = q.remove();
        if(value.equals("X")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = (deserializeHelper(q));
        root.right = (deserializeHelper(q));
        return root;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> cache = new HashMap<>();

    }
}
