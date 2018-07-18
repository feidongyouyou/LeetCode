package JianZhiOffer.List;

/**
 * Created by Administrator on 2018/6/28.
 */
//面试题13：在O(1)时间删除链表节点
//给定单项链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点
public class DeleteNodeInList_13 {
    public static ListNode deleteNodeInList(ListNode head, ListNode toBeDeleted){
        if (head == null || toBeDeleted == null) return null;
        //删除的不是尾节点，把后一个节点的值赋给要删除的节点，删除后一节点
        if (toBeDeleted.next != null) {
            ListNode p = toBeDeleted.next;
            toBeDeleted.val = p.val;
            toBeDeleted.next = p.next;
            return head;
        //要删除的节点的下一节点是null(删除节点是尾节点)，删除节点又是头结点，即链表只有一个节点
        }else if (head == toBeDeleted){
            toBeDeleted = null;
            head = null;
            return null;
        //链表中有多个节点，删除尾节点
        }else {
            ListNode p = head;
            while (p.next != toBeDeleted){
                p = p.next;
            }
            p.next = null;
            return head;
        }
    }

    public static void main(String[] args) {
//        ListNode L = null;
        ListNode L = new ListNode(0, null);
        ListNode a1 = new ListNode(1,null);
        ListNode a2 = new ListNode(2,null);
        ListNode a3 = new ListNode(3,null);
        ListNode a4 = new ListNode(4,null);
        ListNode a5 = null;
        L.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        show(L);
        show(deleteNodeInList(L, a4));
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

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
