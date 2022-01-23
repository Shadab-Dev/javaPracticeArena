package com.java.Trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class VerticalSumBST {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        VerticalSumBST c = new VerticalSumBST();
        System.out.println(c.verticalSum(root));
    }

    public ArrayList<Integer> verticalSum(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        helper(root, map, 0);
        result.addAll(map.values());
        return result;
    }

    public void helper(Node root, Map<Integer, Integer> map, int distance) {
        if(root == null) return;
        helper(root.left, map, distance-1);
        map.put(distance,  map.getOrDefault(distance, 0)+root.data);
        helper(root.right, map, distance+1);
    }
}

class Node{
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
