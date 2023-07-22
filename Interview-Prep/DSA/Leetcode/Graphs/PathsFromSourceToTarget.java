package DSA.Leetcode.Graphs;
import java.util.ArrayList;
import java.util.List;

public class PathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(0);
        dfs(graph, arr, res, 0, graph.length - 1);
        return res;
    }
    public void dfs(int[][] graph, List<Integer> arr, List<List<Integer>> res, int node, int target){
        if(node == target){
            res.add(arr);
            return ;
        }
        for(int neighbour: graph[node]){
            arr.add(neighbour);
            dfs(graph, arr, res, neighbour, target);
            arr.remove(arr.size() - 1);
        }
    }
}
