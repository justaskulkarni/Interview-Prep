package DSA.Leetcode.Graphs;

public class IsGraphBipartite {
    // Union Find
    // Intuition: When the adjacency list is considered, the node should be in one set and all of the other vertices in the list should be in another set and this has to be true for each and every node.
    int[] par;
    int[] rank;
    public boolean isBipartiteUnionFind(int[][] graph) {
        int n = graph.length;
        par = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++)
            par[i] = i;
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(isConnected(i, graph[i][j]))
                    return false;
                union(graph[i][0], graph[i][j]);
            }
        }
        return true;
    }
    public void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2)
            return ;
        if(rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
    }
    public int find(int n){
        while(par[n] != n){
            par[n] = par[par[n]];
            n = par[n];
        }
        return n;
    }
    public boolean isConnected(int n1, int n2){
        return par[n1] == par[n2];
    }
    // Graph Coloring
    public boolean isBipartiteColoring(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for(int i = 0; i < n; i++){
            if(color[i] == 0 && !dfs(graph, color, i, 1))
                return false;
        }    
        return true;
    }
    public boolean dfs(int[][] graph, int[] color, int node, int rang){
        if(color[node] != 0)
            return color[node] == rang;
        color[node] = rang;
        for(int vertex: graph[node])
            if(!dfs(graph, color, vertex, -rang))
                return false;
        return true;
    } 
}
