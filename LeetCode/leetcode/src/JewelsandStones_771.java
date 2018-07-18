/**
 * Created by Administrator on 2018/1/28.
 */
public class JewelsandStones_771 {
    public int numJewelsInStones(String J, String S) {
        int count =0;
        char[] jchar =J.toCharArray();
        char[] schar =S.toCharArray();
        for(char je : jchar){
            for(char se : schar){
                if(je == se) count++;
            }
        }
        return count;
    }
}
