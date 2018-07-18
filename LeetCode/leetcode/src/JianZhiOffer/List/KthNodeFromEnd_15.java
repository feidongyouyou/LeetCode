package JianZhiOffer.List;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/6/28.
 */
//面试题15：倒数第K个节点
public class KthNodeFromEnd_15 {
    //用一前一后2个指针，相差k - 1
    public static ListNode kthNodeFromEndUsingPointer(ListNode head, int k){
        if (head == null) return null;
        if (k <= 0) return null;
        ListNode pre = head;
        ListNode behind = null;
        for (int i = 0; i < k - 1; i++) {
            if (pre.next != null) {
                pre = pre.next;
            }else {
                return null;
            }
        }
        behind = head;
        while (pre.next != null){
            pre = pre.next;
            behind = behind.next;
        }
        return behind;
    }
    //倒数第k个就是正数第（n - k + 1）个，需遍历2遍
    public static ListNode kthNodeFromEnd(ListNode L, int k){
        if (L == null) return null;
        ListNode p = L;
        int count = 0;
        while (p != null){
            p = p.next;
            count++;
        }
//        System.out.println(count + "*******");
        p = L;
        if (k <= 0 || k > count) return null;
        int positive = count - k + 1;
        while (positive != 1 && p != null){
            p = p.next;
            positive--;
        }
        return p;
    }

    //用栈输出第k个，相当于遍历2遍
    public static ListNode kthNodeFromEndUsingStack(ListNode head, int k){
        if (head == null) return null;
        ListNode p = head;
        LinkedList<ListNode> saveNode = new LinkedList<>();

        while (p != null){
            saveNode.addLast(p);
            p = p.next;
        }
        int len = saveNode.size();
        if (k <= 0 || k > len) return null;

        for (int i = 0; i < k - 1; i++) {
            saveNode.removeLast();
        }
        ListNode result = saveNode.removeLast();
        return result;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1,null);
        ListNode a2 = new ListNode(2,null);
        ListNode a3 = new ListNode(3,null);
        ListNode a4 = new ListNode(4,null);
        ListNode a5 = new ListNode(5,null);
        ListNode a6 = new ListNode(6,null);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        ListNode L = a1;
//        ListNode L = null;
        show(L);
        ListNode kth = kthNodeFromEndUsingStack(L, 1);
        if (kth!= null) {
            System.out.println(kth.val);
        }else {
            System.out.println("nnnnnnnnnnnnn");
        }
    }

    public static void show(ListNode head){
        ListNode p = head;
        while (p != null){
            System.out.printf(p.val + "-->");
            p = p.next;
        }
        System.out.println("NULL");
    }
}

//class ListNode{
//    public int val;
//    public ListNode next;
//
//    public ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
