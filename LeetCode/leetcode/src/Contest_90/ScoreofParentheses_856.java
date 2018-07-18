package Contest_90;

import DataStructure.LinkedList.LinkList;

import java.util.LinkedList;

/**
 * Created by Administrator on 2018/6/24.
 */
public class ScoreofParentheses_856 {
    public static int scoreOfParentheses(String S) {
        if (S.length() == 0) return 0;
        LinkedList<Integer> par = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur == '('){
                par.addLast(0);
            }else {
                int top = par.peekLast();
//                int behind = par.get(par.size() - 2);
//                if (top != 0 && behind != 0){
//                    int sum = top + behind;
//                    par.removeLast();
//                    par.removeLast();
//                    par.addLast(sum);
//                }
                if (top == 0){
                    par.removeLast();
                    par.addLast(1);
                    if (par.size() > 1 && par.peekLast() != 0 && par.get(par.size() - 2) != 0){
                        int sum = par.peekLast() + par.get(par.size() - 2);
                        par.removeLast();
                        par.removeLast();
                        par.addLast(sum);
                    }
                }else{
                    int product = top * 2;
                    par.removeLast();
                    par.removeLast();
                    par.addLast(product);
                    if (par.size() > 1 &&par.peekLast() != 0 && par.get(par.size() - 2) != 0){
                        int sum = par.peekLast() + par.get(par.size() - 2);
                        par.removeLast();
                        par.removeLast();
                        par.addLast(sum);
                    }
                }
            }
        }
        return par.get(0);
    }

    public static void main(String[] args) {
        String S = "(()(()))";
        System.out.println(scoreOfParentheses(S));
    }
}
