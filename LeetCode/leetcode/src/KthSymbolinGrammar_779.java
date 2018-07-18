import java.util.LinkedList;

/**
 * Created by Administrator on 2018/2/4.
 */
public class KthSymbolinGrammar_779 {
    public static int kthGrammar(int N, int K) {
        LinkedList<Integer> helper = new LinkedList<>();
        while (N > 1){
            if ((K & 1) == 1)   helper.addFirst(-2);
            else                helper.addFirst(2);

            N--;
            K = (K + 1) / 2;
        }

        int root = 0;
        while (!helper.isEmpty()){
            int cur = helper.removeFirst();
            root = child(root,cur);
        }

        return root;
    }

    public static int child(int root, int who){
        if (root == 0){
            if (who == -2)  return 0;
            else            return 1;
        }
        else{
            if (who == -2)  return 1;
            else            return 0;
        }
    }

}
