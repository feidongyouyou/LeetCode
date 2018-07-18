package JianZhiOffer.List;

/**
 * Created by Administrator on 2018/7/2.
 */
//面试题16：反转单链表
public class ReverseList_16 {
    public static ListNode reverseList(ListNode head){
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode pre = null;
        ListNode p = head;
        ListNode behind = head.next;

        while (p.next != null){
            //指针往前指
            p.next = pre;
            //指针后移
            pre = p;
            p = behind;
            behind = behind.next;

        }
        p.next = pre;
        return p;

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
        show(reverseList(L));
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
