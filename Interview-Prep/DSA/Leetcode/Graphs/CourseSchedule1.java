package DSA.Leetcode.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule1 {
    // DFS: Check for cycle in graph
    boolean hasCycle;
    public boolean detectCycle(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());
        for(int[] prerequisite: prerequisites){
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }   
        boolean[] vis = new boolean[numCourses]; 
        boolean[] onPath = new boolean[numCourses];
        hasCycle = false;
        for(int i = 0; i < numCourses; i++){
            dfs(adjList, i, vis, onPath);
        }
        return !hasCycle;
    } 
    public void dfs(List<List<Integer>> adjList, int node, boolean[] vis, boolean[] onPath){
        if(onPath[node]){
            hasCycle = true;
        }
        if(vis[node] || hasCycle)
            return ;
        vis[node] = true;
        onPath[node] = true;
        for(int neighbour: adjList.get(node))
            dfs(adjList, neighbour, vis, onPath);
        onPath[node] = false;
    }
    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int[] indeg = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());
        for(int[] prereq: prerequisites){
            adjList.get(prereq[1]).add(prereq[0]);
            indeg[prereq[0]]++;
        }   
        Queue<Integer> q = new LinkedList<>();    
        for(int i = 0; i < numCourses; i++)
            if(indeg[i] == 0)
                q.add(i);
        int count = 0;
        while(!q.isEmpty()){
            int temp = q.poll();
            ++count;
            for(int neighbour: adjList.get(temp)){
                indeg[neighbour]--;
                if(indeg[neighbour] == 0)
                    q.add(neighbour);
            }
        }
        return count == numCourses;
    }
}
