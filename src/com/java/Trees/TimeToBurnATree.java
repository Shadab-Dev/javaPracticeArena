package com.java.Trees;

import java.util.*;

public class TimeToBurnATree {
    class Node {
    	int data;
    	Node left;
    	Node right;

    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }

	public static int minTime(Node root, int target) {
		// Main runner class
		// We can divide this problem into 2 different parts
		// First we run BFS and create a child to parent map. This would convert the tree problem into a graph problem
		// At this step we also return the Node of the target since ref to target is not provided as input
		Map<Node, Node> parentMap = new HashMap<>();
		Node targetNode = findTarget(root, target, parentMap);
		// The next step is to calculate the min time required by starting at the target node and radially moving outwards in the graph
		int min = calculateMinTimeTaken(targetNode, parentMap);
		return min;
	}

	// Simple BFS method which traverses the whole tree and creates a child-parent mapping
	private static Node findTarget(Node root, int target, Map<Node, Node> parentMap) {
		if(root == null) return root;
		Node result = null;
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			if(temp.data == target) result = temp;
			if(temp.left!=null) {
				parentMap.put(temp.left, temp);
				queue.offer(temp.left);
			}
			if(temp.right!=null) {
				parentMap.put(temp.right, temp);
				queue.offer(temp.right);
			}
		}
		return result;
	}

	private static int calculateMinTimeTaken(Node root, Map<Node, Node> parentMap) {
		if(root == null) return -1;
		// We initialize the result as 0 since even 1 node in the graph will take at least 0 time
		int min = 0;
		// We create a visited Set to keep track of nodes that we have already visited in the graph
		Set<Node> visited = new HashSet<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);
		visited.add(root);
		while(!queue.isEmpty()) {
			int count = queue.size();
			// We need to make sure, that at every radial level we only increment the result by 1
			// since all the radial level nodes will get burnt at the same time
			boolean anythingBurned = false;
			for(int i = 0; i<count; i++) {
				Node temp = queue.poll();
				// we only add to queue and set if the the node is not visited
				// We need to check the null condition as well as the visited condition for each child and parent
				// If we don't then we will get outOfMemory error as we will keep traversing between the nodes
				if(temp.left!=null && !visited.contains(temp.left)) {
					queue.offer(temp.left);
					visited.add(temp.left);
					anythingBurned = true;
				}
				if(temp.right!=null && !visited.contains(temp.right)) {
					queue.offer(temp.right);
					visited.add(temp.right);
					anythingBurned = true;
				}
				if(parentMap.get(temp) != null && !visited.contains(parentMap.get(temp))) {
					queue.offer(parentMap.get(temp));
					visited.add(parentMap.get(temp));
					anythingBurned = true;
				}
			}
			if(anythingBurned) min++;
		}
		return min;
	}
}
