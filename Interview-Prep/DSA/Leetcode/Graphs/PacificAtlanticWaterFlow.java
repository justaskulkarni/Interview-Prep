package DSA.Leetcode.Graphs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {
    /*
     * Time Complexity : O(M*N), When worst case occur then all cells are reachable to both oceans and also visited twice. And this will happened only when all elements are become equal.
       Space Complexity : O(M*N), to mark the atlantic and pacific visited cells.
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0)
                    dfs(heights, pacific, i, j, 0);
                if(i == m - 1 || j == n - 1)
                    dfs(heights, atlantic, i, j, 0);
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(atlantic[i][j] && pacific[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }    
        return res;
    }
    public void dfs(int[][] heights, boolean[][] sea, int x, int y, int prev){
        if(x < 0 || x >= heights.length || y < 0 || y >= heights[0].length)
            return ;
        if(heights[x][y] < prev)
            return ;
        if(sea[x][y])
            return ;
        sea[x][y] = true;
        int[][] dirns = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dirn: dirns){
            dfs(heights, sea, x + dirn[0], y + dirn[1], heights[x][y]);
        }
    }    
}
