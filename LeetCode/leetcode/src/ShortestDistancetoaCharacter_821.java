/**
 * Created by Administrator on 2018/4/23.
 */
public class ShortestDistancetoaCharacter_821 {
    public static int[] shortestToChar(String S, char C) {
        int len = S.length();
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            char c = S.charAt(i);
            if (c == C) {
                result[i] = 0;
                continue;
            }
            int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0 ; j--) {
                char compareL = S.charAt(j);
                if (compareL == C) {
                    left = i - j;
                    break;
                }
            }

            for (int j = i + 1; j < len ; j++) {
                char compareR = S.charAt(j);
                if (compareR == C) {
                    right = j - i;
                    break;
                }
            }

            result[i] = Math.min(left, right);
        }
        return result;
    }



}
