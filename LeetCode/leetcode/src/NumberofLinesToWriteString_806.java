/**
 * Created by Administrator on 2018/3/28.
 */
public class NumberofLinesToWriteString_806 {
    public static int[] numberOfLines(int[] width, String S){
        int[] result = new int[2];
        int lines = 1, lastUnits = 0;

        int sumUnits = 0;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int j = c - 97;
            if(width[j] + sumUnits <= 100){
                sumUnits += width[j];
            }else{
                lines++;
                sumUnits = width[j];
            }
        }
        lastUnits = sumUnits;
        result[0] = lines;
        result[1] = lastUnits;

        return result;
    }
}
