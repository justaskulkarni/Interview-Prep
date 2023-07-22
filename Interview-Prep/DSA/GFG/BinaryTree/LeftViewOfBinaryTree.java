package BinaryTree;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
// First Attempt: Came up with an approach that passed 600/603 test cases. But thinking was incorrect

public class LeftViewOfBinaryTree {

    class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Recursion
    // TC: O(N)
    // SC: O(h)
    // Keep track of the level of a node by passing the level as a parameter to all recursive calls and also keep track of the maximum level.Whenever,we see a node whose level is more than maximum level so far,we print the node because this is the first node in its level
    int maxLevel = 0;

    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        leftViewUtil(root, arr, 1);
        return arr;
    }

    void leftViewUtil(Node root, ArrayList<Integer> arr, int level) {
        if (root == null)
            return;
        if (level > maxLevel) {
            maxLevel = level;
            arr.add(root.data);
        }
        leftViewUtil(root.left, arr, level + 1);
        leftViewUtil(root.right, arr, level + 1);
    }
    // Level order traversal
    // TC: O(N)
    // SC: O(N)
    ArrayList<Integer> leftViewLevelOrder(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if (root == null)
            return arr;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                Node temp = q.poll();
                if (i == 1)
                    arr.add(temp.data);
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
        }
        return arr;
    }
}
