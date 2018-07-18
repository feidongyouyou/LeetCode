package JianZhiOffer.List;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/7/6.
 */
public class DeleteDuplication_57 {
    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead == null) return null;
        ListNode p = pHead;
        LinkedList<ListNode> saveNode = new LinkedList<>();

        return pHead;

    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1,null);
        ListNode a2 = new ListNode(3,null);
        ListNode a3 = new ListNode(3,null);
//        ListNode a4 = new ListNode(2,null);
//        ListNode a5 = new ListNode(5,null);
//        ListNode a6 = new ListNode(5,null);
        a1.next = a2;
        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;
//        a5.next = a6;
//        ListNode a1 = null;
        show(a1);
        show(deleteDuplication(a1));
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
