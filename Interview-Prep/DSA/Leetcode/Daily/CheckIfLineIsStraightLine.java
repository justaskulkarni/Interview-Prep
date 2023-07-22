package DSA.Leetcode.Daily;
public class CheckIfLineIsStraightLine{
    public boolean checkStraightLine(int[][] coordinates) {
        float s = (float) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        if(coordinates[1][0] == coordinates[0][0])
            s = Float.MAX_VALUE;
        int n = coordinates.length;
        for(int i = 2; i < n; i++){
            float s1 = (float) (coordinates[i][1] - coordinates[0][1]) / (coordinates[i][0] - coordinates[0][0]); 
            if(coordinates[i][0] == coordinates[0][0])
                s1 = Float.MAX_VALUE;
            if(s1 != s)
                return false;
        }
        return true;    
    }
}