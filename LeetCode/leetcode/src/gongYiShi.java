import java.util.Scanner;

public class gongYiShi {
    public static void main(String[] args) {
        int result = 0;
        Scanner in = new Scanner(System.in);
        String kongXian = in.nextLine();
        String gongYi = in.nextLine();
        String[][] present = splitString(kongXian);
        String[][] gong = splitString(gongYi);

        for (int i = 0; i < present.length; i++) {
            for (int j = 0; j < gong.length; j++) {
                String[] p = present[i];
                String[] g = gong[j];

                if ((p[0] == g[0]) && (p[3] == g[3]) && (Integer.parseInt(p[1]) <= Integer.parseInt(g[1])) && (Integer.parseInt(p[2]) >= Integer.parseInt(g[2]))){
                    result += Integer.parseInt(g[4]);
                }
            }
        }
        System.out.println(result);
    }

    public static String[][] splitString(String s){
        String[] S = s.toLowerCase().split(";");
        String[][] re = new String[S.length][];
        for (int i = 0; i < S.length; i++) {
            re[i] = S[i].split(":-");
        }
        return re;
    }
}
