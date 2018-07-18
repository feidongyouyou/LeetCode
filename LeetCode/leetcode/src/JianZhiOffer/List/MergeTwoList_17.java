package JianZhiOffer.List;

/**
 * Created by Administrator on 2018/7/2.
 */
//面试题17：合并两个排序的链表
public class MergeTwoList_17 {
    public static ListNode mergeTwoList(ListNode list1, ListNode list2){
//        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = null;
        ListNode p = list1;
        ListNode q = list2;

        if (p.val <= q.val) {
            head = p;
            p = p.next;
        }
        else {
            head = q;
            q = q.next;
        }
        ListNode point = head;

        while (p != null && q != null){
            if (p.val <= q.val){
                point.next = p;
                p = p.next;

            }else {
                point.next = q;
                q = q.next;

            }
            point = point.next;
        }

        if (p == null){
            point.next = q;
        }else {
            point.next = p;
        }

        return head;
    }


    public static void main(String[] args) {
        ListNode a1 = new ListNode(1,null);
//        ListNode a2 = new ListNode(2,null);
//        ListNode a3 = new ListNode(3,null);
//        ListNode a4 = new ListNode(4,null);
        ListNode a5 = new ListNode(2,null);
//        ListNode a6 = new ListNode(6,null);
//        ListNode a7 = new ListNode(7,null);
//        ListNode a8 = new ListNode(8,null);

//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//
//        a5.next = a6;
//        a6.next = a7;
//        a7.next = a8;

//        ListNode list1 = a1;
//        ListNode list2 = a5;

        ListNode list1 = a1;
        ListNode list2 = a5;
        show(list1);
        show(list2);
        show(mergeTwoList(list1, list2));

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
