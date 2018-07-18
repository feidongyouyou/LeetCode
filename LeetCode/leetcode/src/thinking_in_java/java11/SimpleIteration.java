package thinking_in_java.java11;

import java.util.*;


/**
 * Created by Administrator on 2018/5/14.
 */
public class SimpleIteration {
//    public static void display(Iterator<Integer> it){
//        while (it.hasNext()){
//            Integer i = it.next();
//            System.out.print(i);
//
//        }
//        System.out.println();
//    }


    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ListIterator<Integer> it = ints.listIterator();
        while (it.hasNext()){
            System.out.println(it.next() + "," + it.nextIndex() + "," + it.previousIndex() + ";");
        }
        System.out.println();

        while (it.hasPrevious()){
            System.out.println(it.previous() + " ");
        }

        it = ints.listIterator(0);
        while (it.hasNext()){
            it.next();
            it.set(1);
        }
        System.out.println(ints);
    }
}
