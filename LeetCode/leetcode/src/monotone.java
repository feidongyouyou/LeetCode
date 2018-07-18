import java.util.Scanner;

class MonotoneIncreasingDigits {
    public static int monotoneIncreasingDigits(int N) {
        return b(N);
    }
    public static int a(int N){
        if(N < 10) return N;
        if(N > 9) {
            for (int i = N; i > 9; i--) {
                if (isIncreasingDigits(i)) return i;
            }
        }
        return 9;

    }

    public static boolean isIncreasingDigits(int N){
        String s = String.valueOf(N);

        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i-1) > s.charAt(i)) return false;
        }

        return true;
    }

    public static int b(int N){
        if(N < 10) return N;
        String source = String.valueOf(N);
        StringBuilder result = new StringBuilder(source);

        for (int i = 1; i < result.length(); i++) {
            if(result.charAt(i-1) <= result.charAt(i)) continue;
            else{
                int j;

                for(j = i-1; j>=0; j--){
                    if(result.charAt(j) < result.charAt(i-1))  break;
                }

                result.setCharAt(j+1, (char)(result.charAt(j+1)-1));

                for (int k = j + 2; k < result.length(); k++) {
                    result.setCharAt(k,'9');
                }


            }
        }
        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            int mm = Integer.parseInt(cin.nextLine());

            System.out.println("***" + monotoneIncreasingDigits(mm));
        }
    }
}