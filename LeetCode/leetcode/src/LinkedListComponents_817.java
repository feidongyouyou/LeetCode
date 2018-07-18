import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/4/16.
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }

public class LinkedListComponents_817 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int i: G) {
            set.add(i);
        }
        ListNode cur = head;
        int count = 0;
        while (cur != null){
            if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val))){
                count++;
            }
            cur = cur.next;
        }
        return count;
    }
}
