package JianZhiOffer.Tree;

/**
 * Created by Administrator on 2018/7/8.
 */
public class testValueTransfer {
    static void f(TreeNode b){
        //改变引用的指向时，函数外引用原本指向的对象不会改变
        b = new TreeNode(100);
        //值改变对象本身属性时，在函数外此对象发生改变
//        b.val = 10;
//        b.left = null;
//        b.right = null;
    }

    public static void main(String[] args) {
//        TreeNode a1 = new TreeNode(3);
//        TreeNode a2 = new TreeNode(5);
//        TreeNode a3 = new TreeNode(7);
//
//        a1.left = a2;
//        a1.right = a3;
//        f(a1);
//        System.out.println(a1.val);
//        System.out.println(a1.left.val);
//        System.out.println(a1.right.val);


        int[] data1 = {1,2,3,4,5};
        System.out.println();

    }
}
