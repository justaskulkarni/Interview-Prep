package DSA.Leetcode.Graphs;
import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {
    class Node{
        int x;
        int y;
        int steps;
        public Node(int x, int y, int steps){
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        int[][] dirns = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0){
                    q.offer(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Node temp = q.poll();
            res[temp.x][temp.y] = temp.steps;
            for(int[] dirn: dirns){
                int x = dirn[0] + temp.x;
                int y = dirn[1] + temp.y;
                if(x >= 0 && y >= 0 && x < m && y < n && !vis[x][y]){
                    vis[x][y] = true;
                    q.add(new Node(x, y, temp.steps + 1));
                }
            }
        }    
        return res;
    }
}
