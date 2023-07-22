package Strings;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1)  
            return "1";
        if(n == 2)
            return "11";
        String s = "11";
        for(int i = 3; i <= n; i++){
            s = s + "Q";
            StringBuilder t = new StringBuilder();
            int count = 1;
            for(int j = 1; j < s.length(); j++){
                if(s.charAt(j) != s.charAt(j - 1)){
                    t.append(String.valueOf(count));
                    t.append(String.valueOf(s.charAt(j - 1)));
                    count = 1;
                }
                else
                    count++;
            }
            s = new String(t.toString());
        }    
        return s;
    }
}
