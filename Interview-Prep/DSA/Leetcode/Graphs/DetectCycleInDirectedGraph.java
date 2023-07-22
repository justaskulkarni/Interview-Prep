package DSA.Leetcode.Graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraph {
    boolean hasCycle;
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        hasCycle = false;
        for(int i = 0; i < V; i++)
            dfs(adj, i, new boolean[V], new boolean[V]);
        return hasCycle;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, boolean[] pathVis){
        if(pathVis[node])
            hasCycle = true;
        if(hasCycle || vis[node])
            return ;
        vis[node] = true;
        pathVis[node] = true;
        for(int neighbour: adj.get(node)){
            dfs(adj, neighbour, vis, pathVis);
        }
        pathVis[node] = false;
    }
}
