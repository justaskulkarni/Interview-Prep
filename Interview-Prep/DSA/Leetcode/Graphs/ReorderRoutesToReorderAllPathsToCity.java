package DSA.Leetcode.Graphs;
import java.util.ArrayList;

public class ReorderRoutesToReorderAllPathsToCity {
    public int minReorder(int n, int[][] connections) {
        ArrayList<int[]>[] arr = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int[] a: connections){
            arr[a[0]].add(new int[]{a[1], 1});
            arr[a[1]].add(new int[]{a[0], 0});
        }
        return dfs(arr, new boolean[n], 0);
    }
    public int dfs(ArrayList<int[]>[] arr, boolean[] vis, int x){
        vis[x] = true;
        int changes = 0;
        for(int[] y: arr[x])
            if(!vis[y[0]])
                changes += dfs(arr, vis, y[0]) + y[1];
        return changes;
    }
}
