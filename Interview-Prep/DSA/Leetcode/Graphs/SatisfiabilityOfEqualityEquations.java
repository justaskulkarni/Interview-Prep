package DSA.Leetcode.Graphs;

import java.util.Arrays;
import java.util.Comparator;

public class SatisfiabilityOfEqualityEquations {
    int[] par;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        par = new int[26];
        rank = new int[26];
        for(int i = 0; i < 26; i++){
            rank[i] = 1;
            par[i] = i;
        }
        Arrays.sort(equations, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                char c1 = a.charAt(1);
                char c2 = b.charAt(1);
                if(c1 == c2)
                    return 0;
                else if(c1 == '=')
                    return -1;
                else if(c2 == '=')
                    return 1;
                else
                    return 0;
            }
        });
        for(String eqn: equations){
            int n1 = eqn.charAt(0) - 'a';
            int n2 = eqn.charAt(3) - 'a';
            if(eqn.charAt(1) == '=')
                union_find(n1, n2);
        }
        for(String eqn: equations){
            int n1 = eqn.charAt(0) - 'a';
            int n2 = eqn.charAt(3) - 'a';
            if((eqn.charAt(1) == '!') && (find(n1) == find(n2)))
                return false;
        }
        return true;
    }
    public void union_find(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2){
            return ;
        }
        else{
            if(rank[p1] > rank[p2]){
                rank[p1] += rank[p2];
                par[p2] = p1; 
            }
            else{
                rank[p2] += rank[p1];
                par[p1] = p2;
            }
        }
    }
    public int find(int n){
        while(par[n] != n){
            par[n] = par[par[n]];
            n = par[n];
        }
        return n;
    }
}
