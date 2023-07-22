package DSA.Leetcode.Graphs;
import java.util.ArrayList;
import java.util.List;

public class SmallestSetOfVertices {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> arr = new ArrayList<>();
        int[] count = new int[n];
        for(List<Integer> edge: edges){
            count[edge.get(1)]++;
        }
        for(int i = 0; i < n; i++)
            if(count[i] == 0)
                arr.add(i);
        return arr;
    }
}
