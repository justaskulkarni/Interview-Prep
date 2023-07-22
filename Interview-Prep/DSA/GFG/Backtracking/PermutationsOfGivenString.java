package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsOfGivenString {
    public List<String> find_permutation(String S) {
        Set<String> set = new HashSet<>();
        helper(S, 0, S.length() - 1, set);
        return new ArrayList<String>(set);
    }
    public void helper(String s, int l, int r, Set<String> res){
        if(l == r)
            res.add(s);
        for(int i = l; i <= r; i++){
            swap(s.charAt(l), s.charAt(i));
            helper(s, l + 1, r, res);
            swap(s.charAt(l), s.charAt(i));
        }
    }
    public void swap(Character c1, Character c2){
        // Write code
    }
}
