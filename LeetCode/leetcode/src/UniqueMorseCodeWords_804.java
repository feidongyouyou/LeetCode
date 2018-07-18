import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2018/3/29.
 */
public class UniqueMorseCodeWords_804 {
    public static int uniqueMorseRepresentations(String[] words){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            words[i] = transformation(words[i]);
            set.add(words[i]);
        }

        return set.size();
    }

    public static String transformation(String word){
        String[] trans = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String sUnit = "";
        for (int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);
            int n = c - 97;
            sUnit = sUnit + trans[n];
        }
        return sUnit;
    }
}
