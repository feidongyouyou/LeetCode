class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        for(int i = 0; i < temperatures.length;i++){
            for(int j = i + 1; j <temperatures.length; j++){
                if(temperatures[j] > temperatures[i]){
                    days[i] = j - i;
                    break;
                }else{
                    days[i] = 0;
                }
            }
        }
        return days;
    }
}