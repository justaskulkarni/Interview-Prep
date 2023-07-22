package DynamicProgramming;

public class NinjaTraining {
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][3];
        for(int i = 0; i < 3; i++)
            dp[0][i] = points[0][i];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 3; j++){
                if(j == 0){
                    dp[i][j] = Math.max(dp[i - 1][1], dp[i - 1][2]) + points[i][j];
                }
                else if(j == 1){
                    dp[i][j] = Math.max(dp[i - 1][0], dp[i - 1][2]) + points[i][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][1], dp[i - 1][0]) + points[i][j];
                }
            }
        }
        int maxAns = Integer.MIN_VALUE;
        for(int i = 0; i < 3; i++){
            maxAns = Math.max(maxAns, dp[n - 1][i]);
        }
        return maxAns;
    }
}
