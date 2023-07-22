package BinaryTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {
    public ArrayList<Integer> bottomView(Node root)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null)
            return arr;
        Map<Integer, Node> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair temp = q.poll();
            int hd = temp.hd;
            Node node = temp.node;
            if(!map.containsKey(hd))
                map.put(hd, node);
            else{
                map.remove(hd);
                map.put(hd, node);
            }
            if(node.left != null)
                q.add(new Pair(node.left, hd - 1));
            if(node.right != null)
                q.add(new Pair(node.right, hd + 1));
        }
        for(Node node: map.values()){
            arr.add(node.data);
        }
        return arr;
    }
    
    static class Pair{
        Node node;
        int hd;
        Pair(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
}
