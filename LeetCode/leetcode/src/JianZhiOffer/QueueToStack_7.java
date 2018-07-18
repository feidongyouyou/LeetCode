package JianZhiOffer;

import java.util.ArrayDeque;
import java.util.EmptyStackException;
import java.util.Queue;

/**
 * Created by Administrator on 2018/7/10.
 */
public class QueueToStack_7 {
    Queue<Integer> queue1 = new ArrayDeque<>();
    Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int node){
        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(node);
            return;
        }
        if (!queue1.isEmpty()){
            queue1.add(node);
            return;
        }
        if (!queue2.isEmpty()){
            queue2.add(node);
            return;
        }
    }

    public int pop(){
        if (queue1.isEmpty()&& queue2.isEmpty()){

            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }

        }
        //队列1空。队列2不空
        if (queue1.isEmpty()){

            while (queue2.size() > 1){
                int p = queue2.poll();
                queue1.add(p);
            }

            return queue2.poll();
        }


        //队列2空。队列1不空
        if (queue2.isEmpty()){

            while (queue1.size() > 1){
                int p = queue1.poll();
                queue2.add(p);
            }

            return queue1.poll();
        }

        return (Integer)null;
    }

    public static void main(String[] args) {
        QueueToStack_7 q = new QueueToStack_7();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);

        q.pop();
        q.pop();
        q.pop();
        q.pop();

        System.out.println(q.pop());
    }
}
