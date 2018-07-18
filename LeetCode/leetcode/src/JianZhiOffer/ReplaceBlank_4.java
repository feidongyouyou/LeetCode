package JianZhiOffer;

/**
 * Created by Administrator on 2018/7/9.
 */
public class ReplaceBlank_4 {
    public static String replaceSpace(StringBuffer str) {
        if (str == null) return null;
        if (str.length() == 0) return str.toString();
        int len = str.length();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (c != ' '){
                result.append(c);
            }else {
                result.append('%');
                result.append('2');
                result.append('0');
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        StringBuffer s1 = new StringBuffer("wearehappy.");
        StringBuffer s2 = null;
        StringBuffer s3 = new StringBuffer("");
        StringBuffer s4 = new StringBuffer(" we   are happy. ");
        System.out.println(replaceSpace(s3));
    }
}
