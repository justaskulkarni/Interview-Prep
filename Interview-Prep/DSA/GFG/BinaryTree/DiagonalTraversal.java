package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class DiagonalTraversal {
    // Recursive Approach using Map
    // TC: O(NlogN)
    // SC: O(N)
    Map<Integer, ArrayList<Integer>> map;

    public ArrayList<Integer> diagonalRec(Node root) {
        map = new TreeMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, 0);
        for (ArrayList<Integer> arr : map.values()) {
            for (int a : arr)
                res.add(a);
        }
        return res;
    }

    public void helper(Node root, int dist) {
        if (root == null)
            return;
        ArrayList<Integer> temp = map.get(dist);
        if (temp != null)
            temp.add(root.data);
        else {
            temp = new ArrayList<>();
            temp.add(root.data);
        }
        map.put(dist, temp);
        helper(root.left, dist + 1);
        helper(root.right, dist);
    }

    // Iterative Approach using Queue

    public ArrayList<Integer> diagonalIter(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Node> leftq = new LinkedList<>();
        Node node = root;
        while (node != null) {
            arr.add(node.data);
            if (node.left != null)
                leftq.add(node.left);
            if (node.right != null)
                node = node.right;
            else {
                if (!leftq.isEmpty()) {
                    node = leftq.poll();
                } else
                    node = null;
            }
        }
        return arr;
    }
}
