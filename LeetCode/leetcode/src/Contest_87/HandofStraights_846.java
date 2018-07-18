package Contest_87;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Administrator on 2018/6/3.
 */
public class HandofStraights_846 {
    public static boolean isNStraightHand2(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) return false;

        Arrays.sort(hand);
        ArrayList<Integer> handlist = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            handlist.add(hand[i]);
        }
        System.out.println(handlist);
        int count = 0,key = -1;
        for (int i = 0; i < handlist.size(); i++) {
            if (count == 0){
                key = handlist.remove(i);
                count++;
                i--;
            }
            else if (handlist.get(i) == key + 1){
                key = handlist.remove(i);
                count++;
                i--;
            }

            if (count == W){
                count = 0;
                i = -1;
            }
        }

        System.out.println(count + ":" + handlist.size());
        return count == 0 && handlist.isEmpty();
//        if (count == 0 && handlist.isEmpty())   return true;
//        return false;
    }
    public static boolean isNStraightHand(int[] hand, int W) {
        int len = hand.length;
        if (len % W != 0) return false;
        Arrays.sort(hand);

        ArrayList<Integer> handlist = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            handlist.add(hand[i]);
        }

        for (int i = 0; i < len / W; i++) {
            partition(handlist, W);
        }
        if (handlist.size() != 0) return false;
        return true;

//        return partition2(handlist, W);

    }

    public static void partition(ArrayList<Integer> h, int w){
        int[] p = new int[w];
        p[0] = h.get(0);
        h.remove(0);

        int firstIndex = 0;
        for (int i = 1; i < w; i++) {
            for (int j = firstIndex; j < h.size(); j++) {
                if (h.get(j) == p[i - 1] + 1){
                    p[i] = h.remove(j);
                    firstIndex = j;
                    break;
                }
            }
        }
    }


//    public static boolean partition2(ArrayList<Integer> h, int w){
//        if (h.size() == 0) {
//            return true;
//        }
//
//        int[] p = new int[w];
//        p[0] = h.get(0);
//        h.remove(0);
//
//        int firstIndex = 0;
//        for (int i = 1; i < w; i++) {
//            int l = h.size();
//
//            for (int j = firstIndex; j < h.size(); j++) {
//                if (h.get(j) == p[i - 1] + 1){
//                    p[i] = h.remove(j);
//                    firstIndex = j;
//                    break;
//                }
//            }
//
//            if (l == h.size()){
//                return false;
//            }
//        }
//        return partition2(h, w);
//    }

    public static void main(String[] args) {
        int[] hand = new int[]{1,2,3,6,2,3,4,7,8};
        int w = 3;
        System.out.println(isNStraightHand2(hand, w));
    }
}
