package DSA.Leetcode.Graphs;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    dfs(grid, vis, i, j);
                    ++count;
                }
            }
        }   
        return count;
    }
    public void dfs(char[][] grid, boolean[][] vis, int x, int y){
        
        int m = grid.length;
        int n = grid[0].length;
        vis[x][y] = true;

        int[][] dirns = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        for(int[] dirn: dirns){
            int x1 = x + dirn[0];
            int y1 = y + dirn[1];
            if(x1 >= 0 && y1 >= 0 && x1 < m && y1 < n && !vis[x1][y1] && grid[x1][y1] == '1')
                dfs(grid, vis, x1, y1);
        }
    }
}
