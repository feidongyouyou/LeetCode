package Contest_90;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/6/24.
 */
public class BuddyStrings_859 {
    public static boolean buddyStrings(String A, String B) {
        if (A.length() <= 1 || B.length() <= 1) return false;
        if (A.equals(B)){
            for (int i = 0; i < A.length(); i++) {
                for (int j = i+1; j < A.length(); j++) {
                    if (A.charAt(i) == A.charAt(j)){
                        return true;
                    }
                }
            }
            return false;
        }else {
            ArrayList<Character> swA = new ArrayList<>();
            ArrayList<Character> swB = new ArrayList<>();

            int n = 0;
            for (int i = 0; i < A.length(); i++) {
                char a = A.charAt(i);
                char b = B.charAt(i);
                if (a != b){
                    swA.add(a);
                    swB.add(b);
                }
            }

            if (swA.get(0) != swB.get(1) || swA.get(1) != swB.get(0)){
                return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String A = "ab";
        String B = "ab";
        System.out.println(buddyStrings(A, B));
    }
}
