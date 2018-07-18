import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class kuaiShou01 {
    public static void main (String[] args){
        Scanner cin = new Scanner(System.in);
        String line = cin.nextLine();
        StringBuilder result = new StringBuilder();
        if (line.length() == 5){

                result.append(line.charAt(0));
                result.append('W');
                result.append(line.charAt(1));
                result.append('Q');
                result.append(line.charAt(2));
                result.append('B');
                result.append(line.charAt(3));
                result.append('S');
                result.append(line.charAt(4));
        }else if (line.length() == 4){
            result.append(line.charAt(0));
            result.append('Q');
            result.append(line.charAt(1));
            result.append('B');
            result.append(line.charAt(2));
            result.append('S');
            result.append(line.charAt(3));
        }else if (line.length() == 3){
            result.append(line.charAt(0));
            result.append('B');
            result.append(line.charAt(1));
            result.append('S');
            result.append(line.charAt(2));
        }else if(line.length() == 2){
            result.append(line.charAt(0));
            result.append('S');
            result.append(line.charAt(1));
        }else if(line.length() == 1){
            if(line.equals("0")) result.append('L');
            else {
                result.append(line.charAt(0));
            }
        }
        System.out.print(result.toString());

    }
}
