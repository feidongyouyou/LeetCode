/**
 * Created by Administrator on 2017/12/23.
 */
public class ShortestCompletingWord_748 {
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        //挑出licensePlate中的字母，并记录每个字母的个数
        int[] schema = new int[26]; //用下标代表26个字母
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length(); i++) {
            if(licensePlate.charAt(i) >= 'a' && licensePlate.charAt(i) <= 'z') {
                schema[licensePlate.charAt(i) - 'a']++;
            }
        }
        //找出words数组中满足条件并且长度最短的单词
        String result = null;
        int len = Integer.MAX_VALUE;
        int[] helper = new int[26];
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() < len && isMatch(schema, helper,words[i])){
                result = words[i];
                len = words[i].length();
            }
        }

        return result;


    }
    //判断该单词是否包含licensePlate内的所有字母
    public static boolean isMatch(int[] schema, int[] ttt,String sss){
        for (int i = 0; i < 26; i++) {
            ttt[i] = 0;
        }

        for (int i = 0; i < sss.length(); i++) {
            if(sss.charAt(i) >= 'a' && sss.charAt(i) <= 'z'){
                ttt[sss.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if(ttt[i] < schema[i]) return false;
        }
        return true;


    }
}
