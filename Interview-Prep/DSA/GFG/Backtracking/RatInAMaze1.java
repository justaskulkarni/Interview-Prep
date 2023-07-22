package Backtracking;

import java.util.ArrayList;

public class RatInAMaze1 {

    // TC: O(4^(N^2)) As 4 recursive calls for each cell in the matrix
    // SC: O(1)

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        helper(m, res, 0, 0, "");
        return res;
        
    }
    public static void helper(int[][] m, ArrayList<String> list, int x, int y, String s){
        int n = m.length;
        if(x < 0 || y < 0 || x >= n || y >= n || m[x][y] == 0)
            return ;
        if(x == n - 1 && y == n - 1){
            list.add(s);
            return ;
        }
        m[x][y] = 0;
        helper(m, list, x - 1, y, s + "U");
        helper(m, list, x, y + 1, s + "R");
        helper(m, list, x, y - 1, s + "L");
        helper(m, list, x + 1, y, s + "D");
        m[x][y] = 1;
    }
}
