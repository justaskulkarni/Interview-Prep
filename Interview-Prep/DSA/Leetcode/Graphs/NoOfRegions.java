package DSA.Leetcode.Graphs;

import java.util.Queue;
import java.util.LinkedList;

public class NoOfRegions {
    // BFS and DFS approach
    // TC: O(N^2) since we are traversing the entire matrix
    // SC: O(N) due to isVisited array, also recursion call stack can have maximum of n elements
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int provinces = 0;
        boolean[] isVisited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!isVisited[i]){
                ++provinces;
                bfs(isConnected, isVisited, i);
            }
        } 
        return provinces;
    }
    public void dfs(int[][] isConnected, boolean[] isVisited, int node){
        isVisited[node] = true;
        int n = isConnected.length;
        for(int neighbour = 0; neighbour < n; neighbour++){
            if(isConnected[node][neighbour] == 1 && !isVisited[neighbour])
                dfs(isConnected, isVisited, neighbour);
        }
    }
    public void bfs(int[][] isConnected, boolean[] isVisited, int node){
        isVisited[node] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            int j = q.poll();
            int n = isConnected[j].length;
            for(int i = 0; i < n; i++){
                if(!isVisited[i] && isConnected[j][i] == 1){
                    isVisited[i] = true;
                    q.add(i);
                }
            }
        }
    } 
    // Union Find Approach
    // Initially set rank of every node as 1
    // Set every node as parent of itself
    // Using nested for loop check whether every two pairs of nodes are connected
    // If yes, call union_find function
    // Using find function, find the parents of the two nodes
    // For the node that has higher rank, add to it rank of other node and set it as the other node's parent
    // TC: O(N)
    // SC: O(N)
    int[] par;
    int[] rank;
    public int findCircleNumUnionFind(int[][] isConnected) {
        int n = isConnected.length;
        par = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            rank[i] = 1;
        }
        int groups = n;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1)
                    groups -= union_find(i, j);
            }
        }
        return groups;
    }
    public int union_find(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2)
            return 0;
        if(rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }
    public int find(int n){
        while(par[n] != n){
            par[n] = par[par[n]];
            n = par[n];
        }
        return n;
    }   
}
