package JianZhiOffer;
import java.util.EmptyStackException;
import java.util.Stack;
/**
 * Created by Administrator on 2018/7/9.
 */

//面试题7：用2个栈模拟一个队列，
// push时直接入栈1，
// pop时先把所有值压入栈2，栈2顶的值就是要出队列的值，再把栈2中所有值压回栈1
public class StackToQueue_7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.add(node);
        return;
    }

    // pop时先把所有值压入栈2，栈2顶的值就是要出队列的值，再把栈2中所有值压回栈1
    public int pop01() {
        if (stack1.isEmpty()) {
            throw new EmptyStackException();
        }
        while (!stack1.isEmpty()){
            int p = stack1.pop();
            stack2.add(p);
        }
        int out = stack2.pop();
        while (!stack2.isEmpty()){
            int back = stack2.pop();
            stack1.add(back);
        }
        return out;
    }
    //直接pop栈2顶部的值，就是要出队的值，栈2为空之前不可再入栈
    public int pop02(){
        if (stack2.isEmpty() && stack1.isEmpty()) {
            throw new EmptyStackException();
        }
        if (!stack2.isEmpty()) {
            int out = stack2.pop();
            return out;
        }else {
            while (!stack1.isEmpty()) {
                int p = stack1.pop();
                stack2.add(p);
            }
            int out = stack2.pop();
            return out;
        }
    }



    public static void main(String[] args) {
        StackToQueue_7 q = new StackToQueue_7();
        q.push(0);
        q.push(1);
        q.push(2);
        q.pop01();
        q.pop01();

        System.out.println(q.pop01());
    }
}
