package com.java.Trees;

import java.util.*;

public class TopViewOfTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(topView(root));
    }

    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {
        Map<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        preorder(root, map, 0);
        result.addAll(map.values());
        return result;
    }

    static void preorder(Node root, Map<Integer, Integer> map, int distance) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(root, distance));
        map.put(distance, root.data);
        while(!queue.isEmpty()) {
            Pair temp = queue.poll();
            if(temp.node.left!=null) queue.offer(new Pair(temp.node.left, temp.distance-1));
            if(temp.node.right!=null) queue.offer(new Pair(temp.node.right, temp.distance+1));
            if(!map.containsKey(temp.distance)) map.put(temp.distance, temp.node.data);
        }
    }

    static class Pair {
        Node node;
        int distance;
        public Pair(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
