/**
 * Created by Administrator on 2018/3/18.
 */
public class SimilarRGBColor_800 {
    public static String similarRGB(String color) {
        String c1 = color.substring(1,3);
        String c2 = color.substring(3,5);
        String c3 = color.substring(5,7);

        return "#" + similar(c1) + similar(c2) + similar(c3);
    }

    public static String similar(String s){
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(s, 16);//s = "1a"
        int min = Integer.MAX_VALUE;
        int key = -1;
        for (int i = 0; i < 16; i++) {//"ii"
            if (Math.abs(17 * i - num) < min){
                min = Math.abs(17 * i - num);
                key = i;
            }
        }
//        if (key < 10) sb.append("" + key + key);
        switch (key){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:sb.append("" + key + key);break;
            case 10: sb.append("aa");break;
            case 11: sb.append("bb");break;
            case 12: sb.append("cc");break;
            case 13: sb.append("dd");break;
            case 14: sb.append("ee");break;
            case 15: sb.append("ff");break;
        }
        return sb.toString();
    }


    public static void main (String[] args){
        String s = "#09f166";
        System.out.print(similarRGB(s));
    }
}
