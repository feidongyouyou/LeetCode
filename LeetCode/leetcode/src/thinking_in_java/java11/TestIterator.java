package thinking_in_java.java11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Administrator on 2018/5/14.
 */
public class TestIterator {
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()){
            int cur = it.next();
            System.out.println(cur);
        }
        System.out.println("****************");
        while (it.hasPrevious()){
            int cur = it.previous();
            System.out.println(cur);
        }
    }
}
