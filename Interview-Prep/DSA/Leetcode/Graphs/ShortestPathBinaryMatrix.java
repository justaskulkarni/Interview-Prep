package DSA.Leetcode.Graphs;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
            return -1;
        int n = grid.length;
        if(n == 1)
            return (grid[0][0] == 0) ? 1: -1;
        int[][] dirns = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, -1}, {-1, 1}, {1, 1}};
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int ans = 0;
        while(!q.isEmpty()){
            int m = q.size();
            ++ans;
            for(int i = 0; i < m; i++){
                int[] temp = q.poll();
                for(int[] dirn: dirns){
                    int x = dirn[0] + temp[0];
                    int y = dirn[1] + temp[1];
                    if(x >= 0 && y >= 0 && x < n && y < n && !vis[x][y] && grid[x][y] == 0){
                        if(x == n - 1 && y == n - 1)
                            return ans + 1;
                        vis[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
            }
        } 
        return -1;
    }
}
