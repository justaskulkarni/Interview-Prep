package DSA.Leetcode.Graphs;
import java.util.Arrays;
import javafx.util.Pair;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.ArrayList;
public class ShortestPathWithAlternatingColors {
    enum Color{kInit, kRed, kBlue}
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        List<Pair<Integer, Color>>[] graph = new List[n];
        Queue<Pair<Integer, Color>> q = new ArrayDeque<>(Arrays.asList(new Pair<>(0, Color.kInit)));
        for(int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for(int[] edge: redEdges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(new Pair<>(v, Color.kRed));
        }
        for(int[] edge: blueEdges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(new Pair<>(v, Color.kBlue));
        }
        for(int step = 0; !q.isEmpty(); step++){
            for(int sz = q.size(); sz > 0; sz--){
                int u = q.peek().getKey();
                Color prevColor = q.poll().getValue();
                ans[u] = ans[u] == -1 ? step: ans[u];
                for(int i = 0; i < graph[u].size(); i++){
                    Pair<Integer, Color> node = graph[u].get(i);
                    int v = node.getKey();
                    Color edgeColor = node.getValue();
                    if(v == -1 || edgeColor == prevColor)
                        continue;
                    q.add(new Pair<>(v, edgeColor));
                    graph[u].set(i, new Pair<>(-1, edgeColor));
                }
            }
        }
        return ans;
    }
}