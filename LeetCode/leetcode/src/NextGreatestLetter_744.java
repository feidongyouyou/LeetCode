import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/12.
 */
public class NextGreatestLetter_744 {
    public char nextGreatestLetter(char[] letters, char target) {

        for(int i = 0; i < letters.length; i++){
            if((int)letters[i] > (int)target) return letters[i];
        }
        return letters[0];
    }
}
