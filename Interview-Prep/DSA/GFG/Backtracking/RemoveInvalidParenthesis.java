package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis {
    public List<String> removeInvalidParentheses(String s) {
        List<String> output = new ArrayList<>();
        helper(s, output, 0, 0, '(', ')');
        return output;
    }

    public void helper(String s, List<String> output, int iStart, int jStart, char openPar, char closePar) {
        int numOpenPar = 0, numClosePar = 0;
        for (int i = iStart; i < s.length(); i++) {

            if (s.charAt(i) == openPar)
                numOpenPar++;
            else if (s.charAt(i) == closePar)
                numClosePar++;
            if (numClosePar > numOpenPar) {
                for (int j = jStart; j <= i; j++)
                    if (s.charAt(j) == closePar && (j == jStart || s.charAt(j - 1) != closePar))
                        helper(s.substring(0, j) + s.substring(j + 1, s.length()), output, i, j, openPar, closePar);
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (openPar == '(')
            helper(reversed, output, 0, 0, ')', '(');
        else
            output.add(reversed);
    }
}
