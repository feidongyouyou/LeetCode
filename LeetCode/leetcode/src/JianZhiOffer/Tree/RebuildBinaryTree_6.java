package JianZhiOffer.Tree;

/**
 * Created by Administrator on 2018/7/8.
 */
public class RebuildBinaryTree_6 {
    //递归，理清边界条件
    //运行时间：283ms, 运行内存：22880k
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        return reBuildBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode rebuild(int[] pre, int preStart, int preEnd,
                             int[] in, int inStart, int inEnd){
        //数组为空
        if (pre.length == 0 || in.length == 0) return null;
        if (preStart > preEnd) return null;
//        if (preStart == preEnd) return new TreeNode(pre[0]);
        TreeNode root = new TreeNode(pre[preStart]);
        //只有一个结点
        if (preEnd == preStart) return root;

        //前序中根节点在中序中的位置
        int rootIndex = -1;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[preStart]){
                rootIndex = i;
                break;
            }
        }
        //输入的前序遍历序列和中序遍历序列不匹配的情况未能处理，应抛异常。
        if (rootIndex == -1) System.out.println("Error!!!");
        //构造左子树和右子树
        root.left = rebuild(pre, preStart + 1, preStart + rootIndex - inStart,
                            in, inStart, rootIndex - 1);
        root.right = rebuild(pre, preStart + rootIndex - inStart + 1, preEnd,
                             in, rootIndex + 1, inEnd);
        return root;

    }
    //郑亚楠：
    private TreeNode reBuildBinaryTree(int[] pre,int pre_Start, int pre_End,
                                       int[] in,int in_Start,int in_End){
        if (pre_Start > pre_End)   return null;

        TreeNode root = new TreeNode(pre[pre_Start]);
        if (pre_End == pre_Start)    return root;

        int root_index = 0;
        for (int i = in_Start; i <= in_End; i++) {
            if (in[i] == pre[pre_Start]){
                root_index = i;
                break;
            }
        }
        root.left = reBuildBinaryTree(
                pre,pre_Start+1,pre_Start+root_index-in_Start,
                in,in_Start,root_index-1);
        root.right = reBuildBinaryTree(
                pre,pre_Start+root_index-in_Start+1,pre_End,
                in,root_index+1,in_End);
        return root;
    }

    public static void main(String[] args) {
        //测试用例：普通二叉树（完全二叉树和不完全二叉树），
        // 特殊二叉树（左斜树，右斜树，只有一个结点的二叉树）
        //特殊输入测试（根节点指针为null，输入的前序遍历序列和中序遍历序列不匹配）********
        TreeNode root = new RebuildBinaryTree_6().reConstructBinaryTree(
                new int[]{1,2,4,7,3,5,6,8},
                new int[]{4,7,2,1,5,3,8,6}
        );
        showBinaryTree(root);
    }

    public static void showBinaryTree(TreeNode root){
        //中序遍历
        if (root != null) {
            showBinaryTree(root.left);
            System.out.println(root.val);
            showBinaryTree(root.right);
        }
    }
}
