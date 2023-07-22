package DSA.Leetcode.Graphs;

public class NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i*j==0 || i==m-1 || j==n-1) && (grid[i][j]==0))
                    dfs(i, j, grid);
            }
        }
        
        int count = 0;
        for (int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int i, int j, int[][] grid){
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 0)
            return;

        grid[i][j] = 1;
        int[][] dirns = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for(int[] dirn: dirns){
            int nx = i + dirn[0];
            int ny = j + dirn[1];
            dfs(nx, ny, grid);
        }      
    }
}
