package DSA.Leetcode.Graphs;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
public class FindEventualSafeStates {
    // DFS Approach
    // TC: O(N)
    // SC: O(N)
    // vis and pathVis are for cycle detection
    // For unvisited nodes, call dfsCheck function
    // Here, mark the calling node as visited and also mark it in pathVis 
    // Now check adjacency list correponding to that node
    // For every node in adjacency list -> If dfs check for that node returns true(ie it is a part of cycle), then even this node will be a part of cycle, so return true
    //                                     If pathVis is 1, then we have come back to the same node, so cycle has been detected
    //                                     If neither of the two conditions are satisfied, it is not a part of cycle so it is safe, set check as 1 and reset pathVis to false
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        for(int i = 0; i < n; i++){
            if(vis[i] == 0)
                dfsCheck(i, graph, vis, pathVis, check);
        }
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(check[i] == 1)
                arr.add(i);
        return arr;
    }
    public boolean dfsCheck(int node, int[][] graph, int[] vis, int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for(int it: graph[node]){
            if(vis[it] == 0){
                if(dfsCheck(it, graph, vis, pathVis, check) == true)
                    return true;
            }
            else if(pathVis[it] == 1)
                return true;
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    // BFS
    public List<Integer> eventualSafeNodesBFS(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int n = graph.length;
        int[] outdeg = new int[n];
        for(int i = 0; i < n; i++)
            list.add(new ArrayList<>());
        for(int i = 0; i < n; i++){
            for(int vertex: graph[i]){
                list.get(vertex).add(i);
                outdeg[i]++;
            }
        }    
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(outdeg[i] == 0){
                q.add(i);
                res.add(i);
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int node: list.get(temp)){
                if(--outdeg[node] == 0){
                    q.add(node);
                    res.add(node);
                }
            }
        }
        Collections.sort(res);
        return res;
    }
}
