import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/12/30.
 */
public class OpentheLock_752 {
    public static int openLock(String[] deadends, String target) {
        LinkedList<String> helper = new LinkedList<>();

        helper.addLast("0000");
        helper.addLast("end");
        int steps = 0;
        HashSet<String> visited = new HashSet<>();
        while(!helper.isEmpty()){
            String current = helper.removeFirst();
            if (current.equals("end")){
                if (!helper.isEmpty()) {
                    steps++;
                    helper.addLast("end");
                }
            }
            else if (current.equals(target)){
                return steps;
            }
            else if(!visited.contains(current) && !isDeathP(current, deadends)){
                visited.add(current);

                StringBuilder sb;
                for (int i = 0; i < 4; i++) {

                    sb = new StringBuilder(current);
                    sb.setCharAt(i,minus(sb.charAt(i)));
                    if (!visited.contains(sb.toString()))   helper.addLast(sb.toString());

                    sb = new StringBuilder(current);
                    sb.setCharAt(i,add(sb.charAt(i)));
                    if (!visited.contains(sb.toString()))   helper.addLast(sb.toString());
                }
                //here
            }
        }

        return -1;
    }

    public static boolean isDeathP(String cur, String[] deads){
        for (int i = 0; i < deads.length; i++) {
            if(cur.equals(deads[i])) return true;
        }
        return false;
    }
    public static char add(char target){
        if (target == '9')  return '0';
        return (char)(target + 1);
    }
    public static char minus(char target){
        if(target == '0')   return '9';
        return (char)(target - 1);
    }

    public static void main(String[] args){
        String[] test = new String[]{
                "2110","2000","0000","2111","1110"
        };
        String target = "0012";
        System.out.println(openLock(test,target));
    }
}
/**
 *
 //                helper.addLast(minus(current.charAt(0)) + current.substring(1));
 //                helper.addLast(add(current.charAt(0)) + current.substring(1));
 //
 //                helper.addLast("" + current.charAt(0) + minus(current.charAt(1)) + current.substring(2));
 //                helper.addLast("" + current.charAt(0) + add(current.charAt(1)) + current.substring(2));
 //
 //                helper.addLast(current.substring(0,2) + minus(current.charAt(2)) + current.charAt(3));
 //                helper.addLast(current.substring(0,2) + add(current.charAt(2)) + current.charAt(3));
 //
 //                helper.addLast(current.substring(0,3) + minus(current.charAt(3)));
 //                helper.addLast(current.substring(0,3) + add(current.charAt(3)));
 */