package thinking_in_java.java11;

import java.util.*;

/**
 * Created by Administrator on 2018/5/14.
 */
public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[] moreInts = {6,7,8,9,10};
        collection.addAll(Arrays.asList(moreInts));
        Collections.addAll(collection, 11, 12, 13, 14, 15);
        Collections.addAll(collection, moreInts);
        List<Integer> list = Arrays.asList(16, 17);
        list.set(0, 2);
//        list.add(18);
        System.out.println(list);

    }
}
