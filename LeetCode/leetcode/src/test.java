/**
 * Created by Administrator on 2018/3/11.
 */
public class test {
    public static void swap(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    public static void main (String[] args) {
        int a = 5, b = 10;
        swap(a, b);
        // a = 10, b = 5;
        System.out.print(a);
    }
}
