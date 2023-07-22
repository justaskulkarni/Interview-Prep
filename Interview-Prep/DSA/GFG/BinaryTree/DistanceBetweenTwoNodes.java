package BinaryTree;

public class DistanceBetweenTwoNodes {
    int d1 = -1;
    int d2 = -1;
    int dist = 0;
    int findDist(Node root, int a, int b) {
        Node lca = lca(root, a, b, 1);
        if(d1 != -1 && d2 != -1)
            return dist;
        if(d1 != -1){
            dist = findLevel(lca, b, 0);
            return dist;
        }
        if(d2 != -1){
            dist = findLevel(lca, a, 0);
            return dist;
        }
        return -1;
    }
    int findLevel(Node node, int k, int level){
        if(node == null)
            return -1;
        if(node.data == k)
            return level;
        int l = findLevel(node.left, k, level + 1);
        return (l != -1) ? l: findLevel(node.right, k, level + 1);
    }
    Node lca(Node root, int n1, int n2, int level){
        if(root == null)
            return null;
        if(root.data == n1){
            d1 = level;
            return root;
        }
        if(root.data == n2){
            d2 = level;
            return root;
        }
        Node left_lca = lca(root.left, n1, n2, level + 1);
        Node right_lca = lca(root.right, n1, n2, level + 1);
        if(left_lca != null && right_lca != null){
            dist = (d1 + d2) - (2 * level);
            return root;
        }
        return (left_lca != null) ? left_lca: right_lca;
    }
}
