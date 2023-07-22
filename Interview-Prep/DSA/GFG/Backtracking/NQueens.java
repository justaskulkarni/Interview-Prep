package Backtracking;

import java.util.ArrayList;

public class NQueens {
    // TC: O(N^2)
    // SC: O(N)
    static ArrayList<ArrayList<Integer>> result;
    static boolean[] cols, leftDiagonal, rightDiagonal;
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        cols = new boolean[n];
        // leftDiagonal[i] = true if there is a queen previously placed at 
          // i = (row + col )th left diagonal
        leftDiagonal = new boolean[2*n];
          // rightDiagonal[i] = true if there is a queen previously placed at 
          // i = (row - col + n - 1)th rightDiagonal diagonal
        rightDiagonal = new boolean[2*n];
        result  = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++)temp.add(0);
        solveNQUtil(result,n,0,temp);
        return result;
    }
    static void solveNQUtil(ArrayList<ArrayList<Integer>> res, int n, int row, ArrayList<Integer> comb){
        if(row==n){
          // if row==n it means we have successfully placed all n queens.
          // hence add current arrangement to our answer
          // comb represent current combination
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int col = 0;col<n;col++){
           // if we have a queen previously placed in the current column 
           // or in current left or right diagonal we continue
            if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
                continue;
           // otherwise we place a queen at cell[row][col] and 
           //make current column, left diagonal and right diagonal true
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
            comb.set(col,row+1);
            // then we goto next row
            solveNQUtil(result,n,row+1,comb);
            // then we backtrack and remove our currently placed queen
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;    
        }
    }
}
