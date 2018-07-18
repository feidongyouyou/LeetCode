package DataStructure.LinkedList;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Administrator on 2018/6/20.
 */
public class LinkList {
    //给不带头结点的链表的i位置插入结点
    static LinkNode addLinkNode(LinkNode L, int i, int value){
//        if (L == null) return null;
        if (i <= 0) return null;
        if (i == 1){
            LinkNode addNode = new LinkNode(value, null);
            addNode.next = L;
            return addNode;
        }else {
            int j = 1;
            LinkNode p = L;
            while (p != null && j < i - 1){
                p = p.next;
                j++;
            }
            if (p == null) return null;
            else {
                LinkNode addNode = new LinkNode(value, null);
                addNode.next = p.next;
                p.next = addNode;
                return L;
            }
        }
    }

    //给带头结点的链表的i位置插入结点
    static boolean addLinkNodeWithHead(LinkNode L, int i, int value){
        LinkNode p = L;
        if (i <= 0) return false;
        int j = 0;
        while (p != null && j < i - 1){
            p = p.next;
            j++;
        }
        if (p == null) return false;
        else {
            LinkNode addNode = new LinkNode(value, null);
            addNode.next = p.next;
            p.next = addNode;
            return true;
        }
    }

    //增加结点到尾部(剑指Offer)
    static boolean addToTail(LinkNode L, int value){
        LinkNode p = L;
        if (L == null) return false;
        while (p.next != null){
            p = p.next;
        }
        LinkNode addNode = new LinkNode(value, null);
        p.next = addNode;
        return true;
    }

    //删除带头结点的链表的i位置的结点
    static boolean deleteLinkNodeWithHead(LinkNode L, int i){
        LinkNode p = L;
        if (i <= 0) return false;
        int j = 0;
        if (L == null) return false;
        while (p.next != null && j < i - 1){
            p = p.next;
            j++;
        }
        if (p.next == null) return false;
        else {
            LinkNode q = p.next;
            p.next = p.next.next;
            return true;
        }
    }

    //删除不带头结点的链表的i位置的结点
    static LinkNode deleteLinkNode(LinkNode L, int i){
        if (L == null) return null;
        if (i <= 0) return null;
        LinkNode p = L;
        if (i == 1){
            L = p.next;
            return p.next;
        }

        int j = 1;
        while (p.next != null && j < i - 1){
            p = p.next;
            j++;
        }
        if (p.next == null) return null;
        else{
            LinkNode q = p.next;
            p.next = q.next;
            return L;
        }
    }

    //删除第一个含有某值的结点
    static boolean removeNode(LinkNode L, int value){
        if (L == null) return false;
        LinkNode p = L;
        while (p.next != null && p.next.data != value){
            p = p.next;
        }
        if (p.next == null) return false;
        else {
            LinkNode q = p.next;
            p.next = q.next;
            return true;
        }
    }

    //单链表的整表创建,头插法
    static LinkNode createListHead(LinkNode L, int n){
        LinkNode p;
        L.next = null;
        for (int i = 0; i < n; i++) {
            p = new LinkNode(i, null);
            p.next = L.next;
            L.next = p;
        }
        return L;
    }

    //单链表的整表创建,头插法
    static LinkNode createListTail(LinkNode L, int n){
        L.next = null;
        LinkNode p, r;
        r = L;
        for (int i = 0; i < n; i++) {
            p = new LinkNode(i, null);
            r.next = p;
            r = p;
        }
        r.next = null;
        return L;
    }


    //从尾到头打印链表(剑指offer第5题)
    //用栈
    static ArrayList<Integer> printListReversingUsingIteration(LinkNode L){

        ArrayList<Integer> result = new ArrayList<>();
        if (L == null) return result;
        LinkNode p = L;
//        if (L == null) return result;
        LinkedList<LinkNode> listReverse = new LinkedList<>();
        while (p != null){
            listReverse.addLast(p);
            p = p.next;
        }
        while (!listReverse.isEmpty()){
            result.add(listReverse.removeLast().data);
        }
        return result;
    }

    //用递归
    static void printListReversingUsingRecursion(LinkNode L){
        if (L == null) return;
        LinkNode p = L;
        if (p.next != null){
            printListReversingUsingRecursion(p.next);
        }
        System.out.println(p.data);
    }


    public static void main(String[] args) {
        //带头结点的链表
//        LinkNode L = null;
        LinkNode L = new LinkNode(0, null);
//        LinkNode a1 = new LinkNode(1,null);
//        LinkNode a2 = new LinkNode(2,null);
//        LinkNode a3 = new LinkNode(3,null);
//        LinkNode a4 = new LinkNode(2,null);
//        L.next = a1;
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;

        //不带头结点的链表
//        LinkNode L;
//        LinkNode a1 = new LinkNode(1,null);
//        LinkNode a2 = new LinkNode(2,null);
//        LinkNode a3 = new LinkNode(3,null);
//        LinkNode a4 = new LinkNode(4,null);
//        L = a1;
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;

        show(L);
        show(createListTail(L, 10));
//        System.out.println(deleteLinkNodeWithHead(L, 6));
//        show(deleteLinkNode(L,1));
//        System.out.println(removeNode(L, 0));
//        printListReversingUsingRecursion(L);

    }

    //打印链表的函数
    public static void show(LinkNode L){
        LinkNode p = L;
        while (p != null){
            System.out.printf(p.data + "-->");
            p = p.next;
        }
        System.out.println("NULL");
    }

















//郑亚楠
//    static LinkNode insertLinkNode(LinkNode L, int i, int value) {
//        //null 表示插入失败；非null表示插入成功并返回新链表
//        if (L == null) return null;
//        if (i <= 0) return null;
//        if (i == 1) {
//            LinkNode addOne = new LinkNode(value, null);
//            addOne.next = L;
//            return addOne;
//        }
//        else {
//            LinkNode addOne = new LinkNode(value, null);
//            LinkNode p = L;
//
//            int j = 1;
//            while (p != null && j < i - 1) {
//                p = p.next;
//                ++j;
//            }
//
//            if (p == null){
//                return null;
//            }
//            else{
//                addOne.next = p.next;
//                p.next = addOne;
//            }
//            return L;
//        }
//    }

//    public static void main(String[] args){
//        LinkNode L;
//        LinkNode a1 = new LinkNode(1,null);
//        LinkNode a2 = new LinkNode(2,null);
//        LinkNode a3 = new LinkNode(3,null);
//        LinkNode a4 = new LinkNode(4,null);
//        a1.next = a2;
//        a2.next = a3;
//        a3.next = a4;
//        L = a1;
//
//
//        show(L);


//        show(insertLinkNode(L,1,100));
//        L = insertLinkNode(L,1,100);
//        show(L);
//        insertLinkNode(L,2,200);
//        show(L);
//
//    }

//    static void show(LinkNode list){
//        LinkNode p = list;
//        while (p != null){
//            System.out.printf(p.data + "-->");
//            p = p.next;
//        }
//        System.out.printf("NULL\n");
//    }
}

class LinkNode{
    public int data;
    public LinkNode next;

    public LinkNode(int data, LinkNode next) {
        this.data = data;
        this.next = next;
    }
}