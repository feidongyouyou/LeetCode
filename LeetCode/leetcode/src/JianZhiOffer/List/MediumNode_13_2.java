package JianZhiOffer.List;

/**
 * Created by Administrator on 2018/7/2.
 */
//求链表的中间结点
public class MediumNode_13_2 {
    public static ListNode mediumNode(ListNode head){
        if (head == null) return null;
        ListNode pre = head;
        ListNode behind = head;
        while (pre.next != null && pre.next.next != null){
            pre = pre.next.next;
            behind = behind.next;
        }
        return behind;
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
        System.out.println(mediumNode(L).val);
    }
}
