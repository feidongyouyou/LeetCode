package DataStructure.Tree;

import java.util.Scanner;

/**
 * Created by Administrator on 2018/7/8.
 */
public class BinaryTreeOperations {
    //二叉树的前序遍历，根左右
    static void preOrderTraverse(TreeNode T){
        if (T == null) return;
        System.out.print(T.val + " ");
        preOrderTraverse(T.left);
        preOrderTraverse(T.right);
    }

    //二叉树的中序遍历，左根右
    static void inOrderTraverse(TreeNode T){
        if (T == null) return;
        inOrderTraverse(T.left);
        System.out.print(T.val + " ");
        inOrderTraverse(T.right);
    }

    //二叉树的后序遍历，左右根
    static void postOrderTraverse(TreeNode T){
        if (T == null) return;
        postOrderTraverse(T.left);
        postOrderTraverse(T.right);
        System.out.print(T.val + " ");
    }

    //建立一颗二叉树（前序，递归）
    static void createBinaryTree(TreeNode T){
        Scanner cin = new Scanner(System.in);
        String line = cin.nextLine().trim();

        int value;
        if (line.charAt(0) == '#') {
            T = null;
        }
//        else {
//            value = Integer.parseInt(line);
//            T = new TreeNode(value);
//        }
        value = Integer.parseInt(line);
        T = new TreeNode(value);
        createBinaryTree(T.left);
        createBinaryTree(T.right);
    }




    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);

        TreeNode T = node1;


        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
//        node4.right = null;
//        node5.left = null;
//        node5.right = null;
        node6.left = node9;
//        node6.right = null;
//        node7.left = null;
        node7.right = node10;
//        node8.left = null;
        node8.right = node11;
//        preOrderTraverse(T);
//        System.out.println("");
//        inOrderTraverse(T);
//        System.out.println("");
//        postOrderTraverse(T);

        createBinaryTree(T);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}