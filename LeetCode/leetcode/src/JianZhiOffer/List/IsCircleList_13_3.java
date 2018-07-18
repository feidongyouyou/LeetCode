package JianZhiOffer.List;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/7/2.
 */
//判断一个单项链表是否形成了环形结构
public class IsCircleList_13_3 {
    //前面的指针走2步，后面的指针走1步
    // 若快指针追上了慢指针，则是环形链表
    //若快指针走到了链表末尾都没追上慢指针，则不是环形链表
    public static boolean isCircleList_01(ListNode head){
        if (head == null) return false;
        ListNode pre = head;
        ListNode behind = head;
        while (pre.next != null && pre.next.next != null){
            pre = pre.next.next;
            behind = behind.next;
            if (pre == behind) return false;
        }
        return true;

    }

    //当前节点在集合中出现过，表明有环
    public static boolean isCircleList_02(ListNode head){
        //true代表无环，false代表有环
        if (head == null) return false;
        LinkedList<ListNode> saveNode = new LinkedList<>();
        ListNode p = head;
        while (p != null){
            if (!saveNode.contains(p)){
                saveNode.add(p);
                p = p.next;
            }else return false;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1,null);
//        ListNode a2 = new ListNode(2,null);
//        ListNode a3 = new ListNode(3,null);
//        ListNode a4 = new ListNode(2,null);
//        ListNode a5 = new ListNode(5,null);
//        ListNode a6 = new ListNode(6,null);
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        a4.next = a5;
//        a5.next = a6;
//        a6.next = a3;

//        ListNode a1 = null;
        System.out.println(isCircleList_01(a1));
    }
}
