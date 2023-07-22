package DSA.Leetcode.Graphs;

/*
Intuition
Whenever we are visiting a room, we get keys of certain other rooms.
Upon getting a key and if the corresponding room is not visited then go and visit the room.
Proceeding in this manner, if all of the rooms are visited, then return true, else false

Approach
Maintain a visited array, each element initialized to false initially
Perform dfs on the very first room
Mark it as visited and then apply dfs on every room which is unvisited and for which there is a key
In the end if all elements of vis array are true then return true
Else false

Complexity
Time complexity:
O(N)
Here N represents number of rooms
This is because we are traversing vis array and also dfs can be called at worst for every room

Space complexity:
O(N)
For vis array as well as call stack
 */
import java.util.List;
public class CanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        dfs(rooms, vis, 0);  
        for(int i = 0; i < n; i++)
            if(!vis[i])
                return false;
        return true;  
    }
    public void dfs(List<List<Integer>> rooms, boolean[] vis, int node){
        vis[node] = true;
        List<Integer> arr = rooms.get(node);
        for(int neighbour: arr)
            if(!vis[neighbour])
                dfs(rooms, vis, neighbour);
    }
}
