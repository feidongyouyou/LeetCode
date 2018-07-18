package JianZhiOffer.List;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/7/6.
 */
public class EntryNodeOfLoop_56 {
    //用容器存节点，第一个在容器中出现过的节点就是环的入口
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if (pHead == null) return null;

        ListNode p = pHead;
        LinkedList<ListNode> stackOfNodes = new LinkedList<>();
        while (p != null){
            if (stackOfNodes.contains(p)){
                return p;
            }
            stackOfNodes.add(p);
            p = p.next;
        }
        //循环完之后都没找到，则不是环，返回null
        return null;
    }

    public static ListNode EntryNodeOfLoop02(ListNode pHead){
        ListNode meeting = meetingNode(pHead);
        if (meeting == null) return null;
        ListNode m = meeting.next;
        int lenOfLoop = 1;
        while (m != meeting){
            lenOfLoop++;
            m = m.next;
        }
//        System.out.println(lenOfLoop);

        ListNode fast = pHead;
        ListNode slow = pHead;
        while (lenOfLoop != 0){
            fast = fast.next;
            lenOfLoop--;
        }
        while (fast != null && slow != null){
            if (fast == slow) return fast;
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }


    public static ListNode meetingNode(ListNode pHead){
        if (pHead == null) return null;
        ListNode pre = pHead;
        ListNode behind = pHead;
        while (pre.next != null && pre.next.next != null){
            pre = pre.next.next;
            behind = behind.next;
            if (pre == behind) return pre;
        }
        return null;
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
//        a6.next = a6;
        ListNode L = a1;
        System.out.println(meetingNode(L));
        System.out.println(EntryNodeOfLoop02(L));

    }
}
