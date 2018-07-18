import java.util.LinkedList;

/**
 * Created by Administrator on 2017/12/6.
 */
public class DailyTemperatures_739 {
    public static int[] dailyTemperatures(int[] temperatures){
        int l = temperatures.length;
        int[] result = new int[l];
        LinkedList<Node> stack = new LinkedList<Node>();
        for (int i = 0; i < l-1; i++) {
            if(temperatures[i] < temperatures[i+1]){
                result[i] = 1;

                while(!stack.isEmpty()){
                    Node t = stack.element();
                    if(t.val < temperatures[i+1]){
                        result[t.index] = i+1-t.index;
                        stack.pop();
                    }
                    else break;
                }
            }else{
                stack.push(new Node(temperatures[i],i));
            }
        }
        while(!stack.isEmpty()){
            Node m = stack.pop();
            result[m.index] = 0;
        }
        return result;
    }
}

class Node{
    int val;
    int index;

    public Node(int val,int index){
        this.val = val;
        this.index = index;
    }
}