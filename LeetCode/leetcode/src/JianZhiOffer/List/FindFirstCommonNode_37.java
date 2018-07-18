package JianZhiOffer.List;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/7/6.
 */
//面试题37：两个链表的第一个公共节点
public class FindFirstCommonNode_37 {
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        LinkedList<ListNode> stackOfList01 = new LinkedList<>();
        LinkedList<ListNode> stackOfList02 = new LinkedList<>();

        while (p1 != null){
            stackOfList01.addLast(p1);
            p1 = p1.next;
        }
        while (p2 != null){
            stackOfList02.addLast(p2);
            p2 = p2.next;
        }

//        System.out.println(stackOfList01);
//        System.out.println(stackOfList02);
        ListNode commonNode = null;

//        System.out.println(stackOfList01.isEmpty());
//        System.out.println(stackOfList02.isEmpty());

        while (!stackOfList01.isEmpty() && !stackOfList02.isEmpty()){
            ListNode first01 = stackOfList01.removeLast();
            ListNode first02 = stackOfList02.removeLast();
//            System.out.println(first01.val);
//            System.out.println(first02.val);

            if (first01 == first02){
                commonNode = first01;
            }else{
                return commonNode;
            }
        }
        return commonNode;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1,null);
        ListNode a2 = new ListNode(2,null);
        ListNode a3 = new ListNode(3,null);
        ListNode a4 = new ListNode(4,null);
        ListNode a5 = new ListNode(5,null);
        ListNode a6 = new ListNode(6,null);
        ListNode a7 = new ListNode(7,null);
        ListNode a8 = new ListNode(8,null);

        a1.next = a2;
        a2.next = a7;
        a7.next = a8;
        a3.next = a4;
        a4.next = a5;
        a5.next = a8;
        ListNode pHead1 = a1;
        ListNode pHead2 = a1;

        show(pHead1);
        show(pHead2);
        System.out.println(FindFirstCommonNode(pHead1, pHead2).val);
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
