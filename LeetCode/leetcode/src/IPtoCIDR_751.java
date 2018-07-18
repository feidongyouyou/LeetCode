import org.omg.PortableInterceptor.INACTIVE;
import org.omg.PortableInterceptor.Interceptor;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/30.
 */
public class IPtoCIDR_751 {
    public static List<String> ipToCIfDR(String ip, int n) {
        List<String> result = new LinkedList<>();

        String detailIP = "";
        String[] ipParts = ip.split("\\.");
        for (int i = 0; i < ipParts.length; i++) {
            String current = Integer.toBinaryString(Integer.parseInt(ipParts[i]));
            String addZeros = "";
            for (int j = 0; j < 8 - current.length(); j++) {
                addZeros += "0";
            }
            detailIP += addZeros + current;
        }


        StringBuilder sb = new StringBuilder(detailIP);
        result.add(sb + "/32");
        for (int i = 1; i < n; i++) {
            sb.setCharAt(31,(char)(sb.charAt(31) + 1));
            for (int j = 31; j >= 0 ; j--) {
                if (sb.charAt(j) == '2'){
                    sb.setCharAt(j,'0');
                    sb.setCharAt(j - 1,(char)(sb.charAt(j - 1) + 1));
                }
                else{
                    break;
                }
            }

            result.add(sb + "/32");
        }

        int merge = 1;
        for (;merge != 0;) {
            merge = 0;
            for (int i = 0; i < result.size() - 1; i++) {
                String cur = result.get(i);
                String next = result.get(i + 1);
                int curI = Integer.parseInt(cur.substring(33,35));
                int nextI = Integer.parseInt(next.substring(33,35));
                if (curI == nextI && cur.substring(0,curI - 1).equals(next.substring(0,curI - 1))){
                    cur = cur.substring(0,32) + "/" + (curI - 1);
                    result.set(i,cur);
                    result.remove(i + 1);
                    merge++;
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            String cur = result.get(i);
            String t = "";
            for (int j = 0; j < 4; j++) {
                t += Integer.parseInt(cur.substring(j * 8,(j + 1) * 8),2) + ".";
            }
            result.set(i,t.substring(0,t.length() - 1) + "/" + cur.substring(33,35));
        }

        return result;
    }

    public static void main(String[] args){
        System.out.println(ipToCIfDR("255.0.0.7",10));


    }
}