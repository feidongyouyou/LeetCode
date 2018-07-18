package Contest_93;

/**
 * Created by Administrator on 2018/7/15.
 */
public class BinaryGap_868 {
    public static int binaryGap(int N) {
        String binaryStr = Integer.toBinaryString(N);
        int maxDistance = 0;
        int start = 0;
        int end;
        for (int i = 0; i < binaryStr.length(); i++) {

            if (binaryStr.charAt(i) == '1'){
                end = i;
                if (end - start > maxDistance){
                    maxDistance = end - start;
                }
                start = i;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }
}
