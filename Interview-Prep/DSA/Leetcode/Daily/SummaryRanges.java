package DSA.Leetcode.Daily;
import java.util.ArrayList;
import java.util.List;

public class SummaryRanges{
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> arr = new ArrayList<>();
        if(n == 0){
            return arr;
        }
            
        StringBuilder sb = new StringBuilder(String.valueOf(nums[0]));
        boolean flag = false;
        
        for(int i = 1; i < n; i++){
            int diff = nums[i] - nums[i - 1];
            if(diff == 1){
                if(!flag){
                    sb = new StringBuilder(String.valueOf(nums[i - 1]) + "->" + String.valueOf(nums[i]));
                    flag = true;
                }
                else{
                    int ind = sb.indexOf(">");
                    sb.replace(ind + 1, sb.length(), String.valueOf(nums[i]));
                }
            }
            else{
                arr.add(sb.toString());
                sb = new StringBuilder(String.valueOf(nums[i]));
                flag = false;   
            }
        }
        arr.add(sb.toString());
        return arr;
    }
}