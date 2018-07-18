package Contest_92;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/7/8.
 */
public class SmallestSubtreewithalltheDeepestNodes_866 {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return root;
    }

    public static void traverseTree(TreeNode root){
        if (root == null) return;
        LinkedList<TreeNode> binaryTree = new LinkedList<>();
        binaryTree.addLast(root);
        int maxPathLength = Integer.MIN_VALUE;
        while (!binaryTree.isEmpty()){
            TreeNode out = binaryTree.removeFirst();
            TreeNode leftChild = out.left;
            TreeNode rightChild = out.right;
            if (leftChild != null){
                binaryTree.addLast(leftChild);
            }
            if (rightChild != null){
                binaryTree.addLast(rightChild);
            }

        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}