package BinaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * First Attempt: Came up with BFS Approach
*/


public class LevelOrderTraversal {
    // DFS Approach
    // TC: O(n^2)
    /*
     * Reason:
     * Helper method has time complexity O(n) + O(n - 1) + O(n - 2) + ... + O(1)
    */
    // SC: O(n) in worst case, O(logn) for balanced tree
    public ArrayList<Integer> levelOrderDFS(Node node) {
        int ht = height(node);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= ht; i++) {
            helper(node, arr, i);
        }
        return arr;
    }

    public int height(Node node) {
        if (node == null)
            return 0;
        int lheight = height(node.left);
        int rheight = height(node.right);
        return Math.max(lheight, rheight) + 1;
    }

    public void helper(Node node, ArrayList<Integer> arr, int level) {
        if (node == null)
            return;
        if (level == 1)
            arr.add(node.data);
        else if (level > 1) {
            helper(node.left, arr, level - 1);
            helper(node.right, arr, level - 1);
        }
    }
    // BFS Approach 
    // TC: O(n)
    // SC: O(n)
    static ArrayList<Integer> levelOrderBFS(Node node) {
        // Your code here
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            arr.add(curr.data);
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return arr;
    }
}
