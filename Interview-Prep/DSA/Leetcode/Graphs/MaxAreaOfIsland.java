package DSA.Leetcode.Graphs;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        boolean[][] vis = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int curr = dfs(grid, vis, i, j);
                    maxArea = Math.max(maxArea, curr);
                }
            }
        }    
        return maxArea;
    }
    public int dfs(int[][] grid, boolean[][] vis, int x, int y){
        int m = grid.length;
        int n = grid[0].length;
        if(x < 0 || y < 0 || x >= m || y >= n || vis[x][y] || grid[x][y] == 0)
            return 0;
        int[][] dirns = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        vis[x][y] = true;
        int area = 1;
        for(int[] dirn: dirns){
            int x1 = dirn[0] + x;
            int y1 = dirn[1] + y;
            area += dfs(grid, vis, x1, y1);
        }
        return area;
    }
}
