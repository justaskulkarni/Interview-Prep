package DSA.Leetcode.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++)
            adjList.add(new ArrayList<>());
        int[] indeg = new int[numCourses];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int[] prereq: prerequisites){
            adjList.get(prereq[1]).add(prereq[0]);
            indeg[prereq[0]]++;
        }    
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indeg[i] == 0){
                q.add(i);
                ans.add(i); 
            }
        }
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int neighbour: adjList.get(temp)){
                if(--indeg[neighbour] == 0){
                    q.add(neighbour);
                    ans.add(neighbour);
                }
            }
        }
        if(ans.size() != numCourses)
            return new int[0];
        int[] res = new int[ans.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = ans.get(i);
        return res;
    }
}
