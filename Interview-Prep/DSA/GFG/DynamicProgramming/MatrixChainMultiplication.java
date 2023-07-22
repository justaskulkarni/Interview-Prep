package DynamicProgramming;
/*
    Two matrices of size m*n and n*p when multiplied, they generate a matrix of size m*p and the number of multiplications performed are m*n*p.
    Now, for a given chain of N matrices, the first partition can be done in N-1 ways. For example, sequence of matrices A, B, C and D can be grouped as (A)(BCD), (AB)(CD) or (ABC)(D) in these 3 ways. 
 */
import java.util.Arrays;

public class MatrixChainMultiplication {
    static int helper(int p[], int i, int j)
    {
        if (i == j)
            return 0;
 
        int min = Integer.MAX_VALUE;
 
        // Place parenthesis at different places
        // between first and last matrix,
        // recursively calculate count of multiplications
        // for each parenthesis placement
        // and return the minimum count
        for (int k = i; k < j; k++) {
            int count = helper(p, i, k)
                        + helper(p, k + 1, j)
                        + p[i - 1] * p[k] * p[j];
 
            if (count < min)
                min = count;
        }
 
        // Return minimum count
        return min;
    }

    static int matrixMultiplicationRecursion(int N, int arr[]) {
        return helper(arr, 1, N - 1);
    }

    // Memoization
    // TC: O(N^3)
    // SC: O(N^2)
    static int[][] dp = new int[100][100];

    static int matrixMultiplication(int N, int arr[]) {
        for (int i = 0; i < 100; i++)
            Arrays.fill(dp[i], -1);
        return matrixChainMemoised(arr, 1, N - 1);
    }

    static int matrixChainMemoised(int[] p, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            dp[i][j] = Math.min(
                    dp[i][j], matrixChainMemoised(p, i, k)
                            + matrixChainMemoised(p, k + 1, j)
                            + p[i - 1] * p[k] * p[j]);
        }
        return dp[i][j];
    }
    // Tabulation
    static int matrixMultiplicationTabulation(int n, int p[])
    {
        int m[][] = new int[n][n];
 
        int i, j, k, L, q;
 
        /* m[i, j] = Minimum number of scalar
        multiplications needed to compute the matrix
        A[i]A[i+1]...A[j] = A[i..j] where
        dimension of A[i] is p[i-1] x p[i] */
 
        // cost is zero when multiplying one matrix.
        for (i = 1; i < n; i++)
            m[i][i] = 0;
 
        // L is chain length.
        for (L = 2; L < n; L++)
        {
            for (i = 1; i < n - L + 1; i++)
            {
                j = i + L - 1;
                
                m[i][j] = Integer.MAX_VALUE;
                for (k = i; k <= j - 1; k++)
                {
                    // q = cost/scalar multiplications
                    q = m[i][k] + m[k + 1][j]
                        + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
 
        return m[1][n - 1];
    }
}