package Matrix;
import java.util.ArrayList;
public class SpiralTraversal {
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;
        while (left < right && top < bottom){
            for(int i = left; i < right; i++)
                res.add(matrix[top][i]);
            top++;
            for(int i = top; i < bottom; i++)
                res.add(matrix[i][right - 1]);
            right--;
            if(!(left < right && top < bottom))
                break;
            for(int i = right - 1; i > left - 1; i--)
                res.add(matrix[bottom - 1][i]);
            bottom--;
            for(int i = bottom - 1; i > top - 1; i--)
                res.add(matrix[i][left]);
            left++;
        }
        return res;
    }
}
