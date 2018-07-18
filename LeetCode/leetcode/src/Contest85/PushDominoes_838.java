package Contest85;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/5/20.
 */
public class PushDominoes_838 {
    public static String pushDominoes2(String dominoes) {
        StringBuilder sb = new StringBuilder(dominoes.replaceAll("R\\.\\.L","RRLL"));

        int actionsFromL = 0,actionsFromR = 100;
        for (int i = 0;; i++) {
            if ((i & 1) == 0) {
                actionsFromL = 0;
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == 'L' && isLegal(sb,j - 1) && sb.charAt(j - 1) == '.') {
                        if (isLegal(sb,j - 2) && sb.charAt(j - 2) == 'R'){}
                        else{
                            sb.setCharAt(j - 1,'L');
                            actionsFromL++;
                        }
                    }
                }
            }
            else {
                actionsFromR = 0;
                for (int j = 0; j < sb.length(); j++) {
                    if (sb.charAt(j) == 'R' && isLegal(sb,j + 1) && sb.charAt(j + 1) == '.'){
                        if (isLegal(sb,j + 2) && sb.charAt(j + 2) == 'L'){
                        }
                        else{
                            sb.setCharAt(j + 1,'R');
                            j++;
                            actionsFromR++;
                        }
                    }
                }

                sb = new StringBuilder(sb.toString().replaceAll("R\\.\\.L","RRLL"));
            }

            if (actionsFromL + actionsFromR == 0)   break;
        }

        return sb.toString();
    }

    public static boolean isLegal(StringBuilder sb,int index) {
        if (index >= 0 && index < sb.length()) return true;
        return false;
    }



    public static String pushDominoes(String dominoes) {
        StringBuilder result = new StringBuilder();
        LinkedList<Direction> domi = new LinkedList<>();
        for (int i = 0; i < dominoes.length(); i++) {
            char current = dominoes.charAt(i);
            if ((current == 'L') || (current == 'R')) {
                Direction d = new Direction(current, i);
                domi.add(d);
;
            }
        }
        if (domi.size() == 0)   return dominoes;

        if (domi.getFirst().dir == 'L') {
            multiAppend(result,domi.getFirst().index,'L');
        }else{
            multiAppend(result,domi.getFirst().index,'.');
        }

        for (int i = 0; i + 1 < domi.size(); i++) {
            char cur = domi.get(i).dir;
            char next = domi.get(i + 1).dir;
            int curIndex = domi.get(i).index;
            int nextIndex = domi.get(i + 1).index;
            if (cur == next){
                multiAppend(result,nextIndex - curIndex,cur);
            }else if ((cur == 'L') && (next == 'R')){
                result.append('L');
                multiAppend(result,nextIndex - curIndex - 1,'.');
            }else if ((cur == 'R') && (next == 'L')){
                result.append('R');
                int m = nextIndex - curIndex - 1;
                if ((m % 2) == 0) {
                    multiAppend(result,m / 2,'R');
                    multiAppend(result,m / 2,'L');

                }else{
                    multiAppend(result,m / 2,'R');
                    result.append('.');
                    multiAppend(result,m / 2,'L');
                }
            }
        }

        if (domi.getLast().dir == 'R'){
            multiAppend(result,dominoes.length() - domi.getLast().index,'R');
        }else {
            result.append('L');
            multiAppend(result,dominoes.length() - domi.getLast().index - 1,'.');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = ".";
        System.out.println(pushDominoes(s));
    }

    public static void multiAppend(StringBuilder res, int len, char c){
        for (int i = 0; i < len; i++) {
            res.append(c);
        }
    }

}

class Direction{
    char dir;
    int index;

    public Direction(char dir, int index) {
        this.dir = dir;
        this.index = index;
    }
}