package DSA.Leetcode.Graphs;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge{
    // Multisource BFS
    // TC: O(N^2)
    // SC: O(N^2)
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirns = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean flag = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dfs(grid, vis, dirns, q, i, j);
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }    
        int step = 0;
        while(!q.isEmpty()){
            int n1 = q.size();
            for(int k = 0; k < n1; k++){
                int[] temp = q.poll();
                for(int[] dirn: dirns){
                    int i = dirn[0] + temp[0];
                    int j = dirn[1] + temp[1];
                    if(i >= 0 && j >= 0 && i < n && j < n && !vis[i][j]){
                        if(grid[i][j] == 1)
                            return step;
                        q.add(new int[]{i, j});
                        vis[i][j] = true;
                    }
                }
            }
            ++step;
        }
        return -1;
    }
    public void dfs(int[][] grid, boolean[][] vis, int[][] dirns, Queue<int[]> q, int i, int j){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid.length - 1 || grid[i][j] == 0 || vis[i][j])
            return ;
        vis[i][j] = true;
        q.add(new int[]{i, j});
        for(int[] dirn: dirns)
            dfs(grid, vis, dirns, q, i + dirn[0], j + dirn[1]);
    }
}