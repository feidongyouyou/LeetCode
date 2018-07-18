import java.util.LinkedList;
import java.util.Scanner;

/**
 *Created by Administrator on 2018/5/12.
 */
public class ZhuShi {
    public static void main(String[] args) {
        int result = 0;
        Scanner in = new Scanner(System.in);
        LinkedList<Character> stack = new LinkedList<>();
        while(in.hasNext()){
            String line = in.nextLine().trim();
            int len = line.length();
            for (int i = 0; i < len; i++) {
                if (line.contains("//")) result++;
                if ((line.charAt(i) == '/') && (line.charAt(i + 1) == '*')){
                    stack.push(line.charAt(i));
                    stack.push(line.charAt(i + 1));

                }else if ((line.charAt(i) == '*') && (line.charAt(i + 1) == '/')){
                    if (stack.peek().equals(line.charAt(i)) && (stack.get(stack.size() - 2).equals(line.charAt(i + 1)))){
                        result++;
                        stack.pop();
                        stack.pop();
                    }
                }

            }
        }
        System.out.print(result);
    }
}
