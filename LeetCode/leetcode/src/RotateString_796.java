/**
 * Created by Administrator on 2018/3/11.
 */
public class RotateString_796 {
    public static boolean rotateString(String A, String B) {
        if(A.equals(B)) return true;

        if(A.length() != B.length()) return false;

        for (int i = 0; i < A.length(); i++) {
            A = shiftString(A);
            System.out.println(A);
            if(A.equals(B)) return true;
        }
        return false;
    }

    public static String shiftString(String s){
        StringBuilder str = new StringBuilder(s);
        char a = str.charAt(0);
        str.deleteCharAt(0);
        str.append(a);
        return str.toString();
    }

    public static void main(String[] args){
        String A = "abcde";
        String B = "cdeab";
        System.out.print(rotateString(A, B));
    }

}
