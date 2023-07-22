package DSA.Leetcode.Graphs;

import java.util.LinkedList;
import java.util.Queue;

// Multisource BFS
// TC: O(N*M)
// SC: O(N*M)

public class NearestExitFromEntranceInMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int l = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[l][m];
        Queue<int[]> q = new LinkedList<>();
        int[][] dirns = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int ans = 0;
        q.add(entrance);
        vis[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()){
            int n = q.size();
            ans++;
            for(int i = 0; i < n; i++){
                int[] temp = q.poll();
                for(int[] dirn: dirns){
                    int x = dirn[0] + temp[0];
                    int y = dirn[1] + temp[1];
                    if(x >= 0 && y >= 0 && x < l && y < m && !vis[x][y] && maze[x][y] == '.'){
                        if(x == 0 || y == 0 || x == l - 1 || y == m - 1)
                            return ans;
                        vis[x][y] = true;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }    
        return -1;
    }
}
