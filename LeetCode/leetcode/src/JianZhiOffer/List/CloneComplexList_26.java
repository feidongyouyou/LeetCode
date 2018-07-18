package JianZhiOffer.List;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/7/3.
 */
//面试题26：复杂链表的复制
public class CloneComplexList_26 {
    //用map存储，旧节点和克隆节点一对一，再把next和random对应起来
    public static RandomListNode cloneComplexList02(RandomListNode pHead){
        if (pHead == null) return null;
        RandomListNode p = pHead;
        HashMap<RandomListNode, RandomListNode> cloneMap = new HashMap<>();
        while (p != null){
            RandomListNode cloneNode = new RandomListNode(p.label);
            cloneMap.put(p, cloneNode);
            p = p.next;
        }
        p = pHead;
        RandomListNode cloneHead = cloneMap.get(p);
        while (p != null){
            RandomListNode cNode = cloneMap.get(p);
//            System.out.println(p.next);
            cNode.next = cloneMap.get(p.next);   //注意这里map中null对应的值是null
//            System.out.println(cNode.next);
            if (p.random == null){
                cNode.random = null;
            }
            cNode.random = cloneMap.get(p.random);
            p = p.next;
        }
        return cloneHead;
    }



    //时间复杂度过大，暂未解决
    public static RandomListNode cloneComplexList(RandomListNode pHead){
        if (pHead == null) return null;
        RandomListNode firstOperation = cloneNodes(pHead);
        RandomListNode secondOperation = connectSiblingNodes(firstOperation);
        return separateNodes(secondOperation);
    }

    //复制所有节点，紧跟在原节点的后面
    public static RandomListNode cloneNodes(RandomListNode pHead){
        RandomListNode p = pHead;
        while (p != null){
            RandomListNode cloned = new RandomListNode(p.label);
            cloned.random = null;
            cloned.next = p.next;
            p.next = cloned;
            p = p.next;
        }
        return pHead;
    }
    //复制原节点的random属性
    public static RandomListNode connectSiblingNodes(RandomListNode pHead){
        RandomListNode p = pHead;
        while (p != null){
            RandomListNode pCloned = p.next;
            pCloned.random = p.random.next;
            p = pCloned.next;
        }
        return pHead;
    }

    //把长链表拆成2个短链表
    public static RandomListNode separateNodes(RandomListNode pHead){
        RandomListNode pNode = pHead;
        RandomListNode pClonedHead = null;
        RandomListNode pCloned = null;

        if (pNode != null){
            pClonedHead = pCloned = pNode.next;
            pNode.next = pCloned.next;
            pNode = pNode.next;
        }

        while (pNode != null){

            pCloned.next = pNode.next;
            pCloned = pCloned.next;
            pNode.next = pCloned.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }


    public static void main(String[] args) {
        RandomListNode a1 = new RandomListNode(1);
        RandomListNode a2 = new RandomListNode(2);
        RandomListNode a3 = new RandomListNode(3);
        RandomListNode a4 = new RandomListNode(4);
        RandomListNode a5 = new RandomListNode(5);
        RandomListNode a6 = new RandomListNode(6);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a1.random = a6;
        a2.random = a4;
        a3.random = a5;
        a4.random = a1;
        a5.random = a2;
        a6.random = a3;
        RandomListNode L = a1;
        show(L);
        show(cloneComplexList02(L));
    }

    public static void show(RandomListNode head){
        RandomListNode p = head;
        while (p != null){
            System.out.printf(p.label + "," + p.random.label + "-->");
            p = p.next;
        }
        System.out.println("NULL");
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}