/**
 * Created by Administrator on 2018/1/8.
 */
public class BoldWordsInString_758 {
    public String boldWords(String[] words, String S) {
        if(words == null || words.length == 0) return "";

        boolean[] marked = new boolean[S.length()];
        for (String word : words) {
            mark(word, S, marked);
        }

        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(marked[i] && (i == 0 || !marked[i - 1])) ss.append("<b>");
            ss.append(S.charAt(i));
            if(marked[i] && (i == S.length()-1 || !marked[i + 1])) ss.append("</b>");
        }
        return ss.toString();
    }

    public static void mark(String word,String S, boolean[] marked){
        for (int i = 0; i <= S.length() - word.length(); i++) {
            String sub = S.substring(i, i + word.length());
            if(sub.equals(word)){
                for (int j = i; j < i + word.length(); j++) {
                    marked[j] = true;
                }
            }
        }
    }

}
