package com.java.Trees;

import com.java.TreeNode;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class MaxWidthOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        root.right.right.right = new TreeNode(7);
        MaxWidthOfTree c = new MaxWidthOfTree();
        System.out.println(c.widthOfBinaryTree(root));
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        // The idea is to use BFS along with storing the index of each node in a HashMap
        Queue<TreeNode> queue = new ArrayDeque<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        // We first insert the root along with its index in BFS queue and map
        queue.offer(root);
        map.put(root, 1);
        int currentWidth, maxWidth = 0;
        while (!queue.isEmpty()) {
            int count = queue.size();
            int start = 0, end = 0;
            for (int i = 0; i < count; i++) {
                TreeNode temp = queue.poll();
                // If i is 0, then it means this is the first node in that level, so we update the start
                if(i == 0) start = map.get(temp);
                // If i is size-1 then it means that is the last node in that level, so we update end
                if(i == count-1) end = map.get(temp);

                // This is a very important step. We update the queue with the node as well as add the node to the map along with its index,
                // The index of any node in the binary tree can be calculated as 2*indexOfParent and 2*indexOfParent+1 for left and right respectively.
                if(temp.left!=null) {
                    queue.offer(temp.left);
                    map.put(temp.left, 2*map.get(temp));
                }
                if(temp.right!=null) {
                    queue.offer(temp.right);
                    map.put(temp.right, 2*map.get(temp) + 1);
                }
            }
            // Now we simply compute the width in that level to be end - start + 1
            currentWidth = end - start + 1;
            maxWidth = Math.max(maxWidth, currentWidth);
        }
        return maxWidth;
    }
}
