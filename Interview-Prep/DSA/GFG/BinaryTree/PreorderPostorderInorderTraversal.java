package BinaryTree;

import java.util.ArrayList;
import java.util.List;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class PreorderPostorderInorderTraversal {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> preorder = new ArrayList<>();
        preorder(root, preorder);
        ArrayList<Integer> postorder = new ArrayList<>();
        postorder(root, postorder);
        ArrayList<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        list.add(inorder);
        list.add(preorder);
        list.add(postorder);
        return list;
    }

    public static void preorder(BinaryTreeNode<Integer> root, ArrayList<Integer> preorderlist) {
        if (root == null)
            return;
        preorderlist.add(root.data);
        preorder(root.left, preorderlist);
        preorder(root.right, preorderlist);
    }

    public static void postorder(BinaryTreeNode<Integer> root, ArrayList<Integer> postorderlist) {
        if (root == null)
            return;
        postorder(root.left, postorderlist);
        postorder(root.right, postorderlist);
        postorderlist.add(root.data);
    }

    public static void inorder(BinaryTreeNode<Integer> root, ArrayList<Integer> inorderlist) {
        if (root == null)
            return;
        inorder(root.left, inorderlist);
        inorderlist.add(root.data);
        inorder(root.right, inorderlist);
    }
}
