package Contest_87;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/6/3.
 */
public class BackspaceStringCompare_844 {
    public static boolean backspaceCompare2(String S, String T) {
        LinkedList<Character> forS = new LinkedList<>();
        LinkedList<Character> forT = new LinkedList<>();

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c != '#') forS.addLast(c);
            else if (!forS.isEmpty()){
                forS.removeLast();
            }
        }

        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c != '#') forT.addLast(c);
            else if (!forT.isEmpty()){
                forT.removeLast();
            }
        }

        if (forS.size() != forT.size()) return false;
        for (int i = 0; i < forS.size(); i++) {
            if (forS.get(i) != forT.get(i)) return false;
        }

        return true;
    }

        public static boolean backspaceCompare(String S, String T) {
        int ls = S.length();
        int lt = T.length();
        if (ls == 0 && lt == 0) return true;

        StringBuilder sb = new StringBuilder(S);
        StringBuilder st = new StringBuilder(T);

        String sm = back(sb);
        String tm = back(st);
        //System.out.println(sm);
        //System.out.println(tm);
        if (!sm.equals(tm)) return false;

        return true;
    }

    public static String back(StringBuilder s){

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '#') {
                    if (i != 0) {
                        s.deleteCharAt(i);
                        s.deleteCharAt(i - 1);
                    } else {
                        s.deleteCharAt(0);
                    }
                    //System.out.println(s.length());
                    //System.out.println(s);
                    back(s);
                }
            }

        return s.toString();
    }

    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        System.out.println(backspaceCompare(s, t));
    }
}
