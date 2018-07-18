package NowCodeMoNi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/6/14.
 */
//贪心解法，参考算法导论中的活动选择问题
public class NiuNiuShowClass {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

//        int n = cin.nextInt(); //报错
        //  Exception in thread "main" java.lang.NumberFormatException: For input string: ""

        int n = Integer.parseInt(cin.nextLine().trim()); //不用trim可能报错
        Show[] shows = new Show[n];
        for (int i = 0; i < n; i++){
            String[] times = cin.nextLine().trim().split(" ");
            int start = Integer.parseInt(times[0]);
            int duration = Integer.parseInt(times[1]);
            shows[i] = new Show(start, start + duration);
        }
        Arrays.sort(shows);    //将所有表演按照结束时间排序

        int sum = 1;
        int currentEndTime = shows[0].end;   //最早结束的表演必然存在于某个最优解中，第一个自动加入
        for (int i = 1; i < n; i++) {
            if (shows[i].start >= currentEndTime){   //后面的开始时间晚于当前段的结束时间，可加入
                currentEndTime = shows[i].end;
                sum++;
            }
        }
        System.out.println(sum);
    }
}

class Show implements Comparable<Show>{
    public int start;
    public int end;

    public Show(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Show o) {   //按结束时间排序，若结束时间相等，开始时间晚的在后
        int key = end - o.end;
        if (key != 0) return key;
        return start - o.start;
    }

//    @Override
//    public String toString() {
//        return "Show{" +
//                "start=" + start +
//                ", end=" + end +
//                '}';
//    }
}
