package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null)
            return arr;
        Queue<Container> q = new LinkedList<>();
        Map<Integer, Node> map = new TreeMap<>();
        q.add(new Container(root, 0));
        while(!q.isEmpty()){
            Container temp = q.poll();
            if(!map.containsKey(temp.hd))
                map.put(temp.hd, temp.node);
            if(temp.node.left != null)
                q.add(new Container(temp.node.left, temp.hd - 1));
            if(temp.node.right != null)
                q.add(new Container(temp.node.right, temp.hd + 1));
        }
        for(Node node: map.values()){
            arr.add(node.data);
        }
        return arr;
    }
    static class Container{
        Node node;
        int hd;
        public Container(Node node, int hd){
            this.node = node;
            this.hd = hd;
        }
    }
}
