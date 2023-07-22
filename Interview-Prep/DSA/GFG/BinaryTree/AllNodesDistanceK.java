package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceK {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Set<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();
        mapParents(map, root);
        q.add(target);
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode temp = q.poll();
                vis.add(temp);
                if(k == 0)
                    res.add(temp.val);
                if(map.containsKey(temp) && !vis.contains(map.get(temp)))
                    q.add(map.get(temp));
                if(temp.left != null && !vis.contains(temp.left))
                    q.add(temp.left);
                if(temp.right != null && !vis.contains(temp.right))
                    q.add(temp.right);
            }
            k--;
            if(k < 0)
                break;
        }
        return res;
    }
    public void mapParents(Map<TreeNode, TreeNode> map, TreeNode node){
        if(node == null)
            return ;
        if(node.left != null){
            map.put(node.left, node);
        }
        if(node.right != null){
            map.put(node.right, node);
        }
        mapParents(map, node.left);
        mapParents(map, node.right);
    }
}
