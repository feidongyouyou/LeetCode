package NowCodeMoNi;

import java.util.LinkedList;
import java.util.Scanner;

//暴力求解
public class NiuNiuShow {
    public static void main(String[] args) {
        long count = 0;
        Scanner cin = new Scanner(System.in);
        long n = cin.nextInt();
        LinkedList<Long> time = new LinkedList<>();
        LinkedList<Long> minute = new LinkedList<>();

        for(long i = 0; i < n; i++){
            long t = cin.nextInt();
            long m = cin.nextInt();
            time.add(t);
            minute.add(m);

        }

        long minTime = 0;
        long currentTime = 0;
        while (!time.isEmpty()) {
            int index = findMin(time, minute);
            minTime = time.get(index);
            if (minTime >= currentTime){
                currentTime = minTime + minute.get(index);
                time.remove(minTime);
                minute.remove(currentTime);
                count++;
            }
        }
        System.out.println(count);
    }

    public static int findMin(LinkedList<Long> time, LinkedList<Long> minute){
        int index = 0;
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < time.size(); i++) {
            long t = time.get(i);
            long m = minute.get(i);
            if (t < min){
                min = t;
                index = i;
            }else if (t == min){
                if (m < minute.get(time.indexOf(min))){
                    index = i;
                }else {
                    index = time.indexOf(min);
                }
            }
        }
        return index;
    }


}
