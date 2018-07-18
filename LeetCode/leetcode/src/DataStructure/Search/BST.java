package DataStructure.Search;

/**
 * Created by Administrator on 2018/7/11.
 */
public class BST {
    static TreeNode p;
    static TreeNode root = null;
    //二叉排序树的查找，找到时让p指向该结点
    public static boolean searchBST(TreeNode root, TreeNode parent, int key){
        if (root == null) {
            p = parent;
            return false;
        }
        if (key == root.val){
            p = root;
            return true;
        }else if (key < root.val){
            return searchBST(root.left, root, key);
        }else return searchBST(root.right, root, key);
    }

    //二叉排序树：插入结点
    //当二叉排序树中不存在关键字等于key的值时，插入key并返回true，否则返回false
    public static boolean insertBST(TreeNode root, int key){
//        if (root == null){    //值传递问题，root的指针被改了，咋办？？？
//            root = new TreeNode(key);
//            return true;
//        }
        if (!searchBST(root, null, key)){
            TreeNode keyNode = new TreeNode(key);
            keyNode.left = keyNode.right = null;
            if (key < p.val){
                p.left = keyNode;
            }else {
                p.right = keyNode;
            }
            return true;
        }else {
            return false;
        }
    }

    //二叉排序树：递归删除结点
    public static boolean deleteBST(TreeNode root, int key, TreeNode parent){
        if (root == null) return false;
        if (root.val == key) {
            return delete(new HelperTreeNode(root, parent));
        }else if (key < root.val){
            return deleteBST(root.left, key, root);
        }else {
            return deleteBST(root.right, key, root);
        }
    }
    //删掉某个结点
    public static boolean delete(HelperTreeNode helper){
//        if (p == null) return false;
        //q始终是s的父亲
        TreeNode q, s;
        TreeNode t = helper.t;
        TreeNode parent = helper.parent;
        if (t.right == null){  //待删除结点的右子树为空，接上p的左子树
            if (parent == null){
                root = t.left;
                return true;
            }else {
                helper.setChild(t.left);
            }
        }else if (t.left == null){   //待删除结点的左子树为空，接上p的右子树
            if (parent == null){
                root = t.right;
                return true;
            }else {
                helper.setChild(t.right);
            }
        }else {
            s = t.left;    //s初始化为p的左孩子
            q = t;
            //s为p的中序遍历序列的前驱节点，即p的左孩子的最后一个右孩子
            while (s.right != null){
                q = s;
                s = s.right;
            }
            //前驱结点s的值赋给待删除结点p，
            // 再删除前驱节点s，
            // 并将s的左子树重接到s的父亲结点q上
            t.val = s.val;
            if (q != t){  //p的左子树有右孩子
                q.right = s.left;
            }else {   //p的左子树没有右孩子
                q.left = s.left;
            }

        }
        return true;
    }

    //输出二叉排序树的中序遍历序列
    public static void traverseBSTOfIn(TreeNode root){
        if (root == null) return;

        traverseBSTOfIn(root.left);
        System.out.print(root.val + " ");
        traverseBSTOfIn(root.right);
    }


    public static void main(String[] args) {
        //构建一棵二叉排序树

        int[] a = new int[]{62,88,58,47,35,73,51,99,37,93};
        for (int i = 0; i < a.length; i++) {
            if(root == null){
                root = new TreeNode(a[i]);
            }
            insertBST(root, a[i]);
        }
//        System.out.println(root.val); //报空指针异常，root还是null
        traverseBSTOfIn(root);

        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.println("删" + a[i] + ":");
            System.out.println("是否删除成功：" + deleteBST(root, a[i], null));
            traverseBSTOfIn(root);
            System.out.println();
            System.out.println("根节点：" + root.val);
            System.out.println();

        }
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class HelperTreeNode{
    TreeNode t;
    TreeNode parent;

    public HelperTreeNode(TreeNode t, TreeNode parent) {
        this.t = t;
        this.parent = parent;
    }

    public void setChild(TreeNode child){
        if (t == parent.left) parent.left = child;
        else parent.right = child;
    }
}