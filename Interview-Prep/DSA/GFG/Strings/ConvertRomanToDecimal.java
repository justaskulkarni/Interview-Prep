package Strings;

import java.util.HashMap;
import java.util.Map;

public class ConvertRomanToDecimal {
    public int romanToDecimal(String str) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int res = 0;
        int n = str.length();
        for(int i = 0; i < n - 1; i++){
            Character curr = str.charAt(i);
            Character next = str.charAt(i + 1);
            if(map.get(curr) >= map.get(next)){
                res += map.get(curr);
            }
            else{
                res -= map.get(curr);
            }
        }
        res += map.get(str.charAt(n - 1));
        
        return res;
    }
}
