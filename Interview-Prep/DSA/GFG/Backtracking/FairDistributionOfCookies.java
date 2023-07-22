package Backtracking;

public class FairDistributionOfCookies {
    int[] count;
    int ans;
    public int distributeCookies(int[] cookies, int k) {
        count = new int[k];
        ans = Integer.MAX_VALUE;
        helper(cookies, k, 0);
        return ans;
    }
    public void helper(int[] cookies, int k, int cookieNumber){
        if(cookieNumber == cookies.length){
            int max = 0;
            for(int i = 0; i < k; i++)
                max = Math.max(max, count[i]);
            ans = Math.min(ans, max);
            return ;
        }
        for(int i = 0; i < k; i++){
            count[i] += cookies[cookieNumber];
            helper(cookies, k, cookieNumber + 1);
            count[i] -= cookies[cookieNumber];
            if(count[i] == 0)
                break;
        }
    }
}
