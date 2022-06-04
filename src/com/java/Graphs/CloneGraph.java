package com.java.Graphs;

import java.lang.reflect.Array;
import java.util.*;

public class CloneGraph {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors = Arrays.asList(n2, n4);
        n2.neighbors = Arrays.asList(n1, n3);
        n3.neighbors = Arrays.asList(n2, n4);
        n4.neighbors = Arrays.asList(n1, n3);
        Node copy = new CloneGraph().cloneGraph(n1);

    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    public Node dfs(Node node, Map<Node, Node> map) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);

        Node head = new Node(node.val);
        map.put(node, head);
        for(Node neighbor: node.neighbors) {
            head.neighbors.add(dfs(neighbor, map));
        }
        return head;
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
