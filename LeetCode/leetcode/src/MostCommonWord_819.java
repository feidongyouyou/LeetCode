import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/16.
 */
public class MostCommonWord_819 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] pa = paragraph.toLowerCase().split("[ !?',;.]+");
        Map<String, Integer> nums = new HashMap<>();

        for (int i = 0; i < pa.length; i++) {

                if (nums.containsKey(pa[i])) {
                    nums.put(pa[i], nums.get(pa[i]) + 1);
                } else {
                    nums.put(pa[i], 1);
                }
        }

        for (int i = 0; i < banned.length; i++) {
            if (nums.containsKey(banned[i])) nums.remove(banned[i]);
        }

        int max = Integer.MIN_VALUE;
        String res = null;
        for (String s : nums.keySet()){
            if (res == null || nums.get(s) > nums.get(res)) {
                res = s;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(s, banned));
    }


}
