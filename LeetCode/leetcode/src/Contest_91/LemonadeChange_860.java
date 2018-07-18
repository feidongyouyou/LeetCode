package Contest_91;

/**
 * Created by Administrator on 2018/7/1.
 */
public class LemonadeChange_860 {
    public static boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) return false;
        //记录5块和10块的数量
        int no5 = 0, no10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5){
                no5++;
            }else if (bills[i] == 10){
                if (no5 >= 1){
                    no10++;
                    no5--;
                }else return false;
            }else {
                if (no10 >= 1 && no5 >= 1){
                    no5--;
                    no10--;
                }else if (no5 >=3){
                    no5 -= 3;
                }else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println(lemonadeChange(bills));
    }
}
