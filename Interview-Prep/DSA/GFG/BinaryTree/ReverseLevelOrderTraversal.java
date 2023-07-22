package BinaryTree;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/*
 * First Attempt: Came up with Bruteforce Approach
*/
public class ReverseLevelOrderTraversal {

    class Node {
        int data;
        Node left, right;
    
        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Brute Force Approach
    // TC: O(N^2)
    // SC: O(N) worst case, O(lgN) if perfectly balanced
    public ArrayList<Integer> reverseLevelOrderDFS(Node node) {
        int ht = height(node);
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = ht; i >= 0; i--) {
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
    // Optimized Approach
    // TC: O(N)
    // SC: O(N)
    public ArrayList<Integer> reverseLevelOrder(Node node) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, ArrayList<Node>> map = new HashMap<>();
        addNodesToList(map, node, 1);
        map.forEach((k, v) -> {
            for (int i = v.size() - 1; i >= 0; i--)
                res.add(0, v.get(i).data);
        });
        return res;
    }

    public void addNodesToList(Map<Integer, ArrayList<Node>> map, Node node, int level) {
        if (node == null)
            return;
        if (map.get(level) == null)
            map.put(level, new ArrayList<>());
        ArrayList<Node> temp = map.get(level);
        temp.add(node);
        map.put(level, temp);
        addNodesToList(map, node.left, level + 1);
        addNodesToList(map, node.right, level + 1);
    }
}
