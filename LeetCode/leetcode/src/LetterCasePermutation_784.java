import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/2/18.
 */
public class LetterCasePermutation_784 {
    public List<String> letterCasePermutation(String S) {

        List<String> result = new ArrayList<String>();
        result.add(0, S);

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(isLetter(c)){
                for (String s : result) {
                    String str = s;
                    char m = str.charAt(i);
                    if(m >= 'a')  m = (char)(m - 32);
                    if(m <= 'Z')  m = (char)(m + 32);
                    result.add(str);
                }
            }
        }
        return result;
    }

    public static boolean isLetter(char chr){
        if((chr >= 'a' && chr <= 'z') || (chr >= 'A' && chr <= 'Z')){
            return true;
        }else
            return false;
    }
}
