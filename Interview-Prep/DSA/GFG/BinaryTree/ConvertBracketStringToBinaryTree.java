package BinaryTree;

public class ConvertBracketStringToBinaryTree {
    static int start = 0;
    static Node constructTree(String s) 
{
    
    // Check for null or empty string
    // and return null;
    if (s.length() == 0 || s == null)
    {
        return null;
    }
    
    if (start >= s.length())
        return null;
    
    // Boolean variable to check
    // for negative numbers
    boolean neg = false;
    
    // Condition to check for negative number
    if (s.charAt(start) == '-') 
    {
        neg = true;
        start++;
    }
    
    // This loop basically construct the
    // number from the continuous digits 
    int num = 0;
    while (start < s.length() && 
           Character.isDigit(s.charAt(start)))
    {
        int digit = Character.getNumericValue(
            s.charAt(start));
        num = num * 10 + digit;
        start++;
    }
    
    // If string contains - minus sign 
    // then append - to the number;
    if (neg) 
        num = -num;
    
    // Create the node object i.e. root of 
    // the tree with data = num;
    Node node = new Node(num);
    
    if (start >= s.length()) 
    {
        return node;
    }
    
    // Check for open bracket and add the
    // data to the left subtree recursively
    if (start < s.length() && s.charAt(start) == '(' )
    {
        start++;
        node.left = constructTree(s);
    }
    
    if (start < s.length() && s.charAt(start) == ')')
    {
        start++;
        return node;
    }
    
    // Check for open bracket and add the data 
    // to the right subtree recursively
    if (start < s.length() && s.charAt(start) == '(') 
    {
        start++;
        node.right = constructTree(s);
    }
    
    if (start < s.length() && s.charAt(start) == ')') 
    {
        start++;
        return node;
    }
    return node;
}
}
