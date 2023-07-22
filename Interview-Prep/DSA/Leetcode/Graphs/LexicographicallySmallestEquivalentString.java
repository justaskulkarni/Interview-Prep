package DSA.Leetcode.Graphs;

public class LexicographicallySmallestEquivalentString {
    int[] par;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        par = new int[26];
        for(int i = 0; i < 26; i++){
            par[i] = i;
        }
        for(int i = 0; i < s1.length() && i < s2.length(); i++){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            union_find(c1 - 'a', c2 - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < baseStr.length(); i++){
            char c = baseStr.charAt(i);
            char p = getParent(c);
            sb.append(p);
        }
        return sb.toString();
    }
    public int find(int n){
        while(par[n] != n){
            par[n] = par[par[n]];
            n = par[n];
        }
        return n; 
    }
    public void union_find(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2)
            return ;
        if(p1 < p2)
            par[p2] = p1;
        else
            par[p1] = p2;
    }
    public char getParent(char c){
        int p = find(c - 'a');
        return (char)(p + 'a');
    }
}
