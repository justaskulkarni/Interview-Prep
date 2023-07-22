package BST;

public class KthLargestElementInBST {
    int ans;
    int count;
    public int kthLargest(Node root,int K)
    {
        ans = 0;
        count = 0;
        helper(root, K);
        return ans;
    }
    public void helper(Node node, int K){
        if(node == null || count >= K)
            return ;
        helper(node.right, K);
        count++;
        if(count == K){
            ans = node.data;
            return ;
        }
        helper(node.left, K);
    }
}
