package DataStructure.Search;

/**
 * Created by Administrator on 2018/7/11.
 */
public class SequentialSearch {
    //顺序比较，每次都要注意数组是否越界
    public static int sequentialSearch(int[] a, int key){
        int len = a.length;
        for (int i = 0; i < len; i++) {
            if (a[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int betterSequentialSearch(int[] a, int key){
        int len = a.length;
        a[-1] = key;  //在查找尽头放置哨兵，-1为越界下标，此处仅示意
        int i = len - 1;
        while (a[i] != key){
            i--;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int key = 4;
        System.out.println(betterSequentialSearch(a, key));
    }
}
