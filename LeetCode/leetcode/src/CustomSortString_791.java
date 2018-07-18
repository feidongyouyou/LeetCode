import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/3/9.
 */
public class CustomSortString_791 {
    public String customSortString(String S, String T) {
//        StringBuffer result = new StringBuffer();
//
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < T.length(); i++) {
//            char current = T.charAt(i);
//            if(map.containsKey(current)){
//                map.put(current, map.get(current) + 1);
//            }else{
//                map.put(current, 0);
//            }
//        }
//
//        for (int j = 0; j < S.length(); j++) {
//            char cur = S.charAt(j);
//            for (int n = 0; n < map.get(cur); n++) {
//                result.append(cur);
//            }
//        }
//
//        for (int m = 0; m < T.length(); m++) {
//            if(!S.contains(T.substring(m, m + 1))){
//                result.append(T.charAt(m));
//            }
//        }
//
//        return result.toString();


        StringBuffer result = new StringBuffer();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        Map<Integer, Character> maap = new HashMap<Integer, Character>();
        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), i);
            maap.put(i, S.charAt(i));
        }

        ArrayList<Integer> number = new ArrayList<>();
        ArrayList<Character> letter = new ArrayList<>();

        for (int j = 0; j < T.length(); j++) {
            if(S.contains(T.substring(j, j + 1))){
                number.add(map.get(T.charAt(j)));
            }else{
                letter.add(T.charAt(j));
            }
        }

        Collections.sort(number);

        for (int n = 0; n < number.size(); n++) {
            result.append(maap.get(number.get(n)));
        }

        for (int m = 0; m < letter.size(); m++) {
            result.append(letter.get(m));
        }

        return result.toString();
    }
}
